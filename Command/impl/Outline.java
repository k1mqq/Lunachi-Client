package KeemaCurry.Command.impl;

import KeemaCurry.Client;
import KeemaCurry.Command.Command;
import KeemaCurry.modules.Module;

public class Outline extends Command{

	public Outline() {
		super("Outline", "機能の有効、無効の切り替え", "outline <red> <green> <blue> <alpha>", "o");
	}
	
	public int red = 0;
	public int green = 0;
	public int blue = 0;
	public float alpha = 0;
	@Override
	public void onCommand(String[] args, String command) {
		if(args.length == 4) {
			red = Integer.parseInt(args[0]);
			green = Integer.parseInt(args[1]);
			blue = Integer.parseInt(args[2]);
			alpha = Float.parseFloat(args[3]);
			
		}
	}

}
