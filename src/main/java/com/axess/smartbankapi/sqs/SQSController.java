package com.axess.smartbankapi.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Profile("SQS")
public class SQSController {

	@Autowired
	SQSService sqsService;

	@GetMapping(value = "/queue")
	public String sendMesssage(@RequestParam("message") String message) {
		log.info("Message to be queued: " + message);
		sqsService.sendMessage(message);
		log.info("Message queued: " + message);
		return "Message successfully sent";
	}
}
