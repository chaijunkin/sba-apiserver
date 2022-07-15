package com.axess.smartbankapi.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.axess.smartbankapi.model.CCUser;
import com.axess.smartbankapi.ses.Email;

@Service
public class EmailService {

	@Value("${default.from.email.address}")
	private String from;
	@Value("${default.to.email.address}")
	private String to;
	
	@Autowired
	private MailSender mailSender;

	@Async
	public void sendCheckoutEmail(CCUser user) {
		sendEmail(new Email(from,to,"Congrats! Your voucher is redeemed.","Congratulations, your coupon voucher is successfully redeemed!"));
	}

	@Async
	public String sendEmail(Email email) {
		return sendMessage(email);
	}

	public String sendMessage(Email email) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(email.getFrom());
		simpleMailMessage.setTo(email.getTo());
		simpleMailMessage.setSubject(email.getSubject());
		simpleMailMessage.setText(email.getBody());
		mailSender.send(simpleMailMessage);
		return "Email has been sent successfully.";
	}
}