package KeemaCurry.Settings;

import KeemaCurry.Client;
import KeemaCurry.modules.Module;

public class Setting {
	public String name;
	public Module module;
	
	public float max;
	public float min;
	public float value_f;
	
	public float getValue_f() {
		return value_f;
	}

	public void setValue_f(float value_f) {
		this.value_f = value_f;
	}

	public String value_s;
	public boolean value_b;
	public int value_key;
	
	public String mode;
	
	public Setting(String name, Module module, float value,float min, float max, boolean isInt) {
		this.name = name;
		this.module = module;
		this.max = max;
		this.min = min;
		this.value_f = value;
		if(isInt)
			mode = "Int";
		else
			mode = "Float";
	}
	
	public Setting(String name, Module module, String s) {
		this.name = name;
		this.module = module;
		this.value_s = s;
		
		mode = "String";
	}
	
	public Setting(String name, Module module, boolean b) {
		this.name = name;
		this.module = module;
		this.value_b = b;
		
		mode = "Boolean";
	}
	
	public Setting(String name, Module module, int key) {
		this.name = name;
		this.module = module;
		this.value_key = key;
		
		mode = "Key";
	}

	public int getValue_key() {
		return value_key;
	}

	public void setValue_key(int value_key) {
		this.value_key = value_key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public String getValue_s() {
		return value_s;
	}

	public void setValue_s(String value_s) {
		this.value_s = value_s;
	}

	public boolean isValue_b() {
		return value_b;
	}

	public void setValue_b(boolean value_b) {
		this.value_b = value_b;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
