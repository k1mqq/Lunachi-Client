package KeemaCurry.modules.mod;

import java.awt.Color;
import java.util.List;

import com.google.common.collect.Ordering;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.ScoreUtil;
import KeemaCurry.utils.PlayerUtil;
import KeemaCurry.utils.PlayerUtil.PlayerComparator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerHUD extends Module{

	public PlayerHUD() {
		super("PlayerHUD",Category.HUD);
	}
	@Override
	public void setup() {
		this.x = 0;
		this.y = 200;
		
		this.width = 100;
		this.height = 20;
		
		Client.settings.rSetting(new Setting("Sort UP", this, false));
		super.setup();
	}
	
	public void onEvent(Event e) {
		
//				Scoreboard scoreboard = mc.thePlayer.getWorldScoreboard();
//				ScoreObjective scoreobjective = scoreboard.getObjective("MP");
//				if (scoreobjective != null) {
//					Score s = scoreboard.getOrCreateScore(player.getName(), scoreobjective);
//					MP = s.getScorePoints();
//				}
				
		if(e instanceof EventRenderGUI) {
			FontRenderer fr = Client.fr;
			ScaledResolution sr = new ScaledResolution(mc);
			
			
			
			int count = 0;
			for(Object o : mc.world.getLoadedEntityList()) {
				if(o instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) o;
					String name = player.getName();
					float health = player.getHealth();
					
					int MP = ScoreUtil.getScoreByObjective("MP", player);

					
					int hpColor = Color.HSBtoRGB(0.3f * health / player.getMaxHealth(), 0.8f, 1f);//120 * health / player.getMaxHealth()
					Color _color = Color.getHSBColor(0.35f * health / player.getMaxHealth(), 0.8f, 1f);
					Color color = new Color(_color.getRed(), _color.getGreen(), _color.getBlue(),150);
					int up = (Client.settings.getSettingsByMod(this).get(0).value_b ? -1 : +1);
					int offset = count*(fr.FONT_HEIGHT) * up;
					Gui.drawRect(x,
							y + offset, 
							(int) (x + width * health / player.getMaxHealth()),
							y + offset + fr.FONT_HEIGHT, color.getRGB());//255, 57, 66, 200    new Color(92, 255, 135,180).getRGB()
					
//					Gui.drawRect(0,
//							sr.getScaledHeight() - (10 * count), 
//							fr.getStringWidth(name + " " + Float.toString(Math.round(health*10f)/10f) + "��c\u2764 ��rMP:" + MP + 1) * health / player.getMaxHealth(),
//							sr.getScaledHeight() - (10 * count) + 10, color.getRGB());//255, 57, 66, 200    new Color(92, 255, 135,180).getRGB()
//					
					fr.drawStringWithShadow(name + " " + Float.toString(Math.round(health*10f)/10f) + "\u00A7c\u2764 \u00A7fMP:" + MP,x + 1,y + offset, -1);
					count ++;
				}
			}
		}
	}
}
