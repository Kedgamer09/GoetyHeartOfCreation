package net.kedgamer.ghoc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DamageBlock extends Block {
    public DamageBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pLevel.isClientSide) {
            pEntity.hurt(pLevel.damageSources().magic(), Float.MAX_VALUE);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(1.0D, 1.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    }

}