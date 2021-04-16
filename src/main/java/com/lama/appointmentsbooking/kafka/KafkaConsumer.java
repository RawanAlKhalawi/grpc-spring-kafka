package com.lama.appointmentsbooking.kafka;

import com.lama.appointmentsbooking.model.Visitor;
import com.lama.appointmentsbooking.repository.VisitorCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    VisitorCassandraRepository visitorCassandraRepository;

    @KafkaListener(topics="appointments_booking_topic",
            groupId="appointments_booking_group_id")
    public void getMessage(Visitor visitor){

            visitorCassandraRepository.save(visitor);
    }
}
