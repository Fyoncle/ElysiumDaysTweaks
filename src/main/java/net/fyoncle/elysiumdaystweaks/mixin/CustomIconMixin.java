package net.fyoncle.elysiumdaystweaks.mixin;

import net.minecraft.client.util.Icons;
import net.minecraft.resource.InputSupplier;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(Icons.class)
public class CustomIconMixin {

    private final String ICONS_PATH = "assets/elysium-days-tweaks/icons/";
    private final Map<String, byte[]> STORAGE = new HashMap<>();
    private final List<String> PNG_PATHS = new ArrayList<>();
    private final List<InputSupplier<InputStream>> icons = new ArrayList<>();
    private boolean isInitialized = false;

    public CustomIconMixin() {}

    private void init() {
        if(!isInitialized) {
            loadResource("icon_16x16.png");
            loadResource("icon_32x32.png");
            loadResource("icon_48x48.png");
            loadResource("icon_128x128.png");
            loadResource("icon_256x256.png");
            isInitialized = true;
        }
    }

    private void loadResource(String path) {
        String fullPath = ICONS_PATH + path;
        ClassLoader classLoader = CustomIconMixin.class.getClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(fullPath))
        {
            byte[] data = IOUtils.toByteArray(stream);
            STORAGE.put(path, data);
            icons.add(getResource(path));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public InputSupplier<InputStream> getResource(String path)
    {
        byte[] data = STORAGE.get(path);
        if (data == null)
        {
            throw new RuntimeException("Unexpected resource path " + path);
        }
        InputSupplier<InputStream> inputSupplier = () -> new ByteArrayInputStream(data);
        return inputSupplier;
    }

    public List<InputSupplier<InputStream>> getAllPngResources() {
        init();
        return PNG_PATHS.stream().
                map(this::getResource).
                toList();
    }

    @Inject(method = "getIcons", at = @At("HEAD"), cancellable = true)
    private void getIcons(@NotNull CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir)
    {
        init();
        cir.setReturnValue(icons);
    }
}