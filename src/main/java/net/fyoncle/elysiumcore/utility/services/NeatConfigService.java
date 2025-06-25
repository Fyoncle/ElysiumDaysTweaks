package net.fyoncle.elysiumcore.utility.services;

import net.fyoncle.elysiumcore.utility.services.interfaces.INeatConfigService;
import vazkii.neat.NeatConfig;

public class NeatConfigService implements INeatConfigService {
    @Override
    public boolean getDraw() {
        return NeatConfig.draw;

    }

    @Override
    public void setDraw(boolean draw) {
        NeatConfig.draw = draw;
    }
}
