package com.axess.smartbankapi.sqs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUsageRecord {
	private String email;
	private Date accessTime;
	private String firstName;
	private String lastName;
	private String urlAccessed;
}