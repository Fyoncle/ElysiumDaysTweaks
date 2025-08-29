package net.fyoncle.elysiumcore.mixin;

import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResourcePackProfile.class)
public abstract class ResourcePackPin {
    @Unique
    private final String[] PINNED_RPS = {
            "elysiumcore:elysiumcore"
    };

    @Shadow
    public abstract String getName();

    @Inject(method = "getInitialPosition", at = @At("HEAD"), cancellable = true)
    public void getInitialPosition(CallbackInfoReturnable<ResourcePackProfile.InsertionPosition> cir) {
        for (String pinnable : PINNED_RPS) {
            if (this.getName().equals(pinnable)) {
                cir.setReturnValue(ResourcePackProfile.InsertionPosition.TOP);
            }
        }
    }

    @Inject(method = "isPinned", at = @At("HEAD"), cancellable = true)
    public void isPinned(CallbackInfoReturnable<Boolean> cir) {
        for (String pinnable : PINNED_RPS) {
            if (this.getName().equals(pinnable)) {
                cir.setReturnValue(true);
            }
        }
    }
}