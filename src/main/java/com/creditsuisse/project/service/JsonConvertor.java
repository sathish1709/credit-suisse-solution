package com.creditsuisse.project.service;

import com.creditsuisse.project.common.dto.Event;
import com.creditsuisse.project.exception.EventProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

import static com.creditsuisse.project.common.constants.AppConstants.EVENT_CONVERSION_ERROR_MESSAGE;

@Component
@Slf4j
public class JsonConvertor {

	Logger logger = LoggerFactory.getLogger(JsonConvertor.class);

    private final ObjectMapper objectMapper;

    public JsonConvertor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<Event> convertJsonStringToEvent(String jsonString) {
        try {
            return Optional.of(
                    objectMapper.readValue(jsonString, Event.class));
        } catch (IOException e) {
        	logger.error(EVENT_CONVERSION_ERROR_MESSAGE, jsonString, e);
            throw new EventProcessingException(EVENT_CONVERSION_ERROR_MESSAGE);
        }
    }
}
