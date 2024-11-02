package net.fyoncle.elysiumdaystweaks.mixin;

import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class CustomTitleMixin {
    @Inject(
            at = @At("RETURN"),
            method = "getWindowTitle",
            cancellable = true)
    private void getWindowTitle(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(Constants.Core.ELYSIUM_DAYS_WINDOW_TITLE);
    }
}
