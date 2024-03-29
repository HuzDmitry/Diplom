package by.TestFireAlarm.service;

import by.TestFireAlarm.entity.LogsTest;
import by.TestFireAlarm.entity.Ticket;
import by.TestFireAlarm.entity.Users;
import by.TestFireAlarm.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final LogsTestService logsTestService;
    private final TicketService ticketService;
    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, LogsTestService logsTestService, TicketService ticketService) {
        this.usersRepository = usersRepository;
        this.logsTestService = logsTestService;
        this.ticketService = ticketService;
    }

    @Override
    public Users save(Users users){
            return usersRepository.save(users);
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
    public Users getById(Integer id) throws UsernameNotFoundException{
        return usersRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("No users"));
    }

    @Override
    public List<Ticket> getTicketsByUsers() {
        return ticketService.getTickets();
    }

    @Override
    public Integer setLogsByStartTest(List<Ticket> ticketList, Users user) {
        String tickets =ticketList.stream()
                .map(Ticket::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        String answer = ticketList.stream()
                .map(Ticket::getAnswerOrigin)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        LogsTest test = new LogsTest();
        test.setUsers(user);
        test.setTickets(tickets);
        test.setAnswerOrigin(answer);
        test.setTestStart(new Timestamp(new Date().getTime()));
        test = logsTestService.save(test);
        Integer logId = test.getId();
        return logId;
    }

    @Override
    public int getResulToTest(String[] numbers, Integer logId) {
        LogsTest test = logsTestService.findById(logId);
        String answerOrigin = test.getAnswerOrigin();
        String answer = String.join(",", numbers);
        int result = 0;
        for (int i = 0; i < answer.length(); i++){
            if (answerOrigin.charAt(i) != answer.charAt(i))
                ++result;
        }
        Timestamp start = test.getTestStart();
        test.setTestStart(start);
        test.setTestEnd(new Timestamp(new Date().getTime()));
        if (result <= 1)
            {test.setStatus("OK");}
        else
            {test.setStatus("BAD");}
        test.setAnswers(answer);
        logsTestService.save(test);
        return result;
    }
}
