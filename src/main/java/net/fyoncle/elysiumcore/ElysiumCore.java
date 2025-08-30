package net.fyoncle.elysiumcore;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fyoncle.elysiumcore.custommenus.RamWarningMenu;
import net.fyoncle.elysiumcore.utility.configs.ConfigReader;
import net.fyoncle.elysiumcore.utility.configs.ConfigSaver;
import net.fyoncle.elysiumcore.utility.constants.Constants;
import net.fyoncle.elysiumcore.utility.other.Ram;
import net.fyoncle.elysiumcore.utility.other.ServiceLoaders;
import net.fyoncle.elysiumcore.utility.other.VersionChecking;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;

public class ElysiumCore implements ClientModInitializer {

    public static final String MOD_ID = "elysiumcore";

    public final static ServiceLoaders serviceLoaders = new ServiceLoaders();
    //Other
    private final VersionChecking versionChecking = new VersionChecking();
    //Config
    public ConfigSaver configSaver;
    public ConfigReader configReader;
    //Screens
    private RamWarningMenu ramWarningMenu;

    @Override
    public void onInitializeClient() {
        versionChecking.checkEDVersion();
        initConfigs();
        initEvents();
        initCustomScreens();
    }

    private void initConfigs() {
        configReader = new ConfigReader(
                FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
                Constants.Other.Configs.CONFIG_FILE_NAME);
        configSaver = new ConfigSaver(
                FabricLoader.getInstance().getConfigDir().toFile().getAbsolutePath() + "/",
                Constants.Other.Configs.CONFIG_FILE_NAME);

        if (configReader.readData().isEmpty()) {
            configSaver.saveData("false", Constants.Other.Configs.DISABLED_RAM_SCREEN_CONFIG_TYPE);
        }
    }

    private void initEvents() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if (configReader.readData().get("disableRamScreen").equals("false")) {
                if (Ram.getAllocatedRam() < 4.5) {
                    if (client.currentScreen instanceof TitleScreen) {
                        client.setScreen(ramWarningMenu);
                    }
                }
            }
        });
    }

    private void initCustomScreens() {
        ramWarningMenu = new RamWarningMenu(this, Text.empty(),
                String.valueOf(Ram.getAllocatedRam()).substring(0, 3));
    }
}
