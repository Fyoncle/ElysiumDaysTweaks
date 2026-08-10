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
        public static final String CURRENT_ED_VERSION = "9.0.0";
        public static final String CURRENT_MINECRAFT_VERSION = MinecraftVersion.CURRENT.getName();
        public static final String ELYSIUM_DAYS_WINDOW_TITLE = "Elysium Days " + CURRENT_ED_VERSION + " - " + CURRENT_MINECRAFT_VERSION;
    }
}