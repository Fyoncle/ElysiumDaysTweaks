package net.fyoncle.elysiumcore.resource;

import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ModNioResourcePack;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;
import static net.fyoncle.elysiumcore.ElysiumCore.MOD_ID;

public final class ElysiumCorePackProvider implements ResourcePackProvider {
    public static final String PACK_ID = "elysiumcore:elysiumcore";
    private static final Logger LOGGER = LoggerFactory.getLogger(ElysiumCorePackProvider.class);

    public ElysiumCorePackProvider() {
    }

    @Override
    public void register(Consumer<ResourcePackProfile> profileAdder) {
        requireNonNull(profileAdder, "Pack consumer cannot be null");

        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
            Identifier id = Identifier.of(MOD_ID, MOD_ID);
            String subPath = "resourcepacks/" + id.getPath();
            List<Path> paths = modContainer.getRootPaths();
            String separator = paths.get(0).getFileSystem().getSeparator();
            subPath = subPath.replace("/", separator);
            String finalSubPath = subPath;

            ResourcePackInfo info = new ResourcePackInfo(
                    PACK_ID,
                    Text.literal("§fElysium §5Core"),
                    ResourcePackSource.BUILTIN,
                    Optional.empty()
            );

            ResourcePackProfile.PackFactory packFactory = new ResourcePackProfile.PackFactory() {
                @Override
                public ResourcePack open(ResourcePackInfo info) {
                    ResourcePack pack = ModNioResourcePack.create(id.toString(),
                            modContainer, finalSubPath, ResourceType.CLIENT_RESOURCES,
                            ResourcePackActivationType.ALWAYS_ENABLED, false);

                    if (pack == null) {
                        LOGGER.error("Failed to load built-in resource pack '{}': no valid namespaces found at path '{}'. " +
                                "Check the pack exists and is bundled correctly.", PACK_ID, finalSubPath);
                    }

                    return pack;
                }

                @Override
                public ResourcePack openWithOverlays(ResourcePackInfo info, ResourcePackProfile.Metadata metadata) {
                    return open(info);
                }
            };

            ResourcePackPosition position = new ResourcePackPosition(
                    true,
                    ResourcePackProfile.InsertionPosition.TOP,
                    true
            );

            ResourcePackProfile pack = ResourcePackProfile.create(
                    info,
                    packFactory,
                    ResourceType.CLIENT_RESOURCES,
                    position
            );

            if (pack == null) {
                LOGGER.error("Failed to create resource pack profile for '{}'", PACK_ID);
                return;
            }

            profileAdder.accept(pack);
        });
    }
}