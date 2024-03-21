package by.TestFireAlarm.service;


import by.TestFireAlarm.dao.LogAndFirstName;
import by.TestFireAlarm.dao.Status;
import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;

import java.util.List;

public interface LogsTestService {

    LogsTest fidById(Integer id);

    List<LogAndFirstName> findAll();

    List<LogsTest>findByUser(Users users);

    List<LogsTest>findByStatus(Status status);

    void deleteLogById(Integer id);

    LogsTest save(LogsTest logsTest);
}
