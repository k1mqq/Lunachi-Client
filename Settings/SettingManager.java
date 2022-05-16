package KeemaCurry.Settings;

import java.util.ArrayList;

import KeemaCurry.Client;
import KeemaCurry.modules.Module;

public class SettingManager {
private ArrayList<Setting> settings;
	
	public SettingManager(){
		this.settings = new ArrayList<>();
	}
	
	public void rSetting(Setting in){
		this.settings.add(in);
	}
	
	public ArrayList<Setting> getSettings(){
		return this.settings;
	}
	
	public ArrayList<Setting> getSettingsByMod(Module mod){
		ArrayList<Setting> out = new ArrayList<>();
		for(Setting s : getSettings()){
			if(s.getModule().equals(mod)){
				out.add(s);
			}
		}
		if(out.isEmpty()){
			return null;
		}
		return out;
	}
	
	public Setting getSettingByName(String name){
		for(Setting set : getSettings()){
			if(set.getName().equalsIgnoreCase(name)){
				return set;
			}
		}
		System.err.println("["+ Client.name + "] Error Setting NOT found: '" + name +"'!");
		return null;
	}

}
