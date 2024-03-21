package by.TestFireAlarm.controller;

import by.TestFireAlarm.dao.Status;
import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/event-log")
public interface LogsTestController {

    @GetMapping
    String findAllLogs(Model model);

    @GetMapping("/id")
    String findById(@RequestParam Integer id, Model model);

    @GetMapping("/status")
    String findByStatus(@RequestParam Status status, Model model);

    @GetMapping("/userid")
    String findByUser(@ModelAttribute Users users, Model model);

    @PostMapping("/delete")
    String deleteLog(@RequestParam Integer id , Model model);

    @PostMapping("/save")
    String saveLog(@ModelAttribute("logs") LogsTest logsTest, Model model);
}
