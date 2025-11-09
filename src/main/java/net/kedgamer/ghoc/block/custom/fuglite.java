package net.kedgamer.ghoc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class fuglite extends Block {
    public fuglite(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pLevel.isClientSide) {
            pEntity.kill();
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(1.0D, 1.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltipComponents, TooltipFlag pFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.ghoc.fuglite.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pFlag);
    }
}