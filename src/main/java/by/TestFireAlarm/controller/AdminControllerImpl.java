package by.TestFireAlarm.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public final class AdminControllerImpl implements AdminController{
    @Override
    public String getMain(Model model) {
        return "main.html";
    }
}
