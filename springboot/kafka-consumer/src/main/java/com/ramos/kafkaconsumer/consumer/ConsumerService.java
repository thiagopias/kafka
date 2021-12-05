package com.ramos.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "cities", groupId = "cities_groupid")
    public void consume(String message){
        System.out.println("Consuming message: "+message);
    }

}
