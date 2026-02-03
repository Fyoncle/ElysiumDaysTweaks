package net.fyoncle.elysiumcore.utility.constants;

import net.minecraft.MinecraftVersion;

public class Constants {
    public static class Links {
        public static final String MODRINTH_API_LINK = "https://api.modrinth.com/";
        public static final String ELYSIUM_DAYS_VERSIONS_PAGE_LINK = "https://modrinth.com/modpack/elysium-days/versions";
        public static final String DISCORD_LINK = "https://discord.gg/WFpDr7zY8Z";
        public static final String WIKI_LINK = "https://fyoncle.gitbook.io/elysium-days-wiki";
        public static final String RAM_GUIDE_LINK = "https://fyoncle.gitbook.io/elysium-days-wiki/guides/memory-allocation";
    }

    public static class Core {
        public static final String CURRENT_ED_VERSION = "8.0.0";
        public static final String CURRENT_MINECRAFT_VERSION = MinecraftVersion.CURRENT.getName();
        public static final String ELYSIUM_DAYS_WINDOW_TITLE = "Minecraft " + CURRENT_MINECRAFT_VERSION + " - Elysium Days " + CURRENT_ED_VERSION;

        public static class Paths {
            public static final String ICONS_PATH = "assets/elysiumcore/textures/icons/";
            public static final String[] DEFAULT_ED_ICONS_FILE_NAMES = new String[]{
                    "defaulticons/ed_default_icon_16x16.png", "defaulticons/ed_default_icon_32x32.png",
                    "defaulticons/ed_default_icon_48x48.png", "defaulticons/ed_default_icon_128x128.png",
                    "defaulticons/ed_default_icon_256x256.png",
            };
            public static final String[] CHRISTMAS_ED_ICONS_FILE_NAMES = new String[]{
                    "christmasicons/ed_christmas_icon_16x16.png", "christmasicons/ed_christmas_icon_32x32.png",
                    "christmasicons/ed_christmas_icon_48x48.png", "christmasicons/ed_christmas_icon_128x128.png",
                    "christmasicons/ed_christmas_icon_256x256.png",
            };
            public static final String[] HALLOWEEN_ED_ICONS_FILE_NAMES = new String[]{
                    "halloweenicons/ed_halloween_icon_16x16.png", "halloweenicons/ed_halloween_icon_32x32.png",
                    "halloweenicons/ed_halloween_icon_48x48.png", "halloweenicons/ed_halloween_icon_128x128.png",
                    "halloweenicons/ed_halloween_icon_256x256.png",
            };
        }
    }
}