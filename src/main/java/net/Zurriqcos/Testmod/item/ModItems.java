package net.Zurriqcos.Testmod.item;

import net.Zurriqcos.Testmod.ExampleMod;
import net.Zurriqcos.Testmod.item.custom.MidasWandItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);

    public static final DeferredItem<Item> Item1 = ITEMS.register("perryore",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> Item2 = ITEMS.register("perrylingote",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> Item3 = ITEMS.register("midaswand",
            ()-> new MidasWandItem(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
