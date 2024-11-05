package net.fyoncle.elysiumdaystweaks.mixin;

import net.fyoncle.elysiumdaystweaks.utility.constants.Constants;
import net.fyoncle.elysiumdaystweaks.utility.other.HolidayChecker;
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
    private final Map<String, byte[]> STORAGE = new HashMap<>();
    @Unique
    private final List<InputSupplier<InputStream>> icons = new ArrayList<>();
    @Unique
    private boolean isInitialized = false;

    public CustomIconMixin() {}

    @Unique
    private void init() {
        if(!isInitialized) {
            if(HolidayChecker.isChristmas()) {
                for(int i = 0; i < Constants.Core.Paths.CHRISTMAS_ED_ICONS_FILE_NAMES.length; i++) {
                    loadResource(Constants.Core.Paths.CHRISTMAS_ED_ICONS_FILE_NAMES[i]);
                }
            } else if(HolidayChecker.isHalloween()) {
                for(int i = 0; i < Constants.Core.Paths.HALLOWEEN_ED_ICONS_FILE_NAMES.length; i++) {
                    loadResource(Constants.Core.Paths.HALLOWEEN_ED_ICONS_FILE_NAMES[i]);
                }
            }
            if(!HolidayChecker.isChristmas() && !HolidayChecker.isHalloween()) {
                for(int i = 0; i < Constants.Core.Paths.DEFAULT_ED_ICONS_FILE_NAMES.length; i++) {
                    loadResource(Constants.Core.Paths.DEFAULT_ED_ICONS_FILE_NAMES[i]);
                }
            }
            isInitialized = true;
        }
    }

    @Unique
    private void loadResource(String path) {
        String fullPath = Constants.Core.Paths.ICONS_PATH + path;
        ClassLoader classLoader = CustomIconMixin.class.getClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(fullPath))
        {
            assert stream != null;
            byte[] data = IOUtils.toByteArray(stream);
            STORAGE.put(path, data);
            icons.add(getResource(path));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Unique
    public InputSupplier<InputStream> getResource(String path)
    {
        byte[] data = STORAGE.get(path);
        if (data == null)
        {
            throw new RuntimeException("Unexpected resource path " + path);
        }
        return () -> new ByteArrayInputStream(data);
    }

    @Inject(method = "getIcons", at = @At("HEAD"), cancellable = true)
    private void getIcons(@NotNull CallbackInfoReturnable<List<InputSupplier<InputStream>>> cir)
    {
        init();
        cir.setReturnValue(icons);
    }
}