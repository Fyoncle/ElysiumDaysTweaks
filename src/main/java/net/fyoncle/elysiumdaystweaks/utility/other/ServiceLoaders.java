package net.fyoncle.elysiumdaystweaks.utility.other;

import net.fyoncle.elysiumdaystweaks.utility.services.interfaces.INeatConfigService;

import java.util.ServiceLoader;

public class ServiceLoaders {

    private final ServiceLoader<INeatConfigService> neatConfigService =
            ServiceLoader.load(INeatConfigService.class);

    public INeatConfigService NEAT_CONFIG_SERVICE;

    public ServiceLoaders() {
        NEAT_CONFIG_SERVICE = getDefaultNeat();
    }

    private INeatConfigService getDefaultNeat() {
        try {
            Class.forName("vazkii.neat.NeatConfig");
            Flags.IS_NEAT_CONFIG_LOADED = true;
            for (INeatConfigService service : neatConfigService) {
                return service;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("NeatConfig class was not found.");
        }
        return null;
    }
    public static class Flags {
        public static boolean IS_NEAT_CONFIG_LOADED = false;
    }
}
