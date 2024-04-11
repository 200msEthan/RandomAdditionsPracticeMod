package net.ethan.randomadditions.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SUGAR_GLASS = new FoodProperties.Builder()
            .nutrition(3).fast()
            .saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1f)
            .build();
    public static final FoodProperties BOWL_OF_GLASS_SHARDS = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(0)
            .effect(() -> new MobEffectInstance(MobEffects.HARM, 201, 100), 1f)
            .build();
}
