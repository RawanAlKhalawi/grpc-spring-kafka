package com.lama.visitormanagementsystem.client;

import com.google.protobuf.Timestamp;
import com.lama.visitormanagementsystem.VisitReason;
import com.lama.visitormanagementsystem.VisitorManagementSystemApplication;
import com.lama.visitormanagementsystem.VisitorRequest;
import com.lama.visitormanagementsystem.VisitorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.grpcmock.springboot.AutoConfigureGrpcMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.net.ssl.SSLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest(classes = VisitorManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureGrpcMock
public class VisitorClient {


    private VisitorServiceGrpc.VisitorServiceBlockingStub visitorServiceBlockingStub;

    @BeforeEach
    public void setup() throws SSLException {
        ManagedChannel channel;

//        File certFile = new File("src/main/resources/server.crt");
//
//        SslContext sslContext = GrpcSslContexts.forClient()
//                .trustManager(certFile)
//                .build();

        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
//                .sslContext(sslContext)
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
                .setHostPosition(com.lama.visitormanagementsystem.HostPosition.ADMIN).build();
                com.lama.visitormanagementsystem.VisitorResponse visitorResponse = this.visitorServiceBlockingStub.checkIn(visitorRequest);
        assertThat(visitorResponse.getVisitResponse().toString()).isEqualTo("ACCEPTED");
    }
}
