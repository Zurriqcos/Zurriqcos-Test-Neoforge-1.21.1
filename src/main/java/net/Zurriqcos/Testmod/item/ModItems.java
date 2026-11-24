package net.Zurriqcos.Testmod.item;

import net.Zurriqcos.Testmod.ExampleMod;
import net.Zurriqcos.Testmod.item.custom.MidasWandItem;
import net.Zurriqcos.Testmod.item.custom.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Optional;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);

    public static final DeferredItem<Item> Item1 = ITEMS.register("perryore",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> Item2 = ITEMS.register("perrylingote",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> Item3 = ITEMS.register("midaswand",
            ()-> new MidasWandItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ABADLLETA = ITEMS.register("abadlleta",
            ()-> new Item(new Item.Properties().food(ModFoodProperties.GALLETA1)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.zurritestmod.abadlleta.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
