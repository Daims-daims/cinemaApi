package chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "chat")
@EnableJpaRepositories
public class cinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(cinemaApplication.class, args);
	}


}
