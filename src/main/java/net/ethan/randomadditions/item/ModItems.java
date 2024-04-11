package net.ethan.randomadditions.item;

import net.ethan.randomadditions.RandomAdditions;
import net.ethan.randomadditions.block.ModBlocks;
import net.ethan.randomadditions.item.custom.ChickenCannonItem;
import net.ethan.randomadditions.item.custom.DiviningRodItem;
import net.ethan.randomadditions.item.custom.FuelItem;
import net.ethan.randomadditions.item.custom.RainbowShearsItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = //a long list of items to add
            DeferredRegister.create(ForgeRegistries.ITEMS, RandomAdditions.MOD_ID);
    public static final RegistryObject<Item> JADE = ITEMS.register("jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_JADE = ITEMS.register("raw_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIVINING_ROD = ITEMS.register("divining_rod",
            () -> new DiviningRodItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> RAINBOW_SHEARS = ITEMS.register("rainbow_shears",
            () -> new RainbowShearsItem(new Item.Properties().durability(238)));
    public static final RegistryObject<Item> CHICKEN_CANNON = ITEMS.register("chicken_cannon",
            () -> new ChickenCannonItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> SUGAR_GLASS = ITEMS.register("sugar_glass",
            () -> new Item(new Item.Properties().food(ModFoods.SUGAR_GLASS)));
    public static final RegistryObject<Item> BOWL_OF_GLASS_SHARDS = ITEMS.register("bowl_of_glass_shards",
            () -> new Item(new Item.Properties().food(ModFoods.BOWL_OF_GLASS_SHARDS)));
    public static final RegistryObject<Item> CHARRED_CHARCOAL = ITEMS.register("charred_charcoal",
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> JADE_SWORD = ITEMS.register("jade_sword",
            () -> new SwordItem(ModToolTiers.JADE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> JADE_PICKAXE = ITEMS.register("jade_pickaxe",
            () -> new PickaxeItem(ModToolTiers.JADE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> JADE_AXE = ITEMS.register("jade_axe",
            () -> new AxeItem(ModToolTiers.JADE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> JADE_SHOVEL = ITEMS.register("jade_shovel",
            () -> new ShovelItem(ModToolTiers.JADE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> JADE_HOE = ITEMS.register("jade_hoe",
                () -> new HoeItem(ModToolTiers.JADE, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> JADE_HELMET = ITEMS.register("jade_helmet",
            () -> new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> JADE_CHESTPLATE = ITEMS.register("jade_chestplate",
            () -> new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> JADE_LEGGINGS = ITEMS.register("jade_leggings",
            () -> new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> JADE_BOOTS = ITEMS.register("jade_boots",
            () -> new ArmorItem(ModArmorMaterials.JADE, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> SUGAR_GLASS_SEEDS = ITEMS.register("sugar_glass_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SUGAR_GLASS_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GLASS_SHARD = ITEMS.register("glass_shard",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) { //registers deferredregisters
        ITEMS.register(eventBus);
    }
}
