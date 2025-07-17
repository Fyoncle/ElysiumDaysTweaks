package net.fyoncle.elysiumcore.mixin;

import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value= ResourcePackProfile.class, priority = 9999)
public abstract class ResourcePackLock {
    private final String ED_RESOURCE_PACK = "elysiumcore:elysiumcore";
    private final String[] EXCLUDE_FROM_UNPIN_RPS = {
            ED_RESOURCE_PACK
    };

    @Shadow
    public abstract String getName();

    @Inject(at = @At("RETURN"), method = "getInitialPosition", cancellable = true)
    public void getInitialPosition(CallbackInfoReturnable<ResourcePackProfile.InsertionPosition> cir) {
        for (String excludeFromUnpinRp : EXCLUDE_FROM_UNPIN_RPS) {
            if (this.getName().equals(excludeFromUnpinRp)) {
                cir.setReturnValue(ResourcePackProfile.InsertionPosition.TOP);
            }
        }
    }

    @Inject(at = @At("RETURN"), method = "isPinned", cancellable = true)
    public void isPinned(CallbackInfoReturnable<Boolean> cir) {
        for (int i = 0; i < EXCLUDE_FROM_UNPIN_RPS.length; i++) {
            if (this.getName().equals(EXCLUDE_FROM_UNPIN_RPS[i])) {
                cir.setReturnValue(true);
            }
        }
    }
}
