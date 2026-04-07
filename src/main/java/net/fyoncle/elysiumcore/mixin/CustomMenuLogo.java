package net.fyoncle.elysiumcore.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LogoDrawer.class)
public class CustomMenuLogo {
    @WrapOperation(
            method = "draw(Lnet/minecraft/client/gui/DrawContext;IFI)V",
            at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V")
    )
    public void elysiumCore$drawCustomLogo(DrawContext instance, Identifier resourceLocation,
                                           int i, int j, float f,
                                           float g, int k,
                                           int l, int m, int n, Operation<Void> original) {
        original.call(instance, Textures.ED_MENU_LOGO, i, j + 5, 0f, 0f, 256, 70, 256, 70);
    }

    @WrapOperation(
            method = "draw(Lnet/minecraft/client/gui/DrawContext;IFI)V",
            at = @At(value = "INVOKE", ordinal = 1, target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V")
    )
    public void elysiumCore$eraseEditionLogo(DrawContext instance, Identifier resourceLocation,
                                             int i, int j, float f,
                                             float g, int k,
                                             int l, int m, int n, Operation<Void> original) {
    }
}