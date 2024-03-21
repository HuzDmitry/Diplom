package by.TestFireAlarm.service;

import by.TestFireAlarm.entity.Users;

import java.util.List;

public interface UserService {

    boolean save(Users users);

    Users getUserByName(String firstName, String lastName, String position);

    void deleteById(Integer id);

    List<Users> findAll();

    Users getById(Integer id);
}
