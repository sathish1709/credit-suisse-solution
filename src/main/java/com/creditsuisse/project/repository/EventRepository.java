package com.creditsuisse.project.repository;

import com.creditsuisse.project.common.dto.EventLog;
import com.creditsuisse.project.service.EventFileProcessor;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static com.creditsuisse.project.common.constants.SqlConstants.INSERT_INTO_EVENT;

@Repository
@Slf4j
@Transactional
public class EventRepository implements AutoCloseable{
	
	Logger logger = LoggerFactory.getLogger(EventRepository.class);

    private final Connection connection;
    private PreparedStatement statement;
  
    public EventRepository(final Connection connection) {
        this.connection = connection;
    }

    public Boolean saveEvent(EventLog eventLog) {
        try {
            statement = connection.prepareStatement(INSERT_INTO_EVENT);
            statement.setString(1, eventLog.getEndEvent().getId());
            statement.setLong(2, eventLog.getDuration());
            statement.setString(3, Objects.nonNull(eventLog.getEndEvent().getType()) ?
                    eventLog.getStartEvent().getType().getEventType(): null);
            statement.setString(4, eventLog.getEndEvent().getHost());
            statement.setBoolean(5, eventLog.isLongRunningEvent());
            return statement.executeUpdate() > 0;
        } catch (Exception e) {
        	logger.error("Failure saving event, skipping",  e);
            return false;
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
        	logger.error("Failure closing database connection",  e);
        }
    }

}
