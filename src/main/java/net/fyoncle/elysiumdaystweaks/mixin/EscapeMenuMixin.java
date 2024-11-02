package net.fyoncle.elysiumdaystweaks.mixin;

import net.fyoncle.elysiumdaystweaks.customwidgets.HoverableTextToggleButton;
import net.fyoncle.elysiumdaystweaks.utility.constants.Textures;
import net.fyoncle.elysiumdaystweaks.utility.other.Flags;
import net.fyoncle.elysiumdaystweaks.utility.other.Strings;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.neat.NeatConfig;

@Mixin(GameMenuScreen.class)
public class EscapeMenuMixin extends Screen {

    @Unique
    private HoverableTextToggleButton healthBarStatusButton;

    protected EscapeMenuMixin(Text title) {
        super(title);

    }

    @Inject(at = @At("RETURN"), method = "initWidgets")
    private void addModsButton(CallbackInfo ci) {
        for (int i = 0; i < this.children().size(); i++) {
            if (this.children().get(i) instanceof TextWidget) {
                if (((TextWidget) this.children().get(i)).getMessage()
                        .getString().equals(Text.translatable("menu.returnToMenu").getString())) {
                    addHealthBarTogglingButton(((TextWidget) this.children().get(i)).getX(),
                            ((TextWidget) this.children().get(i)).getY()
                    );
                }
            } else if (this.children().get(i) instanceof ButtonWidget) {
                if (((ButtonWidget) this.children().get(i)).getMessage()
                        .getString().equals(Text.translatable("menu.returnToMenu").getString())) {
                    addHealthBarTogglingButton(((ButtonWidget) this.children().get(i)).getX(),
                            ((ButtonWidget) this.children().get(i)).getY()
                    );
                }
            }
        }
    }

    @Unique
    private void addHealthBarTogglingButton(int x, int y) {
        healthBarStatusButton = new HoverableTextToggleButton(x, y + 20 + 5, 100, 20,
                0, 0, Textures.FOCUSED_ON_HEALTHBAR_TEXTURE, Textures.FOCUSED_OFF_HEALTHBAR_TEXTURE,
                Flags.IS_HEALTH_BAR_TOGGLED, Strings.HEALTH_BAR_TOGGLED_STATE,
                Strings.HEALTH_BAR_UNTOGGLED_STATE,
                Textures.UNFOCUSED_ON_HEALTHBAR_TEXTURE,
                Textures.UNFOCUSED_OFF_HEALTHBAR_TEXTURE,
                button -> toggleHealthBar());
        restoreHealthBarToggleStates();
        this.addDrawableChild(healthBarStatusButton);
    }
    @Unique
    private void restoreHealthBarToggleStates() {
        if (!NeatConfig.draw) {
            Flags.IS_HEALTH_BAR_TOGGLED = false;
            healthBarStatusButton.isToggled = false;
        } else {
            Flags.IS_HEALTH_BAR_TOGGLED = true;
            healthBarStatusButton.isToggled = true;
        }
    }
    @Unique
    private void toggleHealthBar() {
        if (!Flags.IS_HEALTH_BAR_TOGGLED) {
            Flags.IS_HEALTH_BAR_TOGGLED = true;
            healthBarStatusButton.isToggled = true;
            NeatConfig.draw = true;
        } else {
            Flags.IS_HEALTH_BAR_TOGGLED = false;
            healthBarStatusButton.isToggled = false;
            NeatConfig.draw = false;
        }
    }
}
