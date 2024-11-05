package net.fyoncle.elysiumdaystweaks.mixin;

import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResourcePackProfile.class)
public abstract class ResourcePackLock {
    @Shadow public abstract String getName();

    @Inject(at = @At("RETURN"), method = "getInitialPosition", cancellable = true)
    public void getInitialPosition(CallbackInfoReturnable<ResourcePackProfile.InsertionPosition> cir) {
        if(this.getName().equals("elysium-days-tweaks:elysiumdaystweaks")) {
            cir.setReturnValue(ResourcePackProfile.InsertionPosition.TOP);
        }
    }

    @Inject(at = @At("RETURN"), method = "isPinned", cancellable = true)
    public void isPinned(CallbackInfoReturnable<Boolean> cir) {
        if(this.getName().equals("elysium-days-tweaks:elysiumdaystweaks")) {
            cir.setReturnValue(true);
        }
    }
}
