package net.fyoncle.elysiumcore.custommenus;

import net.fyoncle.elysiumcore.ElysiumCoreConfig;
import net.fyoncle.elysiumcore.customwidgets.HoverableTextButton;
import net.fyoncle.elysiumcore.utility.constants.Constants;
import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.AccessibilityOnboardingButtons;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.option.LanguageOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.lwjgl.glfw.GLFW;

public class RamWarningMenu extends Screen {

    private final String currentRam;

    public RamWarningMenu(Text title, String currentRam) {
        super(title);
        this.currentRam = currentRam;
    }

    @Override
    protected void init() {
        super.init();
        addGuideButton();
        addIgnoreButton();
        addDontWarnAgainButton();
        addQuitGameButton();
        addLanguageButton();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) return true;
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        MultilineText.create(
                MinecraftClient.getInstance().textRenderer,
                Text.translatable("elysiumcore.ramwarningscreen.warning_line1", currentRam),
                Text.translatable("elysiumcore.ramwarningscreen.warning_line2"),
                Text.translatable("elysiumcore.ramwarningscreen.warning_line3")
        ).drawCenterWithShadow(context, this.width / 2, this.height / 2 - 80, 20, Colors.RED);
    }

    private HoverableTextButton createButton(int y, String label,
                                             Identifier unfocused, Identifier focused,
                                             ButtonWidget.PressAction action) {
        return new HoverableTextButton(
                this.width / 2 - 100, y,
                200, 20,
                label, unfocused, focused, action
        );
    }

    private void addGuideButton() {
        this.addDrawableChild(createButton(
                this.height / 2 - 20,
                Text.translatable("elysiumcore.ramwarningscreen.button_open_guide").getString(),
                Textures.OPEN_GUIDE_BUTTON_UNFOCUSED, Textures.OPEN_GUIDE_BUTTON_FOCUSED,
                button -> {
                    Util.getOperatingSystem().open(Constants.Links.RAM_GUIDE_LINK);
                    MinecraftClient.getInstance().scheduleStop();
                }
        ));
    }

    private void addIgnoreButton() {
        this.addDrawableChild(createButton(
                this.height / 2 + 25,
                Text.translatable("elysiumcore.ramwarningscreen.button_ignore").getString(),
                Textures.IGNORE_BUTTON_UNFOCUSED, Textures.IGNORE_BUTTON_FOCUSED,
                button -> this.close()
        ));
    }

    private void addDontWarnAgainButton() {
        this.addDrawableChild(createButton(
                this.height / 2 + 50,
                Text.translatable("elysiumcore.ramwarningscreen.button_dont_warn_again").getString(),
                Textures.DONT_WARN_AGAIN_BUTTON_UNFOCUSED, Textures.DONT_WARN_AGAIN_BUTTON_FOCUSED,
                button -> {
                    ElysiumCoreConfig.config.disableRamWarningScreen = true;
                    ElysiumCoreConfig.config.save();
                    this.close();
                }
        ));
    }

    private void addQuitGameButton() {
        this.addDrawableChild(createButton(
                this.height / 2 + 75,
                Text.translatable("menu.quit").getString(),
                Textures.DEFAULT_BUTTON_UNFOCUSED, Textures.DEFAULT_BUTTON_FOCUSED,
                button -> MinecraftClient.getInstance().scheduleStop()
        ));
    }

    private void addLanguageButton() {
        TextIconButtonWidget languageButton = (TextIconButtonWidget) this.addDrawableChild(
                AccessibilityOnboardingButtons.createLanguageButton(
                        20,
                        button -> MinecraftClient.getInstance().setScreen(
                                new LanguageOptionsScreen(
                                        this,
                                        MinecraftClient.getInstance().options,
                                        MinecraftClient.getInstance().getLanguageManager()
                                )
                        ),
                        true
                )
        );
        languageButton.setPosition(this.width / 2 - 10, this.height / 2 + 100);
    }

    @Override
    public void close() {
        MinecraftClient.getInstance().setScreen(new TitleScreen());
    }
}