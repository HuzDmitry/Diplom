package by.TestFireAlarm.repository;

import by.TestFireAlarm.model.LogAndFirstName;
import by.TestFireAlarm.entity.LogsTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsTestRepository extends JpaRepository<LogsTest, Integer> {

    @Query(value = "SELECT l.id, u.first_name, u.last_name, l.status, l.tickets, l.answers, l.answer_origin, l.start, l.end " +
            "FROM logs l join users u ON l.users_id  = u.id WHERE l.users_id = :id ORDER BY l.id",
    nativeQuery = true)
    List<LogAndFirstName> findLogsByUsersId(@Param("id") Integer id);

    @Query(value = "SELECT l.id, u.first_name, u.last_name, l.status, l.tickets, l.answers, l.answer_origin, l.start, l.end " +
            "FROM logs l join users u ON l.users_id  = u.id WHERE l.status = :status ORDER BY l.id",
            nativeQuery = true)
    List<LogAndFirstName>findByStatus(@Param("status") String status);

    @Query(value = "SELECT l.id, u.first_name, u.last_name, l.status, l.tickets, l.answers, l.answer_origin, l.start, l.end " +
            "FROM logs l join users u ON l.users_id  = u.id ORDER BY l.id",
            nativeQuery = true)
    List<LogAndFirstName>findAllByLogsAndUsers();
}
