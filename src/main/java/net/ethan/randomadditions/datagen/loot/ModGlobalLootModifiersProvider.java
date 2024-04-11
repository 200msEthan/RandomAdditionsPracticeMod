package net.ethan.randomadditions.datagen.loot;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.item.ModItems;
import net.ethan.randomadditions.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, RandomAdditions.MOD_ID);
    }

    @Override
    protected void start() {
        add("base_glass_shard_from_glass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GLASS).build()},
                ModItems.GLASS_SHARD.get()));
        add("bonus_glass_shard_from_glass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GLASS).build(),
                LootItemRandomChanceCondition.randomChance(0.50f).build()},
                ModItems.GLASS_SHARD.get()));
        add("sugar_glass_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()
        }, ModItems.SUGAR_GLASS.get()));
        add("divining_rod_from_desert_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build()
        }, ModItems.DIVINING_ROD.get()));
    }
}
