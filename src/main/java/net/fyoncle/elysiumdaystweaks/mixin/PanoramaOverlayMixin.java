package net.fyoncle.elysiumdaystweaks.mixin;

import net.fyoncle.elysiumdaystweaks.utility.constants.Textures;
import net.fyoncle.elysiumdaystweaks.utility.other.HolidayChecker;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RotatingCubeMapRenderer.class)
public class PanoramaOverlayMixin {
    @Mutable
    @Final
    @Shadow public static Identifier OVERLAY_TEXTURE;

    @Inject(at = @At("CTOR_HEAD"), method = "<init>")
    private void init(CallbackInfo ci) {
        if(HolidayChecker.isHalloween()) {
            this.OVERLAY_TEXTURE = Textures.ED_HALLOWEEN_PANORAMA;
        } else if(HolidayChecker.isChristmas()) {
            this.OVERLAY_TEXTURE = Textures.ED_CHRISTMAS_PANORAMA;
        }
        if(!HolidayChecker.isChristmas() && !HolidayChecker.isHalloween()) {
            this.OVERLAY_TEXTURE = Textures.ED_DEFAULT_PANORAMA;
        }
    }

//    private void changePanoramaBasedOnDate() {
//        if(HolidayChecker.isHalloween()) {
//            OVERLAY_TEXTURE = Textures.ED_HALLOWEEN_PANORAMA;
//        } else if(HolidayChecker.isChristmas()) {
//            OVERLAY_TEXTURE = Textures.ED_CHRISTMAS_PANORAMA;
//        }
//        if(!HolidayChecker.isChristmas() && !HolidayChecker.isHalloween()) {
//            OVERLAY_TEXTURE = Textures.ED_DEFAULT_PANORAMA;
//        }
//    }
}
