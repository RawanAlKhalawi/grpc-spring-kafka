package com.lama.visitormanagementsystem.service;

import com.lama.visitormanagementsystem.Repository.VisitorRepository;
import com.lama.visitormanagementsystem.VisitResponse;
import com.lama.visitormanagementsystem.VisitorRequest;
import com.lama.visitormanagementsystem.VisitorResponse;
import com.lama.visitormanagementsystem.VisitorServiceGrpc;
import com.lama.visitormanagementsystem.model.Visitor;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;


@GrpcService
public class VisitorServiceImpl extends VisitorServiceGrpc.VisitorServiceImplBase {

    @Autowired
    VisitorRepository visitorRepository;

    @Override
    public void checkIn(VisitorRequest request, StreamObserver<VisitorResponse> responseObserver) {

        Timestamp timestamp = new Timestamp(request.getVisitTimeDate().getSeconds());
        timestamp.setNanos(request.getVisitTimeDate().getNanos());

        try {
            Visitor visitor = new Visitor();
            visitor.setFirstName(request.getFirstName());
            visitor.setLastName(request.getLastName());
            visitor.setVisitReason(request.getVisitReason());
            visitor.setVisitTimeDate(timestamp);
            visitor.setMobileNumber(request.getMobileNumber());
            visitor.setHostName(request.getHostPosition());

            VisitorResponse response = VisitorResponse.newBuilder()
                    .setVisitResponse(VisitResponse.ACCEPTED)
                    .build();

            visitorRepository.save(visitor);
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e) {
            responseObserver.onError(new Exception(VisitResponse.REJECTED.toString()));
        }
    }
}
