package by.TestFireAlarm.service;


import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;

import java.util.List;

public interface LogsTestService {

    LogsTest fidById(Integer id);

    List<LogsTest> findAll();

    List<LogsTest>findByUser(Users users);

    List<LogsTest>findByStatus(byte status);

    void deleteLogById(Integer id);

    LogsTest save(LogsTest logsTest);
}
