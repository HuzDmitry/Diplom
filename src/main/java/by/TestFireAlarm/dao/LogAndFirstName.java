package by.TestFireAlarm.dao;

import java.sql.Timestamp;

public interface LogAndFirstName {
    Integer getId();
    Timestamp getStart();
    Timestamp getEnd();
    Status getStatus();
    String getTickets();
    String getAnswers();
    String getFirst_name();
    String getLast_name();
}
