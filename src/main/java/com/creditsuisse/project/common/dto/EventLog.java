package com.creditsuisse.project.common.dto;

import java.util.Objects;

public class EventLog {

   
	private Event startEvent;
    private Event endEvent;

    private EventLog(Event startEvent, Event endEvent) {
        this.startEvent = startEvent;
        this.endEvent = endEvent;
    }

    public Event getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(Event startEvent) {
		this.startEvent = startEvent;
	}

	public Event getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(Event endEvent) {
		this.endEvent = endEvent;
	}

    public static EventLog newInstance(Event startEvent, Event endEvent) {
        return new EventLog(startEvent, endEvent);
    }

    public Long getDuration() {
        long duration = 0;
        if(Objects.nonNull(startEvent) && Objects.nonNull(endEvent)) {
            duration = endEvent.getTimestamp() - startEvent.getTimestamp();
        }
        return duration;
    }

    public boolean isLongRunningEvent() {
        return !(getDuration() <= 4);
    }

	@Override
	public String toString() {
		return "EventLog [startEvent=" + startEvent + ", endEvent=" + endEvent + "]";
	}
    
    
}
