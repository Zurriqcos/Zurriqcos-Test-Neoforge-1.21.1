package net.Zurriqcos.Testmod.item;

import net.Zurriqcos.Testmod.ExampleMod;
import net.Zurriqcos.Testmod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static Supplier<CreativeModeTab> PERRY_MENU_CREATIVO = CREATIVE_MOD_TAB.register("perrymenucreativo",
            () -> CreativeModeTab.builder().icon(()  -> new ItemStack(ModItems.Item1.get()))
                    .title(Component.translatable("creativetab.zurritestmod.perrymenu"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Item1);
                        output.accept(ModItems.Item2);
                        output.accept(ModItems.Item3);
                        output.accept(ModBlocks.ABADBLOQUE);
                        output.accept(ModBlocks.PERRYOREBLOQUE);
                    })

                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
