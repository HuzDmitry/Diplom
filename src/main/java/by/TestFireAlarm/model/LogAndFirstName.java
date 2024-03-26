package by.TestFireAlarm.model;

import java.sql.Timestamp;

public interface LogAndFirstName {
    Integer getId();
    Timestamp getStart();
    Timestamp getEnd();
    String getStatus();
    String getTickets();
    String getAnswers();
    String getFirst_name();
    String getLast_name();
    String getAnswer_origin();
}
