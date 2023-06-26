package KeemaCurry.modules.mod;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.modules.Category;
import KeemaCurry.modules.Module;

public class Offhand extends Module {
	public Offhand() {
		super("Offhand",Category.CLIENT);
	}
	
	@Override
	public void setup() {
		Client.settings.rSetting(new Setting("NoUse", this, true));
		Client.settings.rSetting(new Setting("NoRender",this,false));
		super.setup();
	}
}
