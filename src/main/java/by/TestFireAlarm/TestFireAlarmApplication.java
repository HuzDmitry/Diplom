package by.TestFireAlarm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API TestFireAlarm", version = "1.0"))
public class TestFireAlarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestFireAlarmApplication.class, args);
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String result = encoder.encode("300");
		//System.out.println(result);
	}

}
