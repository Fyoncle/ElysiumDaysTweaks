package net.fyoncle.elysiumdaystweaks.utility.services;

import net.fyoncle.elysiumdaystweaks.utility.services.interfaces.INeatConfigService;
import vazkii.neat.NeatConfig;

public class NeatConfigService implements INeatConfigService {
    @Override
    public void setDraw(boolean draw) {
        NeatConfig.draw = draw;
    }

    @Override
    public boolean getDraw() {
        return NeatConfig.draw;

    }
}
