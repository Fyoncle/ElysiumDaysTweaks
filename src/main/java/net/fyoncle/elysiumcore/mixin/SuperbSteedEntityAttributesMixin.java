package net.fyoncle.elysiumcore.mixin;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import moriyashiine.superbsteeds.common.component.entity.HorseAttributesComponent;
import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = AbstractHorseEntity.class, priority = 1500)
public class SuperbSteedEntityAttributesMixin {
    @TargetHandler(
            mixin = "moriyashiine.superbsteeds.mixin.AbstractHorseEntityMixin",
            name = "superbsteeds$baseStats"
    )
    @Definition(id = "horseAttributesComponent", local = @Local(type = HorseAttributesComponent.class))
    @Expression("horseAttributesComponent != null")
    @ModifyExpressionValue(method = "@MixinSquared:Handler", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean yourHandlerMethod(boolean original) {
        return true;
    }
}
