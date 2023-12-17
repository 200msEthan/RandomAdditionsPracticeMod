package net.ethan.randomadditions.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class AlarmMineBlock extends Block {
    public AlarmMineBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos,
                       BlockState pState, Entity pEntity) {
        pLevel.playSound(pEntity, pPos, SoundEvents.BELL_BLOCK, SoundSource.BLOCKS,
                1f, 1f);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
