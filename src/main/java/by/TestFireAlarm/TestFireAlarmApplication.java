package by.TestFireAlarm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TestFireAlarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFireAlarmApplication.class, args);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String result = encoder.encode("300");
//		System.out.println(result);
	}

}
