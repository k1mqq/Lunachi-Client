package KeemaCurry.Event.listener;

import KeemaCurry.Event.Event;

public class EventChat extends Event<EventChat>{
	public String message;
	public boolean isSendChat;

	public boolean isSendChat() {
		return isSendChat;
	}

	public void setSendChat(boolean isSendChat) {
		this.isSendChat = isSendChat;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EventChat(String message) {
		super();
		this.message = message;
	}
	
}
