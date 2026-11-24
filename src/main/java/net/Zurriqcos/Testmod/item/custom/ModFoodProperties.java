package net.Zurriqcos.Testmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GALLETA1 = new FoodProperties.Builder().nutrition(2).saturationModifier(50.0f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 400), 1.0f).fast().alwaysEdible().build();

}
