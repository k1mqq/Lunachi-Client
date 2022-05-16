package KeemaCurry.modules.mod;

import org.lwjgl.input.Keyboard;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventKey;
import KeemaCurry.Event.listener.EventPacket;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlayerAbilities;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class BreakTime extends Module{

	public BreakTime() {
		super("BreakTime",Category.CLIENT);
	}
	
	public void onRender() {
	}
	
	public void onEvent(Event e) {
		if(e instanceof EventPacket){
			if(((EventPacket) e).getPacket() instanceof CPacketPlayerDigging) {
				CPacketPlayerDigging packet = (CPacketPlayerDigging)((EventPacket) e).getPacket();
				
				if(packet.getAction() == Action.START_DESTROY_BLOCK) {
					float speed = mc.player.getDigSpeed(mc.world.getBlockState(mc.objectMouseOver.getBlockPos()));
					Client.addChatMessage(String.valueOf(speed));
				}
			}
		}
	}
	
}
