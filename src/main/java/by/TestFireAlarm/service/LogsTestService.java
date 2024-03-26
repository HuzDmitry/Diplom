package by.TestFireAlarm.service;


import by.TestFireAlarm.model.LogAndFirstName;
import by.TestFireAlarm.entity.LogsTest;
import java.util.List;

public interface LogsTestService {

    LogsTest findById(Integer id);

    List<LogAndFirstName> findAll();

    List<LogAndFirstName>findByUserId(Integer id);

    List<LogAndFirstName>findByStatus(String status);

    void deleteLogById(Integer id);

    LogsTest save(LogsTest logsTest);

}
