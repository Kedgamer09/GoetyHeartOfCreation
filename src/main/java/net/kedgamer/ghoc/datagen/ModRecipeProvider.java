package net.kedgamer.ghoc.datagen;

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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FUGLITE.get())
                .pattern("BBB")
                .pattern("BUB")
                .pattern("BBB")
                .define('B', Items.BLACK_CONCRETE_POWDER)
                .define('U', ModItems.UNIVERSE_CORE.get())
                .unlockedBy(getHasName(ModItems.UNIVERSE_CORE.get()), has(ModItems.UNIVERSE_CORE.get()))
                .save(pWriter);

        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GEM.get(), 9)
                .requires(ModBlocks.GEM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GEM_BLOCK.get()), has(ModBlocks.GEM_BLOCK.get()))
                .save(pWriter);*/


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
