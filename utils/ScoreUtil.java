package KeemaCurry.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

public class ScoreUtil {
	
	
	public static int getScoreByObjective(String name, EntityPlayer player) {
//		Scoreboard scoreboard = Minecraft.getMinecraft().theWorld.getScoreboard();
//		ScoreObjective scoreobjective = scoreboard.getObjective(name);
//		if (scoreobjective != null) {
//			Score s = scoreboard.getOrCreateScore(player.getName(), scoreobjective);
//			return s.getScorePoints();
//		}
		
		return Minecraft.getMinecraft().world.getScoreboard().getOrCreateScore(player.getName(),Minecraft.getMinecraft().world.getScoreboard().getObjective(name)).getScorePoints();
	}
}
