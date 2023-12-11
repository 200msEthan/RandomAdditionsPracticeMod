package net.ethan.randomadditions.item;

import net.ethan.randomadditions.RandomAdditions;
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
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
