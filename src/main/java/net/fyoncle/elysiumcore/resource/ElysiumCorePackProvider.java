package net.fyoncle.elysiumcore.resource;

import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.fabric.impl.resource.loader.ModNioResourcePack;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;
import static net.fyoncle.elysiumcore.ElysiumCore.MOD_ID;

public final class ElysiumCorePackProvider implements ResourcePackProvider {
    public static final String PACK_ID = "elysiumcore:elysiumcore";

    public ElysiumCorePackProvider() {}

    @Override
    public void register(Consumer<ResourcePackProfile> profileAdder) {
        requireNonNull(profileAdder, "Pack consumer cannot be null");

        FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
            Identifier id = new Identifier(MOD_ID, MOD_ID);
            String subPath = "resourcepacks/" + id.getPath();
            List<Path> paths = modContainer.getRootPaths();
            String separator = paths.get(0).getFileSystem().getSeparator();
            subPath = subPath.replace("/", separator);
            String finalSubPath = subPath;
            ResourcePackProfile pack = ResourcePackProfile.create(
                    PACK_ID,
                    Text.literal("§fElysium §5Core"),
                    true,
                    (name) -> ModNioResourcePack.create(id.toString(),
                            modContainer, finalSubPath, ResourceType.CLIENT_RESOURCES,
                            ResourcePackActivationType.ALWAYS_ENABLED),
                    ResourceType.CLIENT_RESOURCES,
                    ResourcePackProfile.InsertionPosition.TOP,
                    ResourcePackSource.BUILTIN
                    );
            profileAdder.accept(pack);
        });
    }
}
