package com.example.kafkareactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableKafka
@SpringBootApplication
public class KafkaReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaReactiveApplication.class, args);
	}
}
