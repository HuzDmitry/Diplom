package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.service.LogsTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class LogsTestControllerImpl implements LogsTestController{

    private final LogsTestService logsTestService;
    @Autowired
    public LogsTestControllerImpl(LogsTestService logsTestService) {
        this.logsTestService = logsTestService;
    }

    @Override
    public String findAll(Model model) {
        List<LogsTest> l = logsTestService.findAll();
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String findById(Integer id, Model model) {
        LogsTest l = logsTestService.fidById(id);
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String findByStatus(byte status, Model model) {
        List<LogsTest> l = logsTestService.findByStatus(status);
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String findByUser(Users users, Model model) {
        List<LogsTest> l = logsTestService.findByUser(users);
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String deleteLog(Integer id, Model model) {
        logsTestService.deleteLogById(id);
        return "redirect:/event-log";
    }

    @Override
    public String saveLog(LogsTest logsTest, Model model) {
        logsTestService.save(logsTest);
        return "redirect:/event-log";
    }
}
