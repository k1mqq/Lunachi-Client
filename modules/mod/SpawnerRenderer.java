package KeemaCurry.modules.mod;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;
import KeemaCurry.utils.RenderUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecartMobSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;

public class SpawnerRenderer extends Module{

	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("SpawnRange", this, true));
		Client.settings.rSetting(new Setting("Red", this, 1,0, 1, false));
		Client.settings.rSetting(new Setting("Green", this, 1,0, 1, false));
		Client.settings.rSetting(new Setting("Blue", this, 1,0, 1, false));
		Client.settings.rSetting(new Setting("Alpha", this, 0.3f, 0, 1, false));
		super.setup();
	}
	
	public SpawnerRenderer() {
		super("SpawnerPlus",Category.RENDER);
	}
	
	public void onRender() {
		if(toggled) {
			int range = 0;
			for(Object o : mc.world.loadedEntityList) {
				if(o instanceof Entity) {
					if(o instanceof EntityMinecartMobSpawner) {
//						RenderUtil.entityESPBox((Entity) o, 1);
						if(Client.settings.getSettingsByMod(this).get(0).isValue_b() &&
								mc.player.getDistanceToEntity((Entity) o) <50) {
							
							range = ((EntityMinecartMobSpawner) o).mobSpawnerLogic.spawnRange;
						}else {
							range = -1;
						}
						RenderUtil.spawner(((EntityMinecartMobSpawner) o).getPosition().getX() - mc.getRenderManager().renderPosX,
								((EntityMinecartMobSpawner) o).getPosition().getY() - mc.getRenderManager().renderPosY,
								((EntityMinecartMobSpawner) o).getPosition().getZ() - mc.getRenderManager().renderPosZ,
								Client.settings.getSettingsByMod(this).get(1).getValue_f(),
								Client.settings.getSettingsByMod(this).get(2).getValue_f(),
								Client.settings.getSettingsByMod(this).get(3).getValue_f(),
								Client.settings.getSettingsByMod(this).get(4).getValue_f(),
								-1);
					}
				}
			}
			
			range = 0;
			for(Object o : mc.world.loadedTileEntityList) {
				if(o instanceof TileEntityMobSpawner) {
					if(Client.settings.getSettingsByMod(this).get(0).isValue_b() &&
							mc.player.getDistanceSq(((TileEntity) o).getPos()) < 100) {
						range = ((TileEntityMobSpawner) o).getSpawnerBaseLogic().spawnRange;
					}else {
						range = -1;
					}
					RenderUtil.spawner(
							((TileEntity) o).getPos().getX() - mc.getRenderManager().renderPosX,
							((TileEntity) o).getPos().getY() - mc.getRenderManager().renderPosY,
							((TileEntity) o).getPos().getZ() - mc.getRenderManager().renderPosZ,
							Client.settings.getSettingsByMod(this).get(1).getValue_f(),
							Client.settings.getSettingsByMod(this).get(2).getValue_f(),
							Client.settings.getSettingsByMod(this).get(3).getValue_f(),
							Client.settings.getSettingsByMod(this).get(4).getValue_f(),
							-1);
					
					//System.out.println(((TileEntityMobSpawner) o).getSpawnerBaseLogic().spawnRange);
				}
			}
		}
	}
}
