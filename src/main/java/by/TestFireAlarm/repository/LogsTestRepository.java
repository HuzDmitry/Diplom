package by.TestFireAlarm.repository;

import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsTestRepository extends JpaRepository<LogsTest, Integer> {

    List<LogsTest>findByUsers(Users users);

    List<LogsTest>findByStatus(byte status);
}
