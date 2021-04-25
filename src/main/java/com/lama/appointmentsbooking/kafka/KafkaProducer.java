package com.lama.appointmentsbooking.kafka;

import com.lama.appointmentsbooking.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC= "appointments_booking_topic";

    @Autowired
    KafkaTemplate<String, Visitor> kafkaTemplate;

    public void sendMessage(Visitor visitor){
        kafkaTemplate.send(TOPIC,"testkey", visitor);
    }

}
