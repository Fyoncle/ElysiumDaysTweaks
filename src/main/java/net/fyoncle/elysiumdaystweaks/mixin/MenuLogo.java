package net.fyoncle.elysiumdaystweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fyoncle.elysiumdaystweaks.utility.constants.Textures;
import net.fyoncle.elysiumdaystweaks.utility.other.HolidayChecker;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LogoDrawer.class)
public class MenuLogo {
    @WrapOperation(
            method = "draw(Lnet/minecraft/client/gui/DrawContext;IFI)V",
            at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V")
    )
    public void elysiumDaysTweaks$drawCustomLogo(DrawContext instance, Identifier resourceLocation,
                                                 int i, int j, float f,
                                                 float g, int k,
                                                 int l, int m, int n, Operation<Void> original) {
        if(HolidayChecker.isHalloween()) {
            resourceLocation = Textures.ED_HALLOWEEN_LOGO;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        } else if(HolidayChecker.isChristmas()) {
            resourceLocation = Textures.ED_CHRISTMAS_LOGO;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        } else {
            resourceLocation = Textures.ED_DEFAULT_LOGO;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        }
    }

}