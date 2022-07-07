package com.axess.smartbankapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axess.smartbankapi.config.restapi.ApiSuccessResponse;
import com.axess.smartbankapi.exception.RecordNotFoundException;
import com.axess.smartbankapi.model.RewardsCatalogue;
import com.axess.smartbankapi.service.RewardCatalogueService;
import com.axess.smartbankapi.sqs.AppUsageRecord;
import com.axess.smartbankapi.sqs.SQSService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/catalogue")
@CrossOrigin
@Slf4j
public class RewardsCatalogueController {
	
	@Autowired
	private RewardCatalogueService rcService;
	@Autowired
	private SQSService sqsService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll() throws RecordNotFoundException {
		
		log.info("Request for catalogue received");
		ApiSuccessResponse response = new ApiSuccessResponse();

		List<RewardsCatalogue> rc = this.rcService.getAll();

		response.setMessage("Total catalogue count - " + rc.size());
		response.setHttpStatus(String.valueOf(HttpStatus.FOUND));
		response.setHttpStatusCode(302);
		response.setBody(rc);
		response.setError(false);
		response.setSuccess(true);
		AppUsageRecord record = new AppUsageRecord("user@email", new Date(), "FirstName",
				"LastName", "/catalogue");
		sqsService.sendAppUsageRecordMessage(record);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK))
				.body(response);


	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) throws RecordNotFoundException {
		
		log.info("Request for catalogue having id received: "+id);
		ApiSuccessResponse response = new ApiSuccessResponse();

		RewardsCatalogue rc = this.rcService.getById(id);

		response.setMessage("Successfully Found. ");
		response.setHttpStatus(String.valueOf(HttpStatus.FOUND));
		response.setHttpStatusCode(302);
		response.setBody(rc);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK))
				.body(response);


	}


}
