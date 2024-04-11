package net.ethan.randomadditions.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class TrapOreBlock extends TntBlock {
    public TrapOreBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void playerDestroy(Level pLevel, Player pPlayer,
                              BlockPos pPos, BlockState pState,
                              @Nullable BlockEntity pBlockEntity, ItemStack pTool) {
        if (!pTool.isEmpty()) { //if it is the right tool (pickaxe)
            //spawn a primed tnt at the block
            PrimedTnt primedtnt = new PrimedTnt(pLevel, (double)pPos.getX() + 0.5D, (double)pPos.getY(), (double)pPos.getZ() + 0.5D, pPlayer);
            primedtnt.setFuse(1); //set the fuse of the tnt to 1 tick (1/20 of a second)
            pLevel.addFreshEntity(primedtnt); //actually spawn the tnt
            pLevel.gameEvent(pPlayer, GameEvent.PRIME_FUSE, pPos);
        }
        super.playerDestroy(pLevel, pPlayer, pPos, pState, pBlockEntity, pTool);
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("Explodes when mined"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
