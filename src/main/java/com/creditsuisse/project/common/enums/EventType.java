package com.creditsuisse.project.common.enums;


public enum EventType {
	
    APPLICATION_LOG("APPLICATION_LOG"),
    UNKNOWN("UNKNOWN");

    private EventType(String eventType) {
		this.eventType = eventType;
	}

	private final String eventType;

	public String getEventType() {
		return eventType;
	}
    
}
