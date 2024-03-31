package by.TestFireAlarm.service;

import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.entity.Users;
import java.util.List;

public interface UserService {

    Users save(Users users);

    void deleteById(Integer id);

    List<Users> findAll();

    Users getById(Integer id);

    List<Ticket>getTicketsByUsers();

    Integer setLogsByStartTest(List<Ticket> tickets, Users user);

    int getResulToTest(String[] numbers, Integer logId);
}
