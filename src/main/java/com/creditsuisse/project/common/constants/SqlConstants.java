package com.creditsuisse.project.common.constants;

public class SqlConstants {
	private SqlConstants() {
		
	}
    // SQL Constants
    public static final String CREATE_TABLE_STATEMENT = "CREATE TABLE IF NOT EXISTS event (id VARCHAR(20)," +
            " duration INTEGER, type VARCHAR(50), host VARCHAR(50), alert BOOLEAN)";
    public final static String INSERT_INTO_EVENT = "INSERT INTO event (id, duration, type, host, alert)  VALUES (?, ?, ?, ?, ?)";

}
