package net.fyoncle.elysiumcore.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    //Fixing MC-220390.
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setSprinting(Z)V", shift = At.Shift.AFTER), method = "attack")
    public void attack(Entity target, CallbackInfo callback) {
        this.setSprinting(true);
    }
}