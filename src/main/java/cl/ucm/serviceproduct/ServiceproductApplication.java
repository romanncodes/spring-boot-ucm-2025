package cl.ucm.serviceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ServiceproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceproductApplication.class, args);
	}

}
