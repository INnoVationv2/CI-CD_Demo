package edu.ecnu.smart.agriculture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@RestController
public class SmartAgricultureApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartAgricultureApplication.class, args);
    }

}
