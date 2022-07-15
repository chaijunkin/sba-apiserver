package com.axess.smartbankapi.ses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

  String from;

  String to;

  String subject;

  String body;
}