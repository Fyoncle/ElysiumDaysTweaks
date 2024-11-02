// This code was written by JavaJumper and ShizoToaster.
// The Halloween and Christmas specific logo code and few other improvements on the code made possible by the helps of VipCoder.

package net.fyoncle.elysiumdaystweaks.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LogoDrawer;

@Mixin(LogoDrawer.class)
public class MenuLogo {
    Calendar d = Calendar.getInstance();
    boolean isChristmas = false;
    boolean isHalloween = false;

    private static final Identifier christmasLogo = new Identifier("elysium-days-tweaks", "logos/edchristmaslogo.png");
    private static final Identifier halloweenLogo = new Identifier("elysium-days-tweaks", "logos/edhalloweenlogo.png");
    private static final Identifier defaultLogo = new Identifier("elysium-days-tweaks", "logos/eddefaultlogo.png");
    @WrapOperation(
            method = "draw(Lnet/minecraft/client/gui/DrawContext;IFI)V",
            at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V")
    )
    public void elysiumDaysTweaks$drawCustomLogo(DrawContext instance, Identifier resourceLocation, int i, int j, float f, float g, int k, int l, int m, int n, Operation<Void> original) {
        d = Calendar.getInstance();
        isChristmas = (d.get(Calendar.DAY_OF_MONTH) >= 24 && d.get(Calendar.MONTH) == Calendar.DECEMBER)
                && (d.get(Calendar.DAY_OF_MONTH) <= 30 && d.get(Calendar.MONTH)==Calendar.DECEMBER);
        isHalloween = (d.get(Calendar.DAY_OF_MONTH) >= 1 && d.get(Calendar.MONTH) == Calendar.OCTOBER)
                && (d.get(Calendar.DAY_OF_MONTH) <= 31 && d.get(Calendar.MONTH)==Calendar.OCTOBER);

        if(isHalloween) {
            resourceLocation = halloweenLogo;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        } else if(isChristmas) {
            resourceLocation = christmasLogo;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        }
        else {
            resourceLocation = defaultLogo;
            original.call(instance, resourceLocation, i, j, 0f, 0f, 256, 70, 256, 70);
        }
    }

}