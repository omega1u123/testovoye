package org.example.testovoye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestovoyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestovoyeApplication.class, args);
    }

}
