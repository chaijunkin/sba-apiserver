package com.axess.smartbankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axess.smartbankapi.config.restapi.ApiSuccessResponse;
import com.axess.smartbankapi.dto.UserRedeemptionHistoryDto;
import com.axess.smartbankapi.exception.RecordExistException;
import com.axess.smartbankapi.exception.RecordNotCreatedException;
import com.axess.smartbankapi.exception.RecordNotFoundException;
import com.axess.smartbankapi.model.RewardsCatalogue;
import com.axess.smartbankapi.model.UserRedeemptionHistory;
import com.axess.smartbankapi.service.RedeemptionHistoryService;

@RestController
@CrossOrigin
@RequestMapping("/history")
public class RedeemptionHistoryController {

	
	@Autowired
	private RedeemptionHistoryService historyService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> saveHistory(@RequestBody UserRedeemptionHistoryDto historyDto) throws RecordNotFoundException, RecordExistException, RecordNotCreatedException {
		
		ApiSuccessResponse response = new ApiSuccessResponse();

		response.setMessage("Successfully added to history. ");
		response.setHttpStatus(String.valueOf(HttpStatus.CREATED));
		response.setHttpStatusCode(201);
		response.setBody(historyService.saveHistory(historyDto));
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK))
				.body(response);


	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() throws RecordNotFoundException {
		
		ApiSuccessResponse response = new ApiSuccessResponse();

		List<UserRedeemptionHistory> urh = this.historyService.getAll();

		response.setMessage("Total history count - " + urh.size());
		response.setHttpStatus(String.valueOf(HttpStatus.FOUND));
		response.setHttpStatusCode(302);
		response.setBody(urh);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.OK))
				.body(response);


	}
	
	
}
