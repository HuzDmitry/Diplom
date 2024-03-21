package by.TestFireAlarm.service;

import by.TestFireAlarm.dao.TicketIdQuestion;
import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket findById(Integer id){
        return ticketRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("No ticket an id"));
    }

    @Override
    public List<TicketIdQuestion> findAll(){
        return ticketRepository.findAllTicket();
    }

    @Override
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicketById(Integer id){
        ticketRepository.deleteById(id);
    }

    @Override
    public String updateTicket(Ticket ticket){
        if (ticket == null)
            return "no ticket";
        Integer id = ticket.getId();
        Ticket t = ticketRepository.findById(id).orElseThrow();
        t.setId(ticket.getId());
        t.setQuestion(ticket.getQuestion());
        t.setAnswer1(ticket.getAnswer1());
        t.setAnswer2(ticket.getAnswer2());
        t.setAnswer3(ticket.getAnswer3());
        t.setAnswer4(ticket.getAnswer4());
        t.setAnswerOrigin(ticket.getAnswerOrigin());
        return "ok";
    }
}
