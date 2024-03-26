package by.TestFireAlarm.repository;

import by.TestFireAlarm.model.TicketIdQuestion;
import by.TestFireAlarm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByIdIn(Set<Integer> id);

    @Query(value = "SELECT t.id, t.question FROM tickets t",
            nativeQuery = true)
    List<TicketIdQuestion> findAllTicket();
}
