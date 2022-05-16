package KeemaCurry.modules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import KeemaCurry.Client;
import KeemaCurry.Event.Event;
import KeemaCurry.Settings.Setting;
import net.minecraft.client.Minecraft;

public class Module {

	public String name;
	public Category c;
	
	public int x;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int y;
	
	public int width;
	public int height;
	
	public Category getCategory() {
		return c;
	}

	public void setCategory(Category c) {
		this.c = c;
	}

	public boolean toggled;
	
	public Minecraft mc = Client.mc;
	
	public List<Setting> setting = new ArrayList<Setting>();
	
	public Module(String name,Category c) {
		this.name = name;
		this.c = c;
		this.setup();
	}
	
	public void setup() {
	}
	
	public void addSettings(Setting... settings) {
		this.setting.addAll(Arrays.asList(settings));
	}

	public boolean isEnabled() {
		return toggled;
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		}else {
			onDisable();
		}
	}
	
	public void onEnable() {
		Client.addChatMessage(this.name + "‚ª—LŒø‚É‚È‚è‚Ü‚µ‚½");
	}
	public void onDisable() {
		Client.addChatMessage(this.name + "‚ª–³Œø‚É‚È‚è‚Ü‚µ‚½");
	}
	public void onEvent(Event e) {}
	public void onRender() {}

	public String getName() {
		return this.name;
	}

	public void setToggled(boolean parseBoolean) {
		this.toggled= parseBoolean;
	}
}
