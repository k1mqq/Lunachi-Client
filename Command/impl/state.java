package KeemaCurry.Command.impl;

import KeemaCurry.Client;
import KeemaCurry.Command.Command;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.ScoreUtil;

public class state extends Command{

	public state() {
		super("state", "E‹ÆAƒŒƒxƒ‹‚È‚Ç", "state", "s");
	}

	@Override
	public void onCommand(String[] args, String command) {
		String massage = 
				"Lv." + Integer.toString(ScoreUtil.getScoreByObjective("Level", Client.mc.player))
				+ "job = " + Integer.toString(ScoreUtil.getScoreByObjective("test", Client.mc.player));
		Client.addChatMessage(massage);
	}

}
