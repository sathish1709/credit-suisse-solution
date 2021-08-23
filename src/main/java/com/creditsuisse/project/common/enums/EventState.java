package com.creditsuisse.project.common.enums;

public enum EventState {
    STARTED("STARTED"),
    FINISHED("FINISHED");

	private final String eventState;
	
    public String getEventState() {
		return eventState;
	}

	private EventState(String eventState) {
		this.eventState = eventState;
	}

	
}
