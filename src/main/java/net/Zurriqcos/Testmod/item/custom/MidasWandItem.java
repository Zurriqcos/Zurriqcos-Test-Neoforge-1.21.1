package net.Zurriqcos.Testmod.item.custom;

import net.Zurriqcos.Testmod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class MidasWandItem extends Item {
    public MidasWandItem(Properties properties){
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.zurritestmod.midasWandItem.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    private static final Map<Item, Item> FOOD_MAP =
            Map.of(
                    Items.APPLE, Items.GOLDEN_APPLE,
                    Items.CARROT, Items.GOLDEN_CARROT,
                    Items.MELON_SLICE, Items.GLISTERING_MELON_SLICE,
                    Items.IRON_BLOCK, Items.GOLD_BLOCK,
                    Items.IRON_INGOT, Items.GOLD_INGOT,
                    Items.IRON_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR,
                    Items.IRON_ORE, Items.GOLD_ORE,
                    Items.RAW_IRON_BLOCK, Items.RAW_GOLD_BLOCK,
                    Items.DEEPSLATE_IRON_ORE, Items.DEEPSLATE_GOLD_ORE,
                    Items.RAW_IRON, Items.RAW_GOLD
            );

    private static final Map<Block, Block> BLOCK_MAP =
            Map.of(
                    Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.RAW_IRON_BLOCK, Blocks.RAW_GOLD_BLOCK,
                    Blocks.IRON_ORE, Blocks.GOLD_ORE,
                    Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                    ModBlocks.ABADBLOQUE.get(), ModBlocks.BLOQUETRANSMUTADOR.get()
            );

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedblock = level.getBlockState(context.getClickedPos()).getBlock();

        if(BLOCK_MAP.containsKey(clickedblock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), BLOCK_MAP.get(clickedblock).defaultBlockState());

                level.playSound(null, context.getClickedPos(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS);
            }
        }

        return super.useOn(context);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand) {
        //iteramos en el inventario del jugador
        for (int i = 0; i < player.getInventory().items.size(); i++) {

            if (FOOD_MAP.containsKey(player.getInventory().items.get(i).getItem())) {

                player.getInventory().setItem(i, new ItemStack(FOOD_MAP.get(player.getInventory().items.get(i).getItem()),
                        player.getInventory().items.get(i).getCount()));
                player.playSound(SoundEvents.ENCHANTMENT_TABLE_USE);
            }
        }
        return super.use(level, player, usedHand);
    }
}
