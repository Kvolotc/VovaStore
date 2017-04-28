package store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "Store")

public class Run {

	public static void main(String[] args) {
		
		SpringApplication.run(Run.class, args);

	}

}
