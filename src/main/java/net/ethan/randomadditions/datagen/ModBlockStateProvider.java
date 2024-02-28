package net.ethan.randomadditions.datagen;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.block.custom.SugarGlassCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RandomAdditions.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.JADE_BLOCK);
        blockWithItem(ModBlocks.RAW_JADE_BLOCK);

        blockWithItem(ModBlocks.JADE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_JADE_ORE);

        blockWithItem(ModBlocks.ALARM_MINE);

        stairsBlock(((StairBlock) ModBlocks.JADE_STAIRS.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.JADE_SLAB.get()), blockTexture(ModBlocks.JADE_BLOCK.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.JADE_BUTTON.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.JADE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.JADE_FENCE.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.JADE_FENCE_GATE.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.JADE_WALL.get()), blockTexture(ModBlocks.JADE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.JADE_DOOR.get()), modLoc("block/jade_door_bottom"),
                modLoc("block/jade_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.JADE_TRAPDOOR.get()), modLoc("block/jade_trapdoor"),
                true, "cutout");
        makeSugarGlassCrop((CropBlock) ModBlocks.SUGAR_GLASS_CROP.get(), "sugar_glass_stage", "sugar_glass_stage");
    }

    public void makeSugarGlassCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> sugarGlassStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] sugarGlassStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SugarGlassCropBlock) block).getAgeProperty()),
                new ResourceLocation(RandomAdditions.MOD_ID, "block/" + textureName + state.getValue(((SugarGlassCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
