package KeemaCurry.modules.mod;

import org.lwjgl.input.Keyboard;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventKey;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class SkillBind extends Module{

	public SkillBind() {
		super("SkillBind",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("ModeChange", this, Keyboard.KEY_V));
		Client.settings.rSetting(new Setting("Skill Ruby", this, Keyboard.KEY_C));
		Client.settings.rSetting(new Setting("Skill Sapphire", this, Keyboard.KEY_X));
		super.setup();
	}
	
	@Override
	public void onEvent(Event e) {
		//Client.addChatMessage(Integer.toString(getItemByName("§dモードチェンジ§c-ルビー§d＆§3サファイア-")));
		if(e instanceof EventKey) {
			if(((EventKey) e).getKey() == Client.settings.getSettingsByMod(this).get(0).value_key) {
				run(0);
			}else if(((EventKey) e).getKey() == Client.settings.getSettingsByMod(this).get(1).value_key) {
				run(1);
			}else if(((EventKey) e).getKey() == Client.settings.getSettingsByMod(this).get(2).value_key) {
				run(2);
			}
		}
		super.onEvent(e);
	}
	
	private void run(int mode) {
		int egg = -1;
		if(mode == 0) {
			egg = this.getItemByName("§dモードチェンジ§c-ルビー§d＆§3サファイア-");
		}else if(mode == 1) {
			Client.addChatMessage("サポートアクション ルビーを発動しました");
			egg = this.getItemByName("§6サポートアクション§c-ルビー-");
		}else if(mode == 2) {
			Client.addChatMessage("サポートアクション サファイアを発動しました");
			egg = this.getItemByName("§6サポートアクション§3-サファイア-");
		}
		if(egg != -1) {
			ItemStack save = null;
			if(mc.player.getHeldItemMainhand() != null)
				save = mc.player.getHeldItemMainhand();
			mc.player.inventory.setPickedItemStack(mc.player.inventory.getStackInSlot(egg));
			mc.playerController.processRightClickBlock(mc.player, mc.world, mc.player.inventory.getStackInSlot(egg), new BlockPos(mc.player).add(0, -1, 0), EnumFacing.DOWN, new Vec3d(0.5,0.5,0.5), EnumHand.MAIN_HAND);
			if(save != null) {
				mc.player.inventory.setPickedItemStack(save);
			}
		}
	}
	
	private int getItemByName(String s) {
		for(int i = 0; i < 9;i++) {
			ItemStack itemStack = mc.player.inventory.getStackInSlot(i);
			
			if(itemStack == null || itemStack.getItem() == null) continue;
			
			if(itemStack.getDisplayName().equals(s)) {
				return i;
			}
		}
		return -1;
	}
}
