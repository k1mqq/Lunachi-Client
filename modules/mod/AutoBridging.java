package KeemaCurry.modules.mod;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoBridging extends Module{

	public AutoBridging() {
		super("AutoBridging",Category.CLIENT);
	}
	
	@Override
	public void onEnable() {
		BlockPos player = new BlockPos(mc.player);
		place(player.add(2,-2,-3));
		place(player.add(2,-1,-3));
		place(player.add(2,0,-3));
		place(player.add(2,1,-3));
		place(player.add(2,2,-3));
		
		place(player.add(2,-2,-2));
		place(player.add(2,0,-2));
		place(player.add(2,2,-2));
		
		place(player.add(2,-2,-1));
		place(player.add(2,0,-1));
		place(player.add(2,2,-1));
		
		place(player.add(2,-2,1));
		place(player.add(2,-2,2));
		place(player.add(2,-2,3));
		
		place(player.add(2,2,1));
		place(player.add(2,2,2));
		place(player.add(2,2,3));
		
		place(player.add(2,1,3));
		place(player.add(2,-1,1));
		
		place(player.add(2,0,2));
		
		
		toggle();
		super.onEnable();
	}
	
	public void onEvent(Event e) {
		
	}
	
	void place(BlockPos pos) {
		if(mc.player.getHeldItemMainhand() != null && mc.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
			mc.player.swingArm(EnumHand.MAIN_HAND);
			mc.playerController.processRightClickBlock(mc.player, mc.world, mc.player.getHeldItemMainhand(), pos, EnumFacing.DOWN, new Vec3d(0.5,0.5,0.5), EnumHand.MAIN_HAND);
		}
	}
}
