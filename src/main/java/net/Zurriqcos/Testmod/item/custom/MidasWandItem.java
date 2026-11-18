package net.Zurriqcos.Testmod.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class MidasWandItem extends Item {
    public MidasWandItem(Properties properties){
        super(properties);
    }

    private static final Map<Item, Item> FOOD_MAP =
            Map.of(
                    Items.APPLE, Items.GOLDEN_APPLE,
                    Items.CARROT, Items.GOLDEN_CARROT,
                    Items.MELON_SLICE, Items.GLISTERING_MELON_SLICE,
                    Items.IRON_BLOCK, Items.GOLD_BLOCK,
                    Items.IRON_INGOT, Items.GOLD_INGOT,
                    Items.IRON_NUGGET, Items.GOLD_NUGGET,
                    Items.IRON_HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR
            );

    private static final Map<Block, Block> BLOCK_MAP =
            Map.of(
                    Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.RAW_IRON_BLOCK, Blocks.RAW_GOLD_BLOCK,
                    Blocks.IRON_ORE, Blocks.GOLD_ORE,
                    Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE
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
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        Item clickeditem = stack.getItem();

        if(FOOD_MAP.containsKey(clickeditem)){
            int aux = stack.getCount();
            slot.remove(aux);

            player.addItem(new ItemStack(FOOD_MAP.get(clickeditem), aux));

            player.playSound(SoundEvents.ENCHANTMENT_TABLE_USE);
        }

        return super.overrideStackedOnOther(stack, slot, action, player);
    }
}
