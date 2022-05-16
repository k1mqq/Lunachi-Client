package KeemaCurry.modules.mod;

import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventChat;
import KeemaCurry.Event.listener.EventUpdate;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.ui.StatesUI;
import KeemaCurry.utils.ScoreUtil;

public class States extends Module{

	public States() {
		super("States",Category.HUD);
	}
	
	public int level = 0;
	public int toLevel= 0;
	public int xp= 0;
	
	@Override
	public void onEnable() {
		mc.displayGuiScreen(new StatesUI());
		toggle();
		super.onEnable();
	}
	
	@Override
	public void onEvent(Event e) {
		if(e instanceof EventChat) {
			if(((EventChat) e).isSendChat())
				return;
			if(((EventChat) e).getMessage().contains("EXPの経験値を得た")) {
				int start = ((EventChat) e).getMessage().indexOf( "は");
				int end = ((EventChat) e).getMessage().indexOf("EXPの経験値を得た");
				
				int value = Integer.parseInt(((EventChat) e).getMessage().substring(start + 1, end));
				System.out.println(value);
				xp += value;
			}
		}
		
		if(e instanceof EventUpdate) {
			level = ScoreUtil.getScoreByObjective("Level", mc.player);
			toLevel = 7 * level - 7;
			if(xp > toLevel) {
				xp -= toLevel;
			}
		}
		super.onEvent(e);
	}
}
