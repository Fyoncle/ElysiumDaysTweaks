package net.fyoncle.elysiumcore.mixin;

import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import org.apache.commons.io.IOUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Mixin(Icons.class)
public class CustomIconMixin {

    @Unique
    private static InputSupplier<InputStream> loadIcon(String path) {
        try (InputStream stream = CustomIconMixin.class.getClassLoader().getResourceAsStream(path)) {
            if (stream == null) throw new RuntimeException("Icon not found: " + path);
            byte[] data = IOUtils.toByteArray(stream);
            return () -> new ByteArrayInputStream(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Inject(method = "getIcons", at = @At("HEAD"), cancellable = true)
    private void getIcons(CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir) {
        cir.setReturnValue(List.of(loadIcon(Textures.APP_ICON)));
    }

    @Inject(method = "getMacIcon", at = @At("HEAD"), cancellable = true)
    private void getMacIcon(CallbackInfoReturnable<InputSupplier<InputStream>> cir) {
        cir.setReturnValue(loadIcon(Textures.APP_ICON_MAC));
    }
}