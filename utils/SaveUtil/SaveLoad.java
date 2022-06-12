package KeemaCurry.utils.SaveUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import KeemaCurry.Client;
import KeemaCurry.Settings.Setting;
import KeemaCurry.Settings.SettingManager;
import KeemaCurry.modules.Module;
import net.minecraft.client.Minecraft;

public class SaveLoad {
	
	public static File dir;
	private File dateFile;
	
	public SaveLoad() {
		dir = new File(Minecraft.getMinecraft().mcDataDir, "Lunachi-Client");
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		
	}
	
	public void save() {
		ArrayList<String> toSave = new ArrayList<String>();
		
		for(Module m : Client.modules) {
			toSave.clear();
			toSave.add("MOD:" + m.getName() + ":" + m.toggled + ":" + m.x + ":" + m.y);
			if(Client.settings.getSettingsByMod(m) != null) {
				for(Setting set : Client.settings.getSettingsByMod(m)) {
					if(set.mode == "Float" || set.mode == "Int") {
						toSave.add("SET:" + set.getName() + ":" + set.getValue_f());
					}
					if(set.mode == "Boolean") {
						toSave.add("SET:" + set.getName() + ":" + set.isValue_b());
					}
					if(set.mode == "Key") {
						toSave.add("SET:" + set.getName() + ":" + set.value_key);
					}
					if(set.mode == "String") {
						toSave.add("SET:" + set.getName() + ":" + set.getValue_s());
					}
				}
			}
			
			
			dateFile = new File(dir, m.getName() + ".txt");
			if(!dateFile.exists()) {
				try {
					dateFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				PrintWriter pw = new PrintWriter(this.dateFile);
				for(String str : toSave) {
					pw.println(str);
				}
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load() {
		ArrayList<String> lines = new ArrayList<String>();
		
		
		for(Module mod : Client.modules) {
			File file = new File(dir, mod.getName() + ".txt");
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				while(line != null){
					lines.add(line);
					line = reader.readLine();
				}
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			for(String s : lines) {
				String[] args = s.split(":");
				
				if(s.toLowerCase().startsWith("set:")) {
					List<Setting> settings = Client.settings.getSettingsByMod(mod);
					
					if(settings != null) {
						for(Setting set : settings) {
							if(set.getName().equalsIgnoreCase(args[1])){
								if(set.mode == ("Boolean")) {
									set.setValue_b(Boolean.valueOf(args[2]));
								}
								if(set.mode == ("Float") || set.mode == ("int")) {
									set.setValue_f(Float.parseFloat(args[2]));
								}
								if(set.mode == ("Key")) {
									set.setValue_key((int) Float.parseFloat(args[2]));
								}
								if(set.mode == ("String")) {
									set.setValue_s(args[2]);
								}
							}
						}
					}
				}else if(s.toLowerCase().startsWith("mod:")) {
					mod.setToggled(Boolean.parseBoolean(args[2]));
					mod.setX(Integer.parseInt(args[3]));
					mod.setY(Integer.parseInt(args[4]));
				}
			}
		}
	}
}
