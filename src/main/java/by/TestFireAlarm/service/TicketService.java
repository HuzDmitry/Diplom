package by.TestFireAlarm.service;

import by.TestFireAlarm.model.TicketIdQuestion;
import by.TestFireAlarm.entity.Ticket;

import java.util.List;

public interface TicketService {

    Ticket findById(Integer id);

    List<TicketIdQuestion> findAll();

    Ticket save(Ticket ticket);

    void deleteTicketById(Integer id);

    String updateTicket(Ticket ticket);

    List<Ticket> getTickets();
}
