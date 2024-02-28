package net.ethan.randomadditions.datagen.loot;

import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.block.custom.SugarGlassCropBlock;
import net.ethan.randomadditions.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_JADE_BLOCK.get());
        this.dropSelf(ModBlocks.ALARM_MINE.get());

        this.add(ModBlocks.JADE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.JADE_ORE.get(), ModItems.RAW_JADE.get()));
        this.add(ModBlocks.DEEPSLATE_JADE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_JADE_ORE.get(), ModItems.RAW_JADE.get()));

        this.dropSelf(ModBlocks.JADE_STAIRS.get());
        this.dropSelf(ModBlocks.JADE_BUTTON.get());
        this.dropSelf(ModBlocks.JADE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.JADE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.JADE_FENCE.get());
        this.dropSelf(ModBlocks.JADE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.JADE_WALL.get());

        this.add(ModBlocks.JADE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.JADE_SLAB.get()));
        this.add(ModBlocks.JADE_DOOR.get(),
                block -> createDoorTable(ModBlocks.JADE_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SUGAR_GLASS_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SugarGlassCropBlock.AGE, 5));
        this.add(ModBlocks.SUGAR_GLASS_CROP.get(), createCropDrops(ModBlocks.SUGAR_GLASS_CROP.get(), ModItems.SUGAR_GLASS.get(),
                ModItems.SUGAR_GLASS_SEEDS.get(), lootitemcondition$builder));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
