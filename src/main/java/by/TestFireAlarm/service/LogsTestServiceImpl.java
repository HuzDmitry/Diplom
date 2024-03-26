package by.TestFireAlarm.service;

import by.TestFireAlarm.model.LogAndFirstName;
import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.repository.LogsTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsTestServiceImpl implements LogsTestService{

    private final LogsTestRepository logsTestRepository;
    @Autowired
    public LogsTestServiceImpl(LogsTestRepository logsTestRepository) {
        this.logsTestRepository = logsTestRepository;
    }


    @Override
    public List<LogAndFirstName> findAll() {
        return logsTestRepository.findAllByLogsAndUsers();
    }

    @Override
    public List<LogAndFirstName> findByUserId(Integer id) {
        return logsTestRepository.findLogsByUsersId(id);
    }

    @Override
    public List<LogAndFirstName> findByStatus(String status) {
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

    @Override
    public LogsTest findById(Integer id) {
        return logsTestRepository.findById(id).orElseThrow();
    }
}
