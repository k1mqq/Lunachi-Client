package KeemaCurry.modules;

public enum Category {
	HUD("HUD"),
	RENDER("Render"),
	CLIENT("Client");
	String name;
	Category(String string) {
		this.name = string;
	}
}
