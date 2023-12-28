package net.ethan.randomadditions.datagen;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RandomAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.RAW_JADE);
        simpleItem(ModItems.SUGAR_GLASS);
        simpleItem(ModItems.DIVINING_ROD);
        simpleItem(ModItems.CHARRED_CHARCOAL);

        simpleBlockItem(ModBlocks.JADE_DOOR);

        fenceItem(ModBlocks.JADE_FENCE, ModBlocks.JADE_BLOCK);
        buttonItem(ModBlocks.JADE_BUTTON, ModBlocks.JADE_BLOCK);
        wallItem(ModBlocks.JADE_WALL, ModBlocks.JADE_BLOCK);

        evenSimplerBlockItem(ModBlocks.JADE_STAIRS);
        evenSimplerBlockItem(ModBlocks.JADE_SLAB);
        evenSimplerBlockItem(ModBlocks.JADE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.JADE_FENCE_GATE);

        trapdoorItem(ModBlocks.JADE_TRAPDOOR);

        handheldItem(ModItems.JADE_SWORD);
        handheldItem(ModItems.JADE_PICKAXE);
        handheldItem(ModItems.JADE_AXE);
        handheldItem(ModItems.JADE_SHOVEL);
        handheldItem(ModItems.JADE_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RandomAdditions.MOD_ID, "item/" + item.getId().getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RandomAdditions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RandomAdditions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(RandomAdditions.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RandomAdditions.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(RandomAdditions.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(RandomAdditions.MOD_ID,"item/" + item.getId().getPath()));
    }
}
