package net.kedgamer.ghoc.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;



public class UniverseCoreItem extends Item {
    public UniverseCoreItem(Properties pProperties) {
        super(pProperties);
    }

    public static final String WEATHER_STATE_TAG = "WeatherState";
    public static String cycleWeather(ServerLevel pLevel, ItemStack stack) {
        String result = "";

        CompoundTag tag = stack.getOrCreateTag();

        int state = tag.getInt(WEATHER_STATE_TAG);

        switch (state) {
            case 0 -> { // Clear → Rain
                pLevel.setWeatherParameters(0, 6000, true, false);
                tag.putInt(WEATHER_STATE_TAG, 1);
                result = "Rain";
            }
            case 1 -> { // Rain → Thunder
                pLevel.setWeatherParameters(0, 6000, true, true);
                tag.putInt(WEATHER_STATE_TAG, 2);
                result = "Thunder";
            }
            case 2 -> { // Thunder → Clear
                pLevel.setWeatherParameters(6000, 0, false, false);
                tag.putInt(WEATHER_STATE_TAG, 0);
                result = "Clear";
            }
        }

        return result;

    }

    public static String cycleTime(ServerLevel pLevel) {
        long time = pLevel.getDayTime() % 24000;

        if (time < 6000 || time > 23000) {
            pLevel.setDayTime(6000);     // Sunrise → Noon
            return "Noon";
        } else if (time < 12500) {
            pLevel.setDayTime(12500);     // Noon → Sunset
            return "Sunset";
        } else if (time < 18000) {
            pLevel.setDayTime(18000);     // Sunset → Midnight
            return "Midnight";
        } else {
            pLevel.setDayTime(23000);         // Midnight → Sunrise
            return "Sunrise";
        }
    }



    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {


        if (pPlayer.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (pInteractionTarget.getType() == EntityType.PLAYER) {
            return InteractionResult.PASS;
        }


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

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level pLevel = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Player pPlayer = pContext.getPlayer();

        if (!pLevel.isClientSide && pPlayer != null && !pPlayer.isShiftKeyDown()) {
            pLevel.destroyBlock(pos, true, pPlayer);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack pStack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide && pLevel instanceof ServerLevel serverLevel) {
            if (pPlayer.isShiftKeyDown()) {
                pPlayer.sendSystemMessage(Component.literal("Set weather to " + cycleWeather(serverLevel, pStack)));
            } else {
                pPlayer.sendSystemMessage(Component.literal("Set time to " + cycleTime(serverLevel)));
            }
        }

        return InteractionResultHolder.success(pStack);
    }
}
