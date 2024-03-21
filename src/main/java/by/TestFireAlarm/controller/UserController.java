package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.Users;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserController {

    @PostMapping("/register")
    String saveUser(@RequestParam String firstName,
            @RequestParam String lastName, @RequestParam String position, Model model);

    @GetMapping()
    String getMain(Model model);

    @GetMapping("/login")
    String login(@RequestParam Integer id, Model model);

    @GetMapping("/all")
    String findAll(Model model);

    @PostMapping("/delete")
    String deleteUserById(@RequestParam Integer id, Model model);
}
