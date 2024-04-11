package net.ethan.randomadditions.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChickenCannonItem extends Item {
    public ChickenCannonItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if (pLevel.isClientSide || pLevel == null)
            return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));

        BlockPos pPlayerPos = pPlayer.blockPosition();
        //modified from Projectile.java
        double XFacingScalar = -Mth.sin(pPlayer.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(pPlayer.getXRot() * ((float)Math.PI / 180F));
        double YFacingScalar = -Mth.sin((float) (pPlayer.getXRot() * ((float)Math.PI / 180F)));
        double ZFacingScalar = Mth.cos(pPlayer.getYRot() * ((float)Math.PI / 180F)) * Mth.cos(pPlayer.getXRot() * ((float)Math.PI / 180F));
        //spawn the chicken slightly in front of where the player is facing
        //numbers are offsets
        double spawnX = pPlayerPos.getX() + 0.5 + XFacingScalar;
        double spawnY = pPlayerPos.getY() + 1.62 + YFacingScalar*1.8;
        double spawnZ = pPlayerPos.getZ() + 0.5 + ZFacingScalar;
        /* debug
        pPlayer.sendSystemMessage(Component.literal("XVEC is: " + XFacingScalar));
        pPlayer.sendSystemMessage(Component.literal("YVEC is: " + YFacingScalar));
        pPlayer.sendSystemMessage(Component.literal("ZVEC is: " + ZFacingScalar));
        */

        Chicken chicken = EntityType.CHICKEN.create(pLevel);
        if (chicken != null) {
            chicken.setPos(spawnX, spawnY, spawnZ); //spawn the chicken
            pLevel.addFreshEntity(chicken);

            //redundant variables, just for reading clarity
            double velocityX = XFacingScalar;
            double velocityY = YFacingScalar;
            double velocityZ = ZFacingScalar;
            chicken.setDeltaMovement(velocityX, velocityY, velocityZ); //launch the chicken
        }

        ItemStack stack = pPlayer.getItemInHand(pUsedHand); //get the item stack
        stack.hurtAndBreak(1, pPlayer, e -> e.broadcastBreakEvent(pUsedHand)); //damage the stack
        //item damaging taken from ShearsItem.java
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }
    /*
            original code from Projectile.java
            net/minecraft/world/entity/projectile/Projectile.java

    public void shoot(Entity pShooter, float pX, float pY, float pZ, float pVelocity, float pInaccuracy) {
        float f = -Mth.sin(pY * ((float)Math.PI / 180F)) * Mth.cos(pX * ((float)Math.PI / 180F));
        float f1 = -Mth.sin((pX + pZ) * ((float)Math.PI / 180F));
        float f2 = Mth.cos(pY * ((float)Math.PI / 180F)) * Mth.cos(pX * ((float)Math.PI / 180F));
        this.shoot((double)f, (double)f1, (double)f2, pVelocity, pInaccuracy);
        Vec3 vec3 = pShooter.getDeltaMovement();
        this.setDeltaMovement(this.getDeltaMovement().add(vec3.x, pShooter.onGround() ? 0.0D : vec3.y, vec3.z));
    }
    */
}
