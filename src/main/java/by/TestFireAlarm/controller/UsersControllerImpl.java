package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersControllerImpl implements UserController{

    private final UsersServiceImpl usersService;

    @Autowired
    public UsersControllerImpl(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    public String saveUser(String firstName, String lastName, String position, Model model){
        Users users = new Users(firstName, lastName, position);
        boolean res = usersService.save(users);
        users = usersService.getUserByName(firstName, lastName, position);
        model.addAttribute("users", users);
        return "login.html";
    }
    //"redirect:/home";
    public String getMain(Model model){
        return "index.html";
    }

    public String login(Integer id, Model model){
        Users l = usersService.getById(id);
        model.addAttribute("users", l);
        return "login.html";
    }

    @Override
    public String findAll(Model model) {
        List<Users> l = usersService.findAll();
        model.addAttribute("users", l);
        return "users.html";
    }

    @Override
    public String deleteUserById(Integer id, Model model) {
        usersService.deleteById(id);
        return "redirect:/user/all";
    }
}
