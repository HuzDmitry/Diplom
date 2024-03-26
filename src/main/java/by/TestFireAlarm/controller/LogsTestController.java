package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.LogsTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/event-log")
public interface LogsTestController {

    @GetMapping
    String findAllLogs(Model model);


    @GetMapping("/status")
    String findByStatus(@RequestParam String status, Model model);

    @GetMapping("/userid")
    String findByUserId(@RequestParam Integer id, Model model);

    @PostMapping("/delete")
    String deleteLog(@RequestParam Integer id , Model model);

    @PostMapping("/save")
    String saveLog(@ModelAttribute("logs") LogsTest logsTest, Model model);
}
