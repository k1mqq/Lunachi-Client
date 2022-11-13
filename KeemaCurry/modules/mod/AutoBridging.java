package KeemaCurry.modules.mod;

import org.lwjgl.input.Mouse;

import KeemaCurry.Client;
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
		
		
		
		
		
		
		super.onEnable();
	}
	
	public void onEvent(Event e) {
		if(Mouse.isButtonDown(1)) {
			BlockPos player = new BlockPos(mc.player);
			
			for(int i = -2; i < 2;i++) {
				for(int ii = -2; ii < 2;ii++) {
					place(player.add(i,-1,ii));
				}
			}
		}
	}
	
	void place(BlockPos pos) {
		if(mc.player.getHeldItemMainhand() != null && mc.player.getHeldItemMainhand().getItem() instanceof ItemBlock) {
			mc.player.swingArm(EnumHand.MAIN_HAND);
			mc.playerController.processRightClickBlock(mc.player, mc.world, mc.player.getHeldItemMainhand(), pos, EnumFacing.DOWN, new Vec3d(0.5,0.5,0.5), EnumHand.MAIN_HAND);
		}
	}
	
	void ez(BlockPos pos) {
		place(pos.add(2,-2,-3));
		place(pos.add(2,-1,-3));
		place(pos.add(2,0,-3));
		place(pos.add(2,1,-3));
		place(pos.add(2,2,-3));
		
		place(pos.add(2,-2,-2));
		place(pos.add(2,0,-2));
		place(pos.add(2,2,-2));
		
		place(pos.add(2,-2,-1));
		place(pos.add(2,0,-1));
		place(pos.add(2,2,-1));
		
		place(pos.add(2,-2,1));
		place(pos.add(2,-2,2));
		place(pos.add(2,-2,3));
		
		place(pos.add(2,2,1));
		place(pos.add(2,2,2));
		place(pos.add(2,2,3));
		
		place(pos.add(2,1,3));
		place(pos.add(2,-1,1));
		
		place(pos.add(2,0,2));
	}
	
	void thinking(BlockPos player) {
		place(player.add(2,0,0));
		place(player.add(2,0,-1));
		place(player.add(2,0,1));
		place(player.add(2,1,0));
		place(player.add(2,2,0));
	}
}
