package com.lama.visitormanagementsystem.client;

import com.google.protobuf.Timestamp;
import com.lama.visitormanagementsystem.HostPosition;
import com.lama.visitormanagementsystem.VisitReason;
import com.lama.visitormanagementsystem.VisitorRequest;
import com.lama.visitormanagementsystem.VisitorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VisitorClient {

    private ManagedChannel channel;

    private VisitorServiceGrpc.VisitorServiceBlockingStub visitorServiceBlockingStub;

    @BeforeAll
    public void setup() {

        this.channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        this.visitorServiceBlockingStub = VisitorServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void visitorService() {
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(1616392869870L)
                .setNanos(10).build();
        VisitorRequest visitorRequest = VisitorRequest.newBuilder()
                .setFirstName("Lama")
                .setLastName("Alosaimi")
                .setVisitTimeDate(timestamp)
                .setMobileNumber("055555555")
                .setVisitReason(VisitReason.JOB_INTERVIEW)
                .setHostPosition(HostPosition.ADMIN).build();
        this.visitorServiceBlockingStub.checkIn(visitorRequest);

    }
}
