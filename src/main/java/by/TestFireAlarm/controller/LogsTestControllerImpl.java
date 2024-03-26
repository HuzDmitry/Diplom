package by.TestFireAlarm.controller;

import by.TestFireAlarm.model.LogAndFirstName;
import by.TestFireAlarm.entity.LogsTest;
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
    public String findAllLogs(Model model) {
        List<LogAndFirstName> l = logsTestService.findAll();
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String findByStatus(String status, Model model) {
        List<LogAndFirstName> l = logsTestService.findByStatus(status);
        model.addAttribute("logs", l);
        return "event.html";
    }

    @Override
    public String findByUserId(Integer id, Model model) {
        List<LogAndFirstName> l = logsTestService.findByUserId(id);
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
