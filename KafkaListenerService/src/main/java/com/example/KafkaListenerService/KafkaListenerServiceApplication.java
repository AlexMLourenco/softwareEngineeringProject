package com.example.KafkaListenerService;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan
public class KafkaListenerServiceApplication {

    public static void main(String[] args) {
            SpringApplication.run(KafkaListenerServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
    }
}
