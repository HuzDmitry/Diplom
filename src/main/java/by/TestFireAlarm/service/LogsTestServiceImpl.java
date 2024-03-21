package by.TestFireAlarm.service;

import by.TestFireAlarm.dao.LogAndFirstName;
import by.TestFireAlarm.dao.Status;
import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.repository.LogsTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogsTestServiceImpl implements LogsTestService{

    private final LogsTestRepository logsTestRepository;
    @Autowired
    public LogsTestServiceImpl(LogsTestRepository logsTestRepository) {
        this.logsTestRepository = logsTestRepository;
    }

    @Override
    public LogsTest fidById(Integer id) {
        Optional<LogsTest> l = logsTestRepository.findById(id);
        if (!l.isEmpty())
            return new LogsTest();
        return l.get();
    }

    @Override
    public List<LogAndFirstName> findAll() {
        return logsTestRepository.findAllByLogsAndUsers();
    }

    @Override
    public List<LogsTest> findByUser(Users users) {
        return logsTestRepository.findByUsers(users);
    }

    @Override
    public List<LogsTest> findByStatus(Status status) {
        return logsTestRepository.findByStatus(status);
    }

    @Override
    public void deleteLogById(Integer id) {
        logsTestRepository.deleteById(id);
    }

    @Override
    public LogsTest save(LogsTest logsTest) {
        return logsTestRepository.save(logsTest);
    }
}
