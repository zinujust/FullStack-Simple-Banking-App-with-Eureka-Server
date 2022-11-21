package app.zainal.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DollarBankCheckingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarBankCheckingApplication.class, args);
	}

}
