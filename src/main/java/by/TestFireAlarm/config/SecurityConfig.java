package by.TestFireAlarm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig  {
    @Value("${spring.security.debug}")
    boolean securityDebug;

    private final UserDetailsService loginsService;

    public SecurityConfig(UserDetailsService loginsService) {
        this.loginsService = loginsService;
    }


    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/").permitAll()
                               .requestMatchers("/admin/**", "/event-log/**", "/ticket/**").hasRole("ADMIN")
                               .requestMatchers("/user/**").hasRole("USER")
                                .anyRequest().authenticated()
                                )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                      httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setPasswordEncoder(passwordEncoder());
        dao.setUserDetailsService(loginsService);
        ProviderManager pro = new ProviderManager(dao);
        pro.setEraseCredentialsAfterAuthentication(false);
        return pro;
    }

//    @Bean
//    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(bCryptPasswordEncoder.encode("300"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("user")
//                .password(bCryptPasswordEncoder.encode("100"))
//                .roles("USER")
//                .build();
//        if (manager.userExists(user.getUsername())){
//            manager.deleteUser(user.getUsername());
//        }
//        if (manager.userExists(admin.getUsername())){
//            manager.deleteUser(admin.getUsername());
//        }
//        manager.createUser(admin);
//        manager.createUser(user);
//
//        return manager;
//    }
}
