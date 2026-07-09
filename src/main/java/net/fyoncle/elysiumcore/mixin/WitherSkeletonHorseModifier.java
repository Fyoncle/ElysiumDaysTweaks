package net.fyoncle.elysiumcore.mixin;

//import fuzs.eternalnether.world.entity.animal.horse.WitherSkeletonHorse;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.attribute.EntityAttributes;
//import net.minecraft.entity.mob.SkeletonHorseEntity;
//import net.minecraft.util.math.random.Random;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(WitherSkeletonHorse.class)
//public class WitherSkeletonHorseModifier extends SkeletonHorseEntity {
//    public WitherSkeletonHorseModifier(EntityType<? extends SkeletonHorseEntity> entityType, World world) {
//        super(entityType, world);
//    }
//
//    @Inject(at = @At("RETURN"), method = "initAttributes")
//    public void initAttributes(Random random, CallbackInfo ci) {
//        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(32.0F);
//        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.21);
//        this.getAttributeInstance(EntityAttributes.GENERIC_JUMP_STRENGTH).setBaseValue(0.8F);
//    }
//}