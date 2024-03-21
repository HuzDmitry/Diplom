package by.TestFireAlarm.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;

@Controller
public class AdminControllerImpl implements AdminController{
    @Override
    public String getMain(Model model) {
        return "main.html";
    }
}
