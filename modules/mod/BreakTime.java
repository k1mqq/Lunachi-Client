package KeemaCurry.modules.mod;

import org.lwjgl.input.Mouse;

import KeemaCurry.Event.Event;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.RenderUtil;
import net.minecraft.util.math.BlockPos;

public class BreakTime extends Module{

	public BreakTime() {
		super("BreakTime",Category.CLIENT);
	}
	
	public void onRender() {
		BlockPos blockpos = mc.objectMouseOver.getBlockPos();
		if(blockpos != null && !mc.world.isAirBlock(blockpos) && Mouse.isButtonDown(0)) {
			RenderUtil.drawString3D(String.valueOf(Math.floor(mc.playerController.curBlockDamageMP * 1000) / 10) + "Åì", (float) (blockpos.getX() + 0.5f - mc.getRenderManager().renderPosX),
					(float) (blockpos.getY() +0.5f - mc.getRenderManager().renderPosY),
					(float) (blockpos.getZ() + 0.5f - mc.getRenderManager().renderPosZ), -1);
		}
	}
	
	public void onEvent(Event e) {
		
	}
	
}
