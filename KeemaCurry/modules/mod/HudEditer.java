package KeemaCurry.modules.mod;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.ui.StatesUI;
import KeemaCurry.utils.ScoreUtil;

public class HudEditer extends Module{

	public HudEditer() {
		super("HUDEditer",Category.CLIENT);
	}
	
	public int level = 0;
	public int toLevel= 0;
	public int xp= 0;
	
	@Override
	public void onEnable() {
		mc.displayGuiScreen(new KeemaCurry.ui.HudEditer());
		toggle();
		super.onEnable();
	}
	
	@Override
	public void onEvent(Event e) {
		super.onEvent(e);
	}
}
