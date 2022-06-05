package KeemaCurry.modules.mod;

import org.lwjgl.input.Keyboard;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventKey;
import KeemaCurry.Event.listener.EventPacket;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.ColorUtill;
import KeemaCurry.utils.font.FontUtil;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketEntityVelocity;

public class Debag extends Module{

	public Debag() {
		super("Debag",Category.CLIENT);
	}
	
	
	@Override
	public void onEnable() {
		mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F));
		super.onEnable();
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("Velocity", this, false));
		Client.settings.rSetting(new Setting("HUD", this, false));
		super.setup();
	}
	
	public void onRender() {
	}
	
	public void onEvent(Event e) {
		ScaledResolution sr = new ScaledResolution(mc);
		if(e instanceof EventRenderGUI) {
			if(!Client.settings.getSettingsByMod(this).get(1).value_b)
				return;
			Client.fr.setUnicodeFlag(false);
			int count = 0;
			for(Module m : Client.getEnableModule()) {
				float offset = count*(Client.fr.FONT_HEIGHT);

				Client.fr.drawStringWithShadow(m.name, sr.getScaledWidth() - Client.fr.getStringWidth(m.name), (int)offset, ColorUtill.gerRainbow(5, 1f, 1, count*100));
				count++;
			}
			FontUtil.normal.drawStringWithShadow(Client.name + " v" + Client.version, 0, 0, ColorUtill.gerRainbow(10f,1f, 1f, 100));
			FontUtil.normal.drawStringWithShadow("X:" + Math.floor(mc.player.posX * 10) / 10, 0, sr.getScaledHeight() - Client.fr.FONT_HEIGHT * 3, -1);
			FontUtil.normal.drawStringWithShadow("Y:" + Math.floor(mc.player.posY * 10) / 10, 0, sr.getScaledHeight() - Client.fr.FONT_HEIGHT * 2, -1);
			FontUtil.normal.drawStringWithShadow("Z:" + Math.floor(mc.player.posX * 10) / 10, 0, sr.getScaledHeight() - Client.fr.FONT_HEIGHT * 1, -1);
			
			Client.fr.setUnicodeFlag(true);
		}
		
			mc.rightClickDelayTimer = 0;
		if(e instanceof EventKey) {
			if(((EventKey) e).getKey() == Keyboard.KEY_G) {
				mc.getConnection().sendPacket(new CPacketPlayer(true));
			}
		}
		
		
		if(e instanceof EventPacket){
			if(Client.settings.getSettingsByMod(this).get(0).isValue_b()) {
				if(((EventPacket) e).getPacket() instanceof SPacketEntityVelocity) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	public void drawStringUnUnicode(String text,int x,int y,int color) {
		Client.fr.setUnicodeFlag(false);
		Client.fr.drawStringWithShadow(text, x, y, color);
		Client.fr.setUnicodeFlag(true);
	}
	
}
