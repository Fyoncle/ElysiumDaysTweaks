package net.fyoncle.elysiumcore.mixin;

import net.fyoncle.elysiumcore.ElysiumCore;
import net.fyoncle.elysiumcore.customwidgets.HoverableTextToggleButton;
import net.fyoncle.elysiumcore.utility.constants.Textures;
import net.fyoncle.elysiumcore.utility.other.Flags;
import net.fyoncle.elysiumcore.utility.other.ServiceLoaders;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class EscapeMenuMixin extends Screen {
    @Unique
    private HoverableTextToggleButton healthBarStatusButton;

    protected EscapeMenuMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgets")
    private void addButtons(CallbackInfo ci) {
        for (int i = 0; i < this.children().size(); i++) {
            ClickableWidget widget = (ClickableWidget) this.children().get(i);
            String widgetText = widget.getMessage().getString();
            if (widget instanceof TextWidget) {
                if (widgetText.equals(Text.translatable("menu.returnToMenu").getString())) {
                    addHealthBarTogglingButton(this.width / 2 - 100 / 2, widget.getY());
                }
            } else if (widget instanceof ButtonWidget) {
                if (widgetText.equals(Text.translatable("menu.returnToMenu").getString())) {
                    addHealthBarTogglingButton(this.width / 2 - 100 / 2, widget.getY());
                }
            }
        }
    }

    @Unique
    private void addHealthBarTogglingButton(int x, int y) {
        if (ServiceLoaders.Flags.IS_NEAT_CONFIG_LOADED) {
            String neatText = Text.translatable("elysiumcore.neat_health_bar").getString();

            healthBarStatusButton = new HoverableTextToggleButton(x,
                    y + 20 + 5, 100, 20,
                    0, 0, Textures.FOCUSED_ON_HEALTHBAR_TEXTURE,
                    Textures.FOCUSED_OFF_HEALTHBAR_TEXTURE,
                    Flags.IS_HEALTH_BAR_TOGGLED,
                    neatText + ": ON",
                    neatText + ": OFF",
                    Textures.UNFOCUSED_ON_HEALTHBAR_TEXTURE,
                    Textures.UNFOCUSED_OFF_HEALTHBAR_TEXTURE,
                    button -> toggleHealthBar());
            restoreHealthBarToggleStates();
            this.addDrawableChild(healthBarStatusButton);
        }
    }

    @Unique
    private void restoreHealthBarToggleStates() {
        if (!ElysiumCore.serviceLoaders.NEAT_CONFIG_SERVICE.getDraw()) {
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
            ElysiumCore.serviceLoaders.NEAT_CONFIG_SERVICE.setDraw(true);
        } else {
            Flags.IS_HEALTH_BAR_TOGGLED = false;
            healthBarStatusButton.isToggled = false;
            ElysiumCore.serviceLoaders.NEAT_CONFIG_SERVICE.setDraw(false);
        }
    }
}
