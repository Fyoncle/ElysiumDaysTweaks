package net.fyoncle.elysiumdaystweaks.utility.other;

import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.fyoncle.elysiumdaystweaks.utility.services.interfaces.INeatConfigService;

import java.util.ServiceLoader;

public class ServiceLoaders {

    public INeatConfigService NEAT_CONFIG_SERVICE;

    public ServiceLoaders() {
        NEAT_CONFIG_SERVICE = getDefaultNeat();
    }

    private INeatConfigService getDefaultNeat() {
        if(FabricLoaderImpl.INSTANCE.isModLoaded("neat")) {
            ServiceLoader<INeatConfigService> neatConfigService =
                    ServiceLoader.load(INeatConfigService.class);
            Flags.IS_NEAT_CONFIG_LOADED = true;
            for (INeatConfigService service : neatConfigService) {
                return service;
            }
        }
        return null;
    }
    public static class Flags {
        public static boolean IS_NEAT_CONFIG_LOADED = false;
    }
}
