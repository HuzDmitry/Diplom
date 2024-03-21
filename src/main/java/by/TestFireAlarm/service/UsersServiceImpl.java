package by.TestFireAlarm.service;

import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public boolean save(Users users){
        if (users == null)
            return false;
        else {
            usersRepository.save(users);
            return true;
        }
     }

     @Override
    public Users getUserByName(String name, String lastName, String position){
        return usersRepository.findByFirstNameAndLastNameAndPosition(name, lastName, position).orElseThrow(()->new UsernameNotFoundException("No user"));
     }

    @Override
    public void deleteById(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users getById(Integer id) {
        return usersRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("No users"));
    }
}
