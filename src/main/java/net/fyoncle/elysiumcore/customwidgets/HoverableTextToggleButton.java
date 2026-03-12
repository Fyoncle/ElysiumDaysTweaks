package net.fyoncle.elysiumcore.customwidgets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class HoverableTextToggleButton extends TexturedButtonWidget {

    private final Identifier focusedToggled;
    private final Identifier focusedUnToggled;
    private final Identifier unfocusedToggled;
    private final Identifier unfocusedUnToggled;

    public String textToggled;
    public String textUnToggled;
    public boolean isToggled;

    public HoverableTextToggleButton(int x, int y, int width, int height, int u, int v,
                                     Identifier ft, Identifier fut,
                                     boolean isToggled,
                                     String textToggled,
                                     String textUnToggled,
                                     Identifier uft, Identifier ufut, PressAction pressAction) {
        super(x, y, width, height, u, v, 0, ufut, width, height, pressAction);
        this.isToggled = isToggled;
        this.textToggled = textToggled;
        this.textUnToggled = textUnToggled;
        this.focusedToggled = ft;
        this.focusedUnToggled = fut;
        this.unfocusedToggled = uft;
        this.unfocusedUnToggled = ufut;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        Identifier texture;
        String label;
        int textX;

        if (isToggled) {
            texture = isHovered() ? focusedToggled : unfocusedToggled;
            label = textToggled;
            textX = this.getX() + this.getWidth() / 2 - 1;
        } else {
            texture = isHovered() ? focusedUnToggled : unfocusedUnToggled;
            label = textUnToggled;
            textX = this.getX() + this.getWidth() / 2 + 1;
        }

        context.drawTexture(texture, this.getX(), this.getY(), this.u, this.v,
                this.width, this.height, this.width, this.height);
        context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,
                label, textX, this.getY() + this.getHeight() / 2 - 4, Colors.WHITE);
    }
}