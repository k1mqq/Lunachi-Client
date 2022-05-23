package KeemaCurry.modules.mod;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class BossBar extends Module{

	public BossBar() {
		super("BossBar",Category.HUD);
	}
	
	private static final ResourceLocation GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");
	
	
	public void onEvent(Event e) {
		if(e instanceof EventRenderGUI) {
			int count = 0;
			for(Object o : mc.world.loadedEntityList) {
				if(o instanceof EntityZombie) {
					EntityZombie entity = (EntityZombie) o;
					
					if(entity.getHeldItemMainhand() != null && entity.getHeldItemMainhand().getMaxDamage() == 1561) {
						mc.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
						
						mc.ingameGUI.drawTexturedModalRect(x, y, 0, 10, 182, 5);
						
						int i = (int)((entity.getHealth() / entity.getMaxHealth()) * 183.0F);
						
						mc.ingameGUI.drawTexturedModalRect(x, y, 0, 15, i, 5);
					}
					
					
				}
			}
		}
	}
}
