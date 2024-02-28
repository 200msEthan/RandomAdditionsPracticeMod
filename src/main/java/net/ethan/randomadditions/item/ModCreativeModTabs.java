package net.ethan.randomadditions.item;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomAdditions.MOD_ID);
    public static final RegistryObject<CreativeModeTab> RANDOM_ADDITIONS_TAB =
            CREATIVE_MODE_TABS.register("random_additions_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.JADE.get()))
                    .title(Component.translatable("creativetab.random_additions_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.JADE.get());
                        output.accept(ModItems.RAW_JADE.get());

                        output.accept(ModBlocks.JADE_BLOCK.get());
                        output.accept(ModBlocks.RAW_JADE_BLOCK.get());

                        output.accept(ModBlocks.JADE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_JADE_ORE.get());

                        output.accept(ModItems.DIVINING_ROD.get());
                        output.accept(ModItems.SUGAR_GLASS.get());
                        output.accept(ModItems.CHARRED_CHARCOAL.get());
                        output.accept(ModBlocks.ALARM_MINE.get());

                        output.accept(ModBlocks.JADE_STAIRS.get());
                        output.accept(ModBlocks.JADE_SLAB.get());
                        output.accept(ModBlocks.JADE_BUTTON.get());
                        output.accept(ModBlocks.JADE_PRESSURE_PLATE.get());

                        output.accept(ModBlocks.JADE_FENCE.get());
                        output.accept(ModBlocks.JADE_FENCE_GATE.get());
                        output.accept(ModBlocks.JADE_WALL.get());

                        output.accept(ModBlocks.JADE_DOOR.get());
                        output.accept(ModBlocks.JADE_TRAPDOOR.get());

                        output.accept(ModItems.JADE_SWORD.get());
                        output.accept(ModItems.JADE_PICKAXE.get());
                        output.accept(ModItems.JADE_AXE.get());
                        output.accept(ModItems.JADE_SHOVEL.get());
                        output.accept(ModItems.JADE_HOE.get());

                        output.accept(ModItems.JADE_HELMET.get());
                        output.accept(ModItems.JADE_CHESTPLATE.get());
                        output.accept(ModItems.JADE_LEGGINGS.get());
                        output.accept(ModItems.JADE_BOOTS.get());

                        output.accept(ModItems.SUGAR_GLASS_SEEDS.get());

                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
