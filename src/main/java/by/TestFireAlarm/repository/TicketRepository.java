package by.TestFireAlarm.repository;

import by.TestFireAlarm.dao.TicketIdQuestion;
import by.TestFireAlarm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByIdIn(List<Integer>id);

    @Query(value = "SELECT t.id, t.question FROM tickets t",
            nativeQuery = true)
    List<TicketIdQuestion> findAllTicket();
}
