package sparrow.garcia.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DomainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DomainApplication.class, args);

    }
}
