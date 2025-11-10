package net.kedgamer.ghoc.datagen;

import com.aizistral.enigmaticlegacy.registries.EnigmaticBlocks;
import com.aizistral.enigmaticlegacy.registries.EnigmaticItems;
import net.kedgamer.ghoc.GHoC;
import net.kedgamer.ghoc.block.ModBlocks;
import net.kedgamer.ghoc.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    //private static final List<ItemLike> GEM_SMELTABLES = List.of(ModItems.IMPERFECT_GEM.get(),
    //        ModBlocks.GEM_ORE.get());
    //private static final List<ItemLike> GEM_BLOCK_SMELTABLES = List.of(
    //        ModBlocks.IMPERFECT_GEM_BLOCK.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //oreSmelting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM.get(), 0.25f, 200, "gem");
        //oreBlasting(pWriter, GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GEM.get(), 0.25f, 100, "gem");
        //oreBlasting(pWriter, GEM_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.IMPERFECT_GEM_BLOCK.get(), 0.25f, 300, "gem");

        //Fuglite from universe core and black concrete powder
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FUGLITE.get(), 1)
                .pattern("BBB")
                .pattern("BUB")
                .pattern("BBB")
                .define('B', Items.BLACK_CONCRETE_POWDER)
                .define('U', ModItems.UNIVERSE_CORE.get())
                .unlockedBy(getHasName(ModItems.UNIVERSE_CORE.get()), has(ModItems.UNIVERSE_CORE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNWITNESSED_GEM.get(), 1)
                .pattern("D L")
                .pattern("NEQ")
                .pattern("R A")
                .define('D', Items.DIAMOND)
                .define('L', Items.LAPIS_LAZULI)
                .define('N', Items.NETHERITE_INGOT)
                .define('E', Items.EMERALD)
                .define('Q', Items.QUARTZ)
                .define('R', Items.REDSTONE)
                .define('A', Items.AMETHYST_SHARD)

                .unlockedBy(getHasName(ModItems.UNIVERSE_CORE.get()), has(ModItems.UNIVERSE_CORE.get()))
                .save(pWriter);

        /*ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNIVERSE_CORE.get(), 1)
                .pattern("sss")
                .pattern("ScS")
                .pattern("eee")
                .define('s', ModItems.SCROLL_MIXTURE.get())
                .define('S', ModItems.SPELLSTONE_MIXTURE.get())
                .define('c', EnigmaticItems.ENIGMATIC_ITEM)
                .define('e', ModBlocks.ENCHANTED_ETHERIUM.get())
                .unlockedBy(getHasName(EnigmaticItems.ENIGMATIC_ITEM), has(EnigmaticItems.ENIGMATIC_ITEM))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SKULL_MIXTURE.get(), 1)
                .pattern(" m ")
                .pattern(" g ")
                .pattern(" r ")
                .define('m', com.Polarice3.Goety.common.blocks.ModBlocks.REDSTONE_MONSTROSITY_HEAD_BLOCK.get())
                .define('g', com.Polarice3.Goety.common.blocks.ModBlocks.GRAVE_GOLEM_SKULL_BLOCK.get())
                .define('r', com.Polarice3.Goety.common.blocks.ModBlocks.REDSTONE_GOLEM_SKULL_BLOCK.get())
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENCHANTED_ETHERIUM.get(), 1)
                .pattern("eee")
                .pattern("ere")
                .pattern("eee")
                .define('r', com.Polarice3.Goety.common.blocks.ModBlocks.REDSTONE_MONSTROSITY_HEAD_BLOCK.get())
                .define('e', EnigmaticBlocks.ETHERIUM_BLOCK)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SCROLL_MIXTURE.get(), 1)
                .requires(EnigmaticItems.XP_SCROLL)
                .requires(EnigmaticItems.ESCAPE_SCROLL)
                .requires(EnigmaticItems.HEAVEN_SCROLL)
                .requires(EnigmaticItems.THICC_SCROLL)
                .requires(EnigmaticItems.FABULOUS_SCROLL)
                .requires(EnigmaticItems.CURSED_SCROLL)
                .requires(EnigmaticItems.AVARICE_SCROLL)
                .requires(EnigmaticItems.DARKEST_SCROLL)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RING_MIXTURE.get(), 1)
                .requires(EnigmaticItems.MAGNET_RING)
                .requires(EnigmaticItems.SUPER_MAGNET_RING)
                .requires(EnigmaticItems.ENDER_RING)
                .requires(EnigmaticItems.IRON_RING)
                .requires(EnigmaticItems.GOLDEN_RING)
                .requires(EnigmaticItems.DESOLATION_RING)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHARM_MIXTURE.get(), 1)
                .requires(EnigmaticItems.ASCENSION_AMULET)
                .requires(EnigmaticItems.MEGA_SPONGE)
                .requires(EnigmaticItems.MINING_CHARM)
                .requires(EnigmaticItems.MONSTER_CHARM)
                .requires(EnigmaticItems.BERSERK_CHARM)
                .requires(EnigmaticItems.ENCHANTER_PEARL)
                .requires(EnigmaticItems.INSIGNIA)
                .requires(EnigmaticItems.ENIGMATIC_EYE)
                .requires(EnigmaticItems.ELDRITCH_AMULET)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SPELLSTONE_MIXTURE.get(), 1)
                .requires(EnigmaticItems.EYE_OF_NEBULA)
                .requires(EnigmaticItems.BLAZING_CORE)
                .requires(EnigmaticItems.VOID_PEARL)
                .requires(EnigmaticItems.OCEAN_STONE)
                .requires(EnigmaticItems.ANGEL_BLESSING)
                .requires(EnigmaticItems.GOLEM_HEART)
                .requires(EnigmaticItems.THE_CUBE)
                .requires(EnigmaticItems.COSMIC_HEART)
                .requires(EnigmaticItems.COSMIC_HEART)
                .save(pWriter);

         */

    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, GHoC.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
