package net.ethan.randomadditions.datagen;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.item.ModItems;
import net.ethan.randomadditions.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> JADE_SMELTABLES = List.of(ModItems.RAW_JADE.get(),
            ModBlocks.JADE_ORE.get(), ModBlocks.DEEPSLATE_JADE_ORE.get());
    public static final List<ItemLike> CHARRED_CHARCOAL_SOURCES = List.of(Items.CHARCOAL);
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        oreBlasting(pRecipeOutput, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE.get(), 0.25f, 100, "jade");
        oreSmelting(pRecipeOutput, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE.get(), 0.25f, 200, "jade");
        oreSmelting(pRecipeOutput, CHARRED_CHARCOAL_SOURCES, RecipeCategory.MISC, ModItems.CHARRED_CHARCOAL.get(), 0.5f, 200, "charred_charcoal");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JADE_BLOCK.get())
                .pattern("JJJ")
                .pattern("JJJ")
                .pattern("JJJ")
                .define('J', ModItems.JADE.get())
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_JADE_BLOCK.get())
                .pattern("JJJ")
                .pattern("JJJ")
                .pattern("JJJ")
                .define('J', ModItems.RAW_JADE.get())
                .unlockedBy(getHasName(ModItems.RAW_JADE.get()), has(ModItems.RAW_JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIVINING_ROD.get())
                .pattern("I G")
                .pattern(" S ")
                .pattern("S S")
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALARM_MINE.get())
                .pattern("GGG")
                .pattern("GJG")
                .pattern("GGG")
                .define('J', ModItems.JADE.get())
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(ModItems.JADE.get()), has(ModItems.JADE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.GLASS)
                .pattern("GG")
                .pattern("GG")
                .define('G', ModItems.GLASS_SHARD.get())
                .unlockedBy(getHasName(ModItems.GLASS_SHARD.get()), has(ModItems.GLASS_SHARD.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOWL_OF_GLASS_SHARDS.get())
                .pattern(" G ")
                .pattern("GGG")
                .pattern(" B ")
                .define('G', ModItems.GLASS_SHARD.get())
                .define('B', Items.BOWL)
                .unlockedBy(getHasName(ModItems.GLASS_SHARD.get()), has(ModItems.BOWL_OF_GLASS_SHARDS.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAINBOW_SHEARS.get())
                .pattern("I ")
                .pattern("WI")
                .define('I', Items.IRON_INGOT)
                .define('W', ItemTags.WOOL)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRAP_ORE.get())
                .pattern("TTT")
                .pattern("TDT")
                .pattern("TTT")
                .define('T', Items.TNT)
                .define('D', Items.DIAMOND_ORE)
                .unlockedBy(getHasName(Items.TNT), has(Items.TNT))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_EGGS.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', Items.EGG)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHICKEN_CANNON.get())
                .pattern("EEE")
                .pattern("HII")
                .pattern("  I")
                .define('E', ModBlocks.BLOCK_OF_EGGS.get())
                .define('H', Blocks.HAY_BLOCK)
                .define('I', Blocks.IRON_BLOCK)
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_EGGS.get()), has(ModBlocks.BLOCK_OF_EGGS.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SUGAR_GLASS.get(), 1)
                .requires(ModItems.GLASS_SHARD.get())
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.GLASS_SHARD.get()), has(ModItems.GLASS_SHARD.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JADE.get(), 9)
                .requires(ModBlocks.JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.JADE_BLOCK.get()), has(ModBlocks.JADE_BLOCK.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_JADE.get(), 9)
                .requires(ModBlocks.RAW_JADE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_JADE_BLOCK.get()), has(ModBlocks.RAW_JADE_BLOCK.get()))
                .save(pRecipeOutput);

    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput,  RandomAdditions.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
