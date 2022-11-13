package KeemaCurry.Event.listener;

import KeemaCurry.Event.Event;

public class EventKey extends Event<EventKey>{
	public int key;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public EventKey(int key) {
		this.key = key;
	}
}
