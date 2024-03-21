package by.TestFireAlarm.repository;

import by.TestFireAlarm.dao.LogAndFirstName;
import by.TestFireAlarm.dao.Status;
import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsTestRepository extends JpaRepository<LogsTest, Integer> {

    List<LogsTest>findByUsers(Users users);

    List<LogsTest>findByStatus(Status status);

    @Query(value = "SELECT l.id, u.first_name, u.last_name, l.status, l.tickets, l.answers, l.start, l.end " +
            "FROM logs l join users u ON l.users_id  = u.id",
            nativeQuery = true)
    List<LogAndFirstName>findAllByLogsAndUsers();
}
