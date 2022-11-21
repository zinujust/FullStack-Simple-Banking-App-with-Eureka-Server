package app.zainal.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DollarBankEurekaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarBankEurekaGatewayApplication.class, args);
	}

}
