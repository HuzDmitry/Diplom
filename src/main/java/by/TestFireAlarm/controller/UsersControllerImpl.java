package by.TestFireAlarm.controller;

import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;


@Controller
public class UsersControllerImpl implements UserController{

    private final UserService usersService;

    @Autowired
    public UsersControllerImpl(UserService usersService) {
        this.usersService = usersService;
    }

    public String saveUser(String firstName, String lastName, String position, Model model){
        Users users = new Users(firstName, lastName, position);
        users = usersService.save(users);
        model.addAttribute("users", users);
        return "login.html";
    }
    //"redirect:/home";
    public String getMain(Model model){
        return "index.html";
    }

    public String login(Integer id, Model model){
        try {
            Users user = usersService.getById(id);
            model.addAttribute("users", usersService.getById(id));
            return "login.html";
        }catch (UsernameNotFoundException e){
            return "redirect:/user";
        }
    }

    @Override
    public String findAll(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "users.html";
    }

    @Override
    public String deleteUserById(Integer id, Model model) {
        usersService.deleteById(id);
        return "redirect:/user/all";
    }

    @Override
    public String getTicketByTest(Integer id, Model model) {
        List<Ticket> ticketList = usersService.getTicketsByUsers();
        Users users = usersService.getById(id);
        Integer logId = usersService.setLogsByStartTest(ticketList, users);
        model.addAttribute("list", ticketList);
        model.addAttribute("users", users);
        model.addAttribute("logId", logId);
        model.addAttribute("id", id);
        return "test.html";
    }

    @Override
    public String endTest(String[] numbers, Integer id, Integer logId, Model model) {
        Integer result = usersService.getResulToTest(numbers, logId);
        if (result <= 1)
            model.addAttribute("result","Вы прошли тест!");
        else
            model.addAttribute("result", "Тест не пройден.");
        model.addAttribute("bad", result);
        model.addAttribute("id", id);
        return "endTest.html";
    }
}
