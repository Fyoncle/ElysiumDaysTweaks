package net.fyoncle.elysiumcore;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fyoncle.elysiumcore.custommenus.RamWarningMenu;
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
    //Screens
    private RamWarningMenu ramWarningMenu;

    @Override
    public void onInitializeClient() {
        ElysiumCoreConfig.init();
        versionChecking.checkEDVersion();
        initEvents();
        initCustomScreens();
    }

    private void initEvents() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if (ElysiumCoreConfig.config.disableRamScreen == false) {
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
