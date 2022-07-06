package com.axess.smartbankapi.sqs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("SQS")
public class Consumer {

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;
    
    @SqsListener(value = "${cloud.aws.end-point.uri}",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(TestMessage message) {
        log.info("Message from SQS {}", message.getMessage());
    }
}