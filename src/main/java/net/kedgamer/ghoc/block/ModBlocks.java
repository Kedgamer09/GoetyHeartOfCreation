package net.kedgamer.ghoc.block;

import net.kedgamer.ghoc.GHoC;
import net.kedgamer.ghoc.block.custom.DamageBlock;
import net.kedgamer.ghoc.block.custom.fuglite;
import net.kedgamer.ghoc.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GHoC.MOD_ID);

    public static final RegistryObject<Block> FUGLITE = registerBlock("fuglite",
            () -> new fuglite(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .sound(SoundType.FROGLIGHT)
                    .destroyTime(8.0f)));

    public static final RegistryObject<Block> ENCHANTED_ETHERIUM = registerBlock("enchanted_etherium",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
