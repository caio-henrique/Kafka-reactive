package com.example.kafkareactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test", containerFactory = "kafkaListenerContainerFactory")
    public void listener(String message, Acknowledgment ack) {

        logger.info("Iniciando processo consumidor...");

        Mono<String> kafkaFlux = Mono.just(message).subscribeOn(Schedulers.elastic());
        kafkaFlux.subscribe(data -> logger.info(data),
                error -> logger.error("Error", error),
                () -> ack.acknowledge());

        logger.info("Finalizando processo consumidor...");
    }
}
