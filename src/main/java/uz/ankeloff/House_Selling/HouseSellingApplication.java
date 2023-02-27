package uz.ankeloff.House_Selling;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//@SpringBootConfiguration
@SpringBootApplication
//@EnableScheduling
public class HouseSellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseSellingApplication.class, args);
	}

}
