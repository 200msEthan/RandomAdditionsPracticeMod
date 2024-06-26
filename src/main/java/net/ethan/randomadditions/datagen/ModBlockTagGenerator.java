package net.ethan.randomadditions.datagen;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.item.ModToolTiers;
import net.ethan.randomadditions.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RandomAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DIVINING_ROD_VALUABLES)
                .add(ModBlocks.JADE_BLOCK.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.JADE_BLOCK.get(),
                        ModBlocks.JADE_ORE.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_JADE_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_JADE_TOOL)
                .add(ModBlocks.ALARM_MINE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.JADE_ORE.get(),
                        ModBlocks.DEEPSLATE_JADE_ORE.get(),
                        ModBlocks.JADE_BLOCK.get(),
                        ModBlocks.RAW_JADE_BLOCK.get(),
                        ModBlocks.ALARM_MINE.get(),
                        ModBlocks.TRAP_ORE.get(),
                        ModBlocks.BLOCK_OF_EGGS.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.JADE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.JADE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.JADE_WALL.get());

    }
}
