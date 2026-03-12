package net.fyoncle.elysiumcore.mixin;

import net.fyoncle.elysiumcore.utility.constants.Constants;
import net.fyoncle.elysiumcore.utility.other.HolidayChecker;
import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(Icons.class)
public class CustomIconMixin {
    @Unique
    private final Map<String, byte[]> iconStorage = new HashMap<>();
    @Unique
    private final List<InputSupplier<InputStream>> icons = new ArrayList<>();
    @Unique
    private boolean isInitialized = false;

    public CustomIconMixin() {
    }

    @Unique
    private void init() {
        if (!isInitialized) {
            if (HolidayChecker.isChristmas()) {
                for (String name : Constants.Core.Paths.CHRISTMAS_ED_ICONS_FILE_NAMES) {
                    loadResource(name);
                }
            } else if (HolidayChecker.isHalloween()) {
                for (String name : Constants.Core.Paths.HALLOWEEN_ED_ICONS_FILE_NAMES) {
                    loadResource(name);
                }
            } else {
                for (String name : Constants.Core.Paths.DEFAULT_ED_ICONS_FILE_NAMES) {
                    loadResource(name);
                }
            }
            isInitialized = true;
        }
    }

    @Unique
    private void loadResource(String path) {
        String fullPath = Constants.Core.Paths.ICONS_PATH + path;
        ClassLoader classLoader = CustomIconMixin.class.getClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(fullPath)) {
            if (stream == null) throw new RuntimeException("Resource not found: " + fullPath);
            byte[] data = IOUtils.toByteArray(stream);
            iconStorage.put(path, data);
            icons.add(getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Unique
    private InputSupplier<InputStream> getResource(String path) {
        byte[] data = iconStorage.get(path);
        if (data == null) throw new RuntimeException("Unexpected resource path: " + path);
        return () -> new ByteArrayInputStream(data);
    }

    @Inject(method = "getIcons", at = @At("HEAD"), cancellable = true)
    private void getIcons(@NotNull CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir) {
        init();
        cir.setReturnValue(icons);
    }
}