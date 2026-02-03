package net.fyoncle.elysiumcore.mixin;

import net.fyoncle.elysiumcore.customwidgets.HoverableButton;
import net.fyoncle.elysiumcore.customwidgets.HoverableTextButton;
import net.fyoncle.elysiumcore.utility.constants.Constants;
import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.fyoncle.elysiumcore.utility.other.Flags;
import net.fyoncle.elysiumcore.utility.other.Strings;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MainMenuMixin extends Screen {

    @Unique
    private ButtonWidget discordButton;
    @Unique
    private ButtonWidget wikiButton;

    protected MainMenuMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void addButtons(CallbackInfo ci) {
        for (int i = 0; i < this.children().size(); i++) {
            ButtonWidget button = ((ButtonWidget) this.children().get(i));
            if (button.getMessage().getString().equals(Text.translatable("menu.quit").getString())) {
                addDiscordButton(((ButtonWidget) this.children().get(i + 1)));
                addNewUpdateButton(Flags.IS_LATEST_VERSION, button);
            }
            if (button.getMessage().getString().equals(Text.translatable("menu.options").getString())) {
                addWikiButton(((ButtonWidget) this.children().get(i + 1)));
            }
        }
    }

    @Unique
    private void addDiscordButton(ButtonWidget startButton) {
        int x = startButton.getX();
        int yPos = startButton.getY();
        int width = startButton.getWidth();
        discordButton = this.addDrawableChild(new HoverableButton(
                x + width + 4, yPos, 20,
                20, 0, 0, 0, 20, 20,
                Textures.DISCORD_BUTTON_UNFOCUSED_TEXTURE,
                Textures.DISCORD_BUTTON_FOCUSED_TEXTURE,
                button -> Util.getOperatingSystem().open(Constants.Links.DISCORD_LINK)));
    }

    @Unique
    private void addWikiButton(ButtonWidget startButton) {
        int x = startButton.getX();
        int yPos = startButton.getY();
        int width = startButton.getWidth();
        wikiButton = this.addDrawableChild(new HoverableButton(
                x + width + -248, yPos, 20,
                20, 0, 0, 0, 20, 20,
                Textures.WIKI_BUTTON_UNFOCUSED_TEXTURE,
                Textures.WIKI_BUTTON_FOCUSED_TEXTURE,
                button -> Util.getOperatingSystem().open(Constants.Links.WIKI_LINK)));
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void renderTooltip(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (discordButton != null && discordButton.isHovered()) {
            context.drawTooltip(
                    this.textRenderer,
                    Text.of("Join our Discord!"),
                    mouseX,
                    mouseY
            );
        }

        if (wikiButton != null && wikiButton.isHovered()) {
            context.drawTooltip(
                    this.textRenderer,
                    Text.of("Visit the Wiki!"),
                    mouseX,
                    mouseY
            );
        }
    }

    @Unique
    private void addNewUpdateButton(boolean isLatestVersion, ButtonWidget startButton) {
        if (!isLatestVersion) {
            this.addDrawableChild(new HoverableTextButton(this.width / 2 - 200 / 2,
                    startButton.getY() + 30,
                    200, 20, 0, 0, 0, 200, 20,
                    Text.translatable("elysiumcore.update_available", Strings.LATEST_ED_VERSION).getString(),
                    Textures.GREEN_BUTTON_UNFOCUSED_TEXTURE,
                    Textures.GREEN_BUTTON_FOCUSED_TEXTURE,
                    button -> Util.getOperatingSystem().open(Constants.Links.ELYSIUM_DAYS_VERSIONS_PAGE_LINK)));
        }
    }

}