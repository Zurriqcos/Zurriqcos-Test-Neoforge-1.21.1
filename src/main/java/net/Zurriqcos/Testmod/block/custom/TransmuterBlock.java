package net.Zurriqcos.Testmod.block.custom;

import net.Zurriqcos.Testmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;

public class TransmuterBlock extends Block {
    public TransmuterBlock(Properties properties){
        super(properties);
    }


    private static final Map<Item, Item> ITEM_MAP =
            Map.of(
                    Items.STICK, Items.DEBUG_STICK,
                    Items.ACACIA_SAPLING, Items.SPRUCE_SAPLING,
                    Items.SPRUCE_SAPLING, Items.BIRCH_SAPLING,
                    Items.BIRCH_SAPLING, Items.CHERRY_SAPLING,
                    Items.CHERRY_SAPLING, Items.DARK_OAK_SAPLING,
                    Items.DARK_OAK_SAPLING, Items.JUNGLE_SAPLING,
                    Items.JUNGLE_SAPLING, Items.OAK_SAPLING,
                    Items.OAK_SAPLING, Items.ACACIA_SAPLING,
                    Items.HAY_BLOCK, Items.SLIME_BLOCK
          );

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity){
            if(ITEM_MAP.containsKey(itemEntity.getItem().getItem())){
                itemEntity.setItem(new ItemStack(ITEM_MAP.get(itemEntity.getItem().getItem()), itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.zurritestmod.TransmuterBlock.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
