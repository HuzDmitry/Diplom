package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.Ticket;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/ticket")
public interface TicketController {
    @GetMapping
    String getMainTicket(Model model);

    @GetMapping("/view")
    String getTicketById(@RequestParam Integer id, Model model);

    @GetMapping("/all")
    String findAll(Model model);

    @PostMapping("/save")
    String saveTicket(@ModelAttribute("ticket") Ticket ticket, Model model);

    @PostMapping("/update")
    String updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model);

    @GetMapping("/del")
    String deleteTicket(@RequestParam Integer id, Model model);


}
