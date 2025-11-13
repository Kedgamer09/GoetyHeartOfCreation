package net.kedgamer.ghoc.item.custom;

import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SetOwnerItem extends Item {
    public SetOwnerItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {


        if (pPlayer.level().isClientSide)
            return InteractionResult.SUCCESS;

        CompoundTag tag = new CompoundTag();
        pInteractionTarget.saveWithoutId(tag);

        int[] uuidArray = UUIDUtil.uuidToIntArray(pPlayer.getUUID());

        IntArrayTag uuidNBT = new IntArrayTag(uuidArray);

        tag.put("Owner", uuidNBT);
        pInteractionTarget.load(tag);

        if (pInteractionTarget instanceof TamableAnimal tamable) {
            tamable.setOwnerUUID(pPlayer.getUUID());
            tamable.setTame(true);
        }

        return InteractionResult.SUCCESS;
    }

}
