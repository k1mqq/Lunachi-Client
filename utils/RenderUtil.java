package KeemaCurry.utils;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import KeemaCurry.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

public class RenderUtil {
	public static void drawEntityBox(Entity entity, int mode)
	{
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(1.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
//		if(mode == 0)// Enemy
//			GL11.glColor4d(
//				1 - Minecraft.getMinecraft().thePlayer
//					.getDistanceToEntity(entity) / 40,
//				Minecraft.getMinecraft().thePlayer.getDistanceToEntity(entity) / 40,
//				0, 0.5F);
//		else if(mode == 1)// Friend
//			GL11.glColor4d(1, 1, 1, 0.5F);
//		else if(mode == 2)// Other
//			GL11.glColor4d(1, 1, 0, 0.5F);
//		else if(mode == 3)// Target
//			GL11.glColor4d(1, 0, 0, 0.5F);
//		else if(mode == 4)// Team
//			GL11.glColor4d(0, 1, 0, 0.5F);
		Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.renderFilledBox(
			new AxisAlignedBB(
				entity.boundingBox.minX
					- 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().renderPosX),
				entity.boundingBox.minY
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().renderPosY),
				entity.boundingBox.minZ
					- 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().renderPosZ),
				entity.boundingBox.maxX
					+ 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().renderPosX),
				entity.boundingBox.maxY
					+ 0.1
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().renderPosY),
				entity.boundingBox.maxZ
					+ 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().renderPosZ)), 1, 1, 1, 0.4f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public static void drawBlockBox(double x,double y,double z,float red,float green,float blue,float alpha)
	{
//		double x =
//				blockPos.getX()
//					- Minecraft.getMinecraft().getRenderManager().renderPosX;
//			double y =
//				blockPos.getY()
//					- Minecraft.getMinecraft().getRenderManager().renderPosY;
//			double z =
//				blockPos.getZ()
//					- Minecraft.getMinecraft().getRenderManager().renderPosZ;
			GL11.glBlendFunc(770, 771);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glLineWidth(2.0F);
			GL11.glColor4d(0, 1, 0, 0.15F);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			//drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
			GL11.glColor4d(0, 0, 1, 0.5F);
			RenderGlobal.renderFilledBox(new AxisAlignedBB(x, y, z,
				x + 1.0, y + 1.0, z + 1.0), red, green, blue, alpha);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(true);
			GL11.glDisable(GL11.GL_BLEND);
	}
	
//	public static void blockESPBox(BlockPos blockPos)
//	{
//		double x =
//				blockPos.getX()
//					- Minecraft.getMinecraft().getRenderManager().renderPosX;
//			double y =
//				blockPos.getY()
//					- Minecraft.getMinecraft().getRenderManager().renderPosY;
//			double z =
//				blockPos.getZ()
//					- Minecraft.getMinecraft().getRenderManager().renderPosZ;
	
	public static void renderItem(ItemStack stack, int x, int y) {
        GL11.glPushMatrix();
        GL11.glDepthMask(true);
        GlStateManager.clear(256);
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().zLevel = -100.0f;
        GlStateManager.scale(1.0f, 1.0f, 0.01f);
        GlStateManager.enableDepth();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(stack, x, y + 8);
        //mc.getRenderItem().renderItemOverlayIntoGUINameTags(mc.fontRendererObj, stack, x - 1, y + 10, null);
        Minecraft.getMinecraft().getRenderItem().zLevel = 0.0f;
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.disableDepth();
        //NameTags.renderEnchantText(stack, x, y);
        GlStateManager.enableDepth();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GL11.glPopMatrix();
    }
	
	public static void spawner(double x,double y,double z,float red,float green,float blue,float alpha, int range) {
		drawBlockBox(x, y, z, red, green, blue, alpha);
		int color = new Color(red,green,blue,alpha).getRGB();
		if(range != -1) {
			drawLine3D((float)x - range,(float)y - range,(float)z - range,(float)x + range,(float)y - range,(float)z - range, color);
			drawLine3D((float)x - range,(float)y + range,(float)z - range,(float)x + range,(float)y + range,(float)z - range, color);
			drawLine3D((float)x - range,(float)y - range,(float)z + range,(float)x + range,(float)y - range,(float)z + range, color);
			drawLine3D((float)x - range,(float)y + range,(float)z + range,(float)x + range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x - range,(float)y - range,(float)z - range,(float)x - range,(float)y + range,(float)z - range, color);
			drawLine3D((float)x + range,(float)y - range,(float)z - range,(float)x + range,(float)y + range,(float)z - range, color);
			drawLine3D((float)x - range,(float)y - range,(float)z + range,(float)x - range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y - range,(float)z + range,(float)x + range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x - range,(float)y - range,(float)z - range,(float)x - range,(float)y - range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y - range,(float)z - range,(float)x + range,(float)y - range,(float)z + range, color);
			drawLine3D((float)x - range,(float)y + range,(float)z - range,(float)x - range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y + range,(float)z - range,(float)x + range,(float)y + range,(float)z + range, color);
			
			drawLine3D((float)x - range,(float)y - range,(float)z - range,(float)x + range,(float)y - range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y - range,(float)z - range,(float)x - range,(float)y - range,(float)z + range, color);
			
			drawLine3D((float)x - range,(float)y + range,(float)z - range,(float)x + range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y + range,(float)z - range,(float)x - range,(float)y + range,(float)z + range, color);
			
			drawLine3D((float)x - range,(float)y - range,(float)z - range,(float)x - range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x - range,(float)y - range,(float)z + range,(float)x - range,(float)y + range,(float)z - range, color);
			
			drawLine3D((float)x + range,(float)y - range,(float)z - range,(float)x + range,(float)y + range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y - range,(float)z + range,(float)x + range,(float)y + range,(float)z - range, color);
			
			drawLine3D((float)x - range,(float)y + range,(float)z + range,(float)x + range,(float)y - range,(float)z + range, color);
			drawLine3D((float)x + range,(float)y + range,(float)z + range,(float)x - range,(float)y - range,(float)z + range, color);
			
			drawLine3D((float)x - range,(float)y + range,(float)z - range,(float)x + range,(float)y - range,(float)z - range, color);
			drawLine3D((float)x + range,(float)y + range,(float)z - range,(float)x - range,(float)y - range,(float)z - range, color);
		}
	}
	
	public static void drawLine3D(float x, float y, float z, float x1, float y1, float z1, int color) {
        pre3D();
        GL11.glLoadIdentity();
        Client.mc.entityRenderer.orientCamera(Client.mc.timer.renderPartialTicks);
        float var11 = (color >> 24 & 0xFF) / 255.0F;
        float var6 = (color >> 16 & 0xFF) / 255.0F;
        float var7 = (color >> 8 & 0xFF) / 255.0F;
        float var8 = (color & 0xFF) / 255.0F;
        GL11.glColor4f(var6, var7, var8, var11);
        GL11.glLineWidth(0.5f);
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(x, y, z);
        GL11.glVertex3d(x1, y1, z1);
        GL11.glEnd();
        post3D();
    }

	private static void post3D() {
		GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
	}

	private static void pre3D() {
		GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glHint(3154, 4354);
	}
}
