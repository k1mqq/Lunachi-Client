package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Event.listener.EventRenderGUI;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

public class NoScoreboard extends Module{

	public NoScoreboard() {
		super("NoScoreboard",Category.HUD);
	}
	
	
	
	public void onEvent(Event e) {
		
	}
}
