package com.creditsuisse.project.common.dto;

import com.creditsuisse.project.common.enums.EventState;
import com.creditsuisse.project.common.enums.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;


@ToString
public class Event {

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EventState getState() {
		return state;
	}

	public void setState(EventState state) {
		this.state = state;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	private String id;
    private EventState state;
    private long timestamp;

    @JsonIgnoreProperties
    private EventType type;

    @JsonIgnoreProperties
    private String host;
}
