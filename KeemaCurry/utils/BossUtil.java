package KeemaCurry.utils;

public class BossUtil {

	
	public enum boss{
		Igo("Igo");

		
		private String name;
		
		boss(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
}
