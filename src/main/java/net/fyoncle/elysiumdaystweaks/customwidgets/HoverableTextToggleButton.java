package net.fyoncle.elysiumdaystweaks.customwidgets;

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
        super(x, y, width, height, u, v, null, pressAction);
        this.isToggled = isToggled;
        this.textToggled = textToggled;
        this.textUnToggled = textUnToggled;

        focusedToggled = ft;
        focusedUnToggled = fut;
        unfocusedToggled = uft;
        unfocusedUnToggled = ufut;
    }

    @Override
    public void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        if(isToggled) {
            if(isHovered()) {
                context.drawTexture(focusedToggled, this.getX(), this.getY(), this.u, this.v,
                        this.width, this.height, this.width, this.height);
            } else {
                context.drawTexture(unfocusedToggled, this.getX(), this.getY(), this.u, this.v,
                        this.width, this.height, this.width, this.height);
            }
            context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,
                    this.textToggled, this.getX() + this.getWidth()/2 - 1,
                    this.getY() + this.getHeight()/2-4,
                    Colors.WHITE);
        } else {
            if(isHovered()) {
                context.drawTexture(focusedUnToggled, this.getX(), this.getY(), this.u, this.v,
                        this.width, this.height, this.width, this.height);
            } else {
                context.drawTexture(unfocusedUnToggled, this.getX(), this.getY(), this.u, this.v,
                        this.width, this.height, this.width, this.height);
            }
            context.drawCenteredTextWithShadow(MinecraftClient.getInstance().textRenderer,
                    this.textUnToggled, this.getX() + this.getWidth()/2 + 1,
                    this.getY() + this.getHeight()/2-4,
                    Colors.WHITE);
        }
    }

}
