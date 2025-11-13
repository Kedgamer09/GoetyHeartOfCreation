package net.kedgamer.ghoc.datagen;

import net.kedgamer.ghoc.GHoC;
import net.kedgamer.ghoc.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GHoC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SPELLSTONE_MIXTURE);
        simpleItem(ModItems.CHARM_MIXTURE);
        simpleItem(ModItems.SCROLL_MIXTURE);
        simpleItem(ModItems.RING_MIXTURE);
        simpleItem(ModItems.UNIVERSE_CORE);
        simpleItem(ModItems.SKULL_MIXTURE);
        simpleItem(ModItems.TEST_WAND);
        simpleItem(ModItems.UNWITNESSED_GEM);
        simpleItem(ModItems.TEST_ITEM);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(GHoC.MOD_ID, "item/" + item.getId().getPath()));
    }


}
