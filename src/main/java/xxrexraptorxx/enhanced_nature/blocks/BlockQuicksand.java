package xxrexraptorxx.enhanced_nature.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class BlockQuicksand extends FallingBlock {

	protected static final VoxelShape CUSTOM_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);


	public BlockQuicksand() {
		super(Properties.of()
				.strength(0.65F, 0.0F)
				.sound(SoundType.SAND)
				.mapColor(MapColor.SAND)
				.noOcclusion()
				.instrument(NoteBlockInstrument.SNARE)
		);
	}


	@Override
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return CUSTOM_SHAPE;
	}


	@Override
	public void entityInside(BlockState state, Level level, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity) {
			LivingEntity entity = (LivingEntity) entityIn;

			entity.makeStuckInBlock(state, new Vec3(0.25D, 0.10D, 0.25D));
			if(entity.getEyePosition().y < pos.getY() + 1) entity.hurt(level.damageSources().inWall(), 1.0F);
		}
	}

}