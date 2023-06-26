package KeemaCurry.modules.mod;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.settings.KeyBinding;

public class ToggleSprint extends Module{

	public ToggleSprint() {
		super("ToggleSprint",Category.HUD);
	}
	
	@Override
	public void setup() {
		x = 0;
		y = 0;
		super.setup();
	}
	
	boolean toggledSprint = false;
	
	@Override
	public void onEvent(Event e) {
		if(e instanceof EventUpdate) {
			
		}
		
		if(e instanceof EventRenderGUI) {
			if(mc.gameSettings.keyBindSprint.isPressed()) {
				toggledSprint = !toggledSprint;
			}
			
			if(toggledSprint) {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
			}
			String text = "";
			
			if(mc.player.isSprinting()) {
				if(toggledSprint) {
					text = "[Sprinting (Toggled)]";
				}else {
					text = "[Sprinting (Vanilla)]";
				}
			}else if(mc.player.isSneaking()) {
				
				text = "[Sneaking (KeyHeld)]";
			}
			
			mc.fontRendererObj.drawString(text, x, y, -1);
		}
		super.onEvent(e);
	}
}
