package net.kedgamer.ghoc.item;

import net.kedgamer.ghoc.GHoC;
import net.kedgamer.ghoc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GHoC.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GHOC_TAB = CREATIVE_MODE_TABS.register("ghoc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCROLL_MIXTURE.get()))
                    .title(Component.translatable("creativetab.ghoc_tab"))
                    .displayItems((itemDisplayParameters, pOutput) -> {
                        pOutput.accept(ModItems.SCROLL_MIXTURE.get());
                        pOutput.accept(ModItems.RING_MIXTURE.get());
                        pOutput.accept(ModItems.CHARM_MIXTURE.get());
                        pOutput.accept(ModItems.SPELLSTONE_MIXTURE.get());
                        pOutput.accept(ModItems.UNIVERSE_CORE.get());
                        pOutput.accept(ModItems.SKULL_MIXTURE.get());
                        pOutput.accept(ModItems.UNWITNESSED_GEM.get());

                        pOutput.accept(ModBlocks.FUGLITE.get());
                        pOutput.accept(ModBlocks.ENCHANTED_ETHERIUM.get());

                        pOutput.accept(ModItems.TEST_WAND.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register((eventBus));
    }

}
