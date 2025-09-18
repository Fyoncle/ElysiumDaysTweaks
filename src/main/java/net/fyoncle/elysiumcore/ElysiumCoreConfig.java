package net.fyoncle.elysiumcore;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import me.fzzyhmstrs.fzzy_config.config.Config;
import net.minecraft.util.Identifier;

public class ElysiumCoreConfig extends Config {
    public static ElysiumCoreConfig config = ConfigApiJava.registerAndLoadConfig(ElysiumCoreConfig::new, RegisterType.BOTH);
    public boolean disableRamScreen = false;

    public ElysiumCoreConfig() {
        super(Identifier.of(ElysiumCore.MOD_ID, "config"));
    }

    public static void init() {
    }
}
