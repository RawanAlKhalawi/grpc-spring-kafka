package com.lama.appointmentsbooking.service;

import com.lama.appointmentsbooking.VisitResponse;
import com.lama.appointmentsbooking.VisitorRequest;
import com.lama.appointmentsbooking.VisitorResponse;
import com.lama.appointmentsbooking.VisitorServiceGrpc;
import com.lama.appointmentsbooking.kafka.KafkaProducer;
import com.lama.appointmentsbooking.model.Visitor;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;


@GrpcService
public class VisitorService extends VisitorServiceGrpc.VisitorServiceImplBase {

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public void checkIn(VisitorRequest request, StreamObserver<VisitorResponse> responseObserver) {

        Timestamp timestamp = new Timestamp(request.getVisitTimeDate().getSeconds());
        timestamp.setNanos(request.getVisitTimeDate().getNanos());

        try {
            Visitor visitor = new Visitor();
            visitor.setFirstName(request.getFirstName());
            visitor.setLastName(request.getLastName());
            visitor.setVisitReason(request.getVisitReason());
            visitor.setVisitTimeDate(timestamp.toLocalDateTime());
            visitor.setMobileNumber(request.getMobileNumber());
            visitor.setHostName(request.getHostPosition());

            VisitorResponse response = VisitorResponse.newBuilder()
                    .setVisitResponse(VisitResponse.ACCEPTED)
                    .build();

            kafkaProducer.sendMessage(visitor);

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(new Exception(VisitResponse.REJECTED.toString()));
        }
    }
}
