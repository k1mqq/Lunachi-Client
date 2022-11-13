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

public class LowFire extends Module{

	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("FireHeight", this, 0 ,0 , 10, false));
		super.setup();
	}
	
	public LowFire() {
		super("LowFire",Category.RENDER);
	}
	
	
}
