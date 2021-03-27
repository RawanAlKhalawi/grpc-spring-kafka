package com.lama.visitormanagementsystem.client;

import com.google.protobuf.Timestamp;
import com.lama.visitormanagementsystem.*;
import io.grpc.ManagedChannel;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import org.grpcmock.springboot.AutoConfigureGrpcMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.net.ssl.SSLException;
import java.io.File;

@SpringJUnitConfig
@SpringBootTest(classes = VisitorManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureGrpcMock
public class VisitorClient {

    private ManagedChannel channel;

    private VisitorServiceGrpc.VisitorServiceBlockingStub visitorServiceBlockingStub;

    @BeforeEach
    public void setup() throws SSLException {

        File certFile = new File("src/main/resources/server.crt");

        SslContext sslContext = GrpcSslContexts.forClient()
                .trustManager(certFile)
                .build();

        this.channel = NettyChannelBuilder.forAddress("localhost", 9090)
                .sslContext(sslContext)
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
