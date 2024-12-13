package ie.spring.adfProject;

import ie.spring.adfProject.services.exceptions.NotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdfProjectApplication {

    public static void main(String[] args) throws NotFoundException {
       SpringApplication.run(AdfProjectApplication.class, args);

    }

}
