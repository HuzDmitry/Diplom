package by.TestFireAlarm.service;

import by.TestFireAlarm.entity.Logins;
import by.TestFireAlarm.repository.LoginRepository;
import by.TestFireAlarm.repository.RoleRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginsService implements UserDetailsService {
    private final LoginRepository loginRepository;
    private final RoleRepository roleRepository;

    public LoginsService(LoginRepository loginRepository, RoleRepository roleRepository) {
        this.loginRepository = loginRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Logins logins = findByName(username).orElseThrow(()->new UsernameNotFoundException("нет такого пользователя"));
        return new User(logins.getName(),
                logins.getPassword(),
                logins.getRolesList().stream().map(roles -> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList()));
    }
    public Optional<Logins> findByName(String name){
        return loginRepository.findByName(name);
    }

    public void createNewUser(Logins logins, Integer id){
        logins.setRolesList(List.of(roleRepository.findById(id).get()));
        loginRepository.save(logins);
    }
}
