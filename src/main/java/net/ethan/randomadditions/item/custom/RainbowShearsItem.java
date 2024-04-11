package net.ethan.randomadditions.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.IForgeShearable;

import java.util.List;
import java.util.Random;

public class RainbowShearsItem extends ShearsItem {
    public RainbowShearsItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof IForgeShearable target) {
            if (entity.level().isClientSide) return InteractionResult.SUCCESS; //show shear animation
            BlockPos pos = BlockPos.containing(entity.position()); //get the location of the sheep
            if (target.isShearable(stack, entity.level(), pos)) { //if shearable
                List<ItemStack> drops = target.onSheared(playerIn, stack, entity.level(), pos, //make a list of items (wool)
                        stack.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE));
                Random rand = new Random();
                drops.forEach(d -> {
                    //generate a random color
                    DyeColor randomColor = DyeColor.values()[rand.nextInt(DyeColor.values().length)];
                    ItemStack woolStack = null;
                    switch(randomColor){ //set the woolstack to whatever color wool randomColor gives
                        case WHITE -> woolStack = new ItemStack(Items.WHITE_WOOL);
                        case ORANGE -> woolStack = new ItemStack(Items.ORANGE_WOOL);
                        case MAGENTA -> woolStack = new ItemStack(Items.MAGENTA_WOOL);
                        case LIGHT_BLUE -> woolStack = new ItemStack(Items.LIGHT_BLUE_WOOL);
                        case YELLOW -> woolStack = new ItemStack(Items.YELLOW_WOOL);
                        case LIME -> woolStack = new ItemStack(Items.LIME_WOOL);
                        case PINK -> woolStack = new ItemStack(Items.PINK_WOOL);
                        case GRAY -> woolStack = new ItemStack(Items.GRAY_WOOL);
                        case LIGHT_GRAY -> woolStack = new ItemStack(Items.LIGHT_GRAY_WOOL);
                        case CYAN -> woolStack = new ItemStack(Items.CYAN_WOOL);
                        case PURPLE -> woolStack = new ItemStack(Items.PURPLE_WOOL);
                        case BLUE -> woolStack = new ItemStack(Items.BLUE_WOOL);
                        case BROWN-> woolStack = new ItemStack(Items.BROWN_WOOL);
                        case GREEN -> woolStack = new ItemStack(Items.GREEN_WOOL);
                        case RED -> woolStack = new ItemStack(Items.RED_WOOL);
                        case BLACK -> woolStack = new ItemStack(Items.BLACK_WOOL);
                        
                    }
                    ItemEntity ent = entity.spawnAtLocation(woolStack, 1.0F);
                    //spawn the entity and make it drop in a random direction
                    //taken from ShearsItem.java
                    ent.setDeltaMovement(ent.getDeltaMovement().add((double)((rand.nextFloat() - rand.nextFloat()) * 0.1F), (double)(rand.nextFloat() * 0.05F), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F)));
                });
                stack.hurtAndBreak(1, playerIn, e -> e.broadcastBreakEvent(hand));
                //taken from ShearsItem.java
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}