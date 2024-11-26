package net.fyoncle.elysiumdaystweaks.mixin;

import net.minecraft.resource.ResourcePackInfo;
import net.minecraft.resource.ResourcePackPosition;
import net.minecraft.resource.ResourcePackProfile;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ResourcePackProfile.class)
public class ResourcePackLock {
    @Shadow @Final private ResourcePackInfo info;

    @Inject(at = @At("RETURN"), method = "getInitialPosition", cancellable = true)
    public void getPosition(CallbackInfoReturnable<ResourcePackProfile.InsertionPosition> cir) {
        if(this.info.id().equals("elysium-days-tweaks:elysiumdaystweaks")) {
            cir.setReturnValue(ResourcePackProfile.InsertionPosition.TOP);
        }
    }
    @Inject(at = @At("RETURN"), method = "isPinned", cancellable = true)
    public void isPinned(CallbackInfoReturnable<Boolean> cir) {
        if(this.info.id().equals("elysium-days-tweaks:elysiumdaystweaks")) {
            cir.setReturnValue(true);
        }
    }
}
