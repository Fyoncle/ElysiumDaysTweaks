package net.fyoncle.elysiumdaystweaks.utility.other;

import net.fyoncle.elysiumdaystweaks.utility.services.interfaces.INeatConfigService;

import java.util.ServiceLoader;

public class ServiceLoaders {

    private static ServiceLoader<INeatConfigService> neatConfigService =
            ServiceLoader.load(INeatConfigService.class);

    public static INeatConfigService NEAT_CONFIG_SERVICE = getDefaultNeat();

    private static INeatConfigService getDefaultNeat() {
        for(INeatConfigService service : neatConfigService) {
            return service;
        }
        return null;
    }
}
