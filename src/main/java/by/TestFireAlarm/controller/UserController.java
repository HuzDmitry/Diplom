package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.entity.Users;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/user")
public interface UserController {

    @PostMapping("/register")
    String saveUser(@RequestParam String firstName,
            @RequestParam String lastName, @RequestParam String position, Model model);

    @GetMapping()
    String getMain(Model model);

    @GetMapping("/login")
    String login(@RequestParam Integer id, Model model);

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    String findAll(Model model);

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete")
    String deleteUserById(@RequestParam Integer id, Model model);

    @GetMapping("/test")
    String getTicketByTest(@RequestParam Integer id, Model model);

    @PostMapping("/end")
    String endTest(@RequestParam String[] numbers, @RequestParam Integer id, @RequestParam Integer logId, Model model);
}
