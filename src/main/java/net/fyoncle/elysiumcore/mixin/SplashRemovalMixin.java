package net.fyoncle.elysiumcore.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.SplashTextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashTextRenderer.class)
public class SplashRemovalMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(DrawContext context, int screenWidth, TextRenderer textRenderer, int alpha, CallbackInfo ci) {
        ci.cancel();
    }
}
