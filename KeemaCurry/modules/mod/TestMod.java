package KeemaCurry.modules.mod;

import java.awt.Color;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.RenderUtil;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

public class TestMod extends Module{

	public TestMod() {
		super("Skill",Category.HUD);
	}
	
	float f = 5;
	int color = new Color(255,255,47).getRGB();
	
	public void onRender() {
		RenderUtil.drawString3D(String.valueOf(mc.playerController.curBlockDamageMP), (float) (mc.player.posX - mc.getRenderManager().renderPosX),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ), color);
		
		RenderUtil.drawLine3D(
				(float) (mc.player.posX - mc.getRenderManager().renderPosX - f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ -f),
				(float) (mc.player.posX - mc.getRenderManager().renderPosX + f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ - f),
				color);
		RenderUtil.drawLine3D(
				(float) (mc.player.posX - mc.getRenderManager().renderPosX - f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ +f),
				(float) (mc.player.posX - mc.getRenderManager().renderPosX + f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ + f),
				color);
		RenderUtil.drawLine3D(
				(float) (mc.player.posX - mc.getRenderManager().renderPosX - f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ +f),
				(float) (mc.player.posX - mc.getRenderManager().renderPosX - f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ - f),
				color);
		RenderUtil.drawLine3D(
				(float) (mc.player.posX - mc.getRenderManager().renderPosX + f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ +f),
				(float) (mc.player.posX - mc.getRenderManager().renderPosX + f),
				(float) (mc.player.posY - mc.getRenderManager().renderPosY),
				(float) (mc.player.posZ - mc.getRenderManager().renderPosZ - f),
				color);
	}
	
}
