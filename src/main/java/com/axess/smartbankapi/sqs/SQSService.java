package com.axess.smartbankapi.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Profile("SQS")
public class SQSService {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Value("${cloud.aws.end-point.uri-usage}")
    private String endpointUsage;

    public void sendMessage(String message) {
        log.info("Sending Message to SQS: "+message);
        queueMessagingTemplate.convertAndSend(endpoint, new TestMessage(message));
        log.info("Message sent to SQS: "+message);
    }
    @Async
    public void sendAppUsageRecordMessage(AppUsageRecord message) {
        log.info("Sending Message to SQS: "+message.getEmail());
        queueMessagingTemplate.convertAndSend(endpointUsage, message);
        log.info("Message sent to SQS: "+message.getUrlAccessed());
    }
}