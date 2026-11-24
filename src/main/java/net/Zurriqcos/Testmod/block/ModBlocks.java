package net.Zurriqcos.Testmod.block;

import net.Zurriqcos.Testmod.ExampleMod;
import net.Zurriqcos.Testmod.block.custom.TransmuterBlock;
import net.Zurriqcos.Testmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MOD_ID);

    public static final DeferredBlock<Block> ABADBLOQUE = registerBlock("bloque_abad",
            () -> new Block(BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops().strength(4f).sound(SoundType.ANVIL)){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.zurritestmod.BLOQUEABAD.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredBlock<Block> PERRYOREBLOQUE = registerBlock("bloque_perryore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops().strength(4f).sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BLOQUETRANSMUTADOR = registerBlock("bloque_transmutador",
            () -> new TransmuterBlock(BlockBehaviour.Properties.of()
                    .jumpFactor(20).requiresCorrectToolForDrops().strength(3f).sound(SoundType.SLIME_BLOCK)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
