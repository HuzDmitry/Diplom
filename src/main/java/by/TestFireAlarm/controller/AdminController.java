package by.TestFireAlarm.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public interface AdminController {
    @GetMapping
    String getMain(Model model);

}
