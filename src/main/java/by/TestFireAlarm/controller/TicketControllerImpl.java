package by.TestFireAlarm.controller;

import by.TestFireAlarm.dao.TicketIdQuestion;
import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class TicketControllerImpl implements TicketController{

    private final TicketServiceImpl ticketService;
    @Autowired
    public TicketControllerImpl(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String getMainTicket(Model model) {
        model.addAttribute("ticket", new Ticket());
        List<TicketIdQuestion>tickets =  ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets.html";
    }

    public String getTicketById(Integer id, Model model){
        Ticket t = ticketService.findById(id);
        model.addAttribute("ticket", t);
        List<TicketIdQuestion>tickets =  ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets.html";
    }

    public String findAll(Model model){
        List<TicketIdQuestion>tickets =  ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "redirect:/ticket";
    }

    public String saveTicket( Ticket ticket, Model model){
        ticketService.save(ticket);
        return "redirect:/ticket";
    }

    @Override
    public String deleteTicket(Integer id, Model model) {
        ticketService.deleteTicketById(id);
        return "redirect:/ticket";
    }

    public String updateTicket(Ticket ticket, Model model){
        ticketService.updateTicket(ticket);
        return "redirect:/ticket";
    }
}
