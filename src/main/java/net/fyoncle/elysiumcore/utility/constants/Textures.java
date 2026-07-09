package net.fyoncle.elysiumcore.utility.constants;

import net.minecraft.util.Identifier;

public class Textures {
    // App Icon
    public static final String APP_ICON = "assets/elysiumcore/textures/icon/ed_icon.png";
    public static final String APP_ICON_MAC = "assets/elysiumcore/textures/icon/ed_icon.icns";

    // Menu Logo
    public static final Identifier MENU_LOGO = Identifier.of(
            "elysiumcore",
            "textures/logo/menu_logo.png");

    // - Health Bar Textures -
    public static Identifier UNFOCUSED_OFF_HEALTHBAR_TEXTURE = Identifier.of(
            "elysiumcore", "neat_disabled_button_unfocused");
    public static Identifier FOCUSED_OFF_HEALTHBAR_TEXTURE = Identifier.of(
            "elysiumcore", "neat_disabled_button_focused");
    public static Identifier UNFOCUSED_ON_HEALTHBAR_TEXTURE = Identifier.of(
            "elysiumcore", "neat_enabled_button_unfocused");
    public static Identifier FOCUSED_ON_HEALTHBAR_TEXTURE = Identifier.of(
            "elysiumcore", "neat_enabled_button_focused");

    // - Discord Button Texture -
    public static Identifier DISCORD_BUTTON_UNFOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "discord_button_unfocused");
    public static Identifier DISCORD_BUTTON_FOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "discord_button_focused");

    // - Wiki Button Texture -
    public static Identifier WIKI_BUTTON_UNFOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "wiki_button_unfocused");
    public static Identifier WIKI_BUTTON_FOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "wiki_button_focused");

    // - Ram Warning Screen Textures -
    public static Identifier OPEN_GUIDE_BUTTON_UNFOCUSED = Identifier.of(
            "elysiumcore", "open_guide_button_unfocused");
    public static Identifier OPEN_GUIDE_BUTTON_FOCUSED = Identifier.of(
            "elysiumcore", "open_guide_button_focused");
    public static Identifier IGNORE_BUTTON_UNFOCUSED = Identifier.of(
            "elysiumcore", "ignore_button_unfocused");
    public static Identifier IGNORE_BUTTON_FOCUSED = Identifier.of(
            "elysiumcore", "ignore_button_focused");
    public static Identifier DONT_WARN_AGAIN_BUTTON_UNFOCUSED = Identifier.of(
            "elysiumcore", "dont_warn_again_button_unfocused");
    public static Identifier DONT_WARN_AGAIN_BUTTON_FOCUSED = Identifier.of(
            "elysiumcore", "dont_warn_again_button_focused");

    // - Other -
    public static Identifier DEFAULT_BUTTON_UNFOCUSED = Identifier.of(
            "elysiumcore", "default_button_unfocused");
    public static Identifier DEFAULT_BUTTON_FOCUSED = Identifier.of(
            "elysiumcore", "default_button_focused");
    public static Identifier GREEN_BUTTON_UNFOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "green_button_unfocused");
    public static Identifier GREEN_BUTTON_FOCUSED_TEXTURE = Identifier.of(
            "elysiumcore", "green_button_focused");
}