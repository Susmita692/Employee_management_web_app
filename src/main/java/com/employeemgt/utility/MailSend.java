package com.employeemgt.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employeemgt.dto.EmailDetails;


@Service
public class MailSend {
	
	@Autowired
	private  JavaMailSender javaMailSender;
	
	public static void main(String[] args) {
		
		new MailSend().sendMail();
		
	}

	private  void sendMail() {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setFrom("d4363512@gmail.com");
		sm.setTo("jcodebun@gmail.com");
		sm.setSubject("Forgot Password Mail");
		sm.setText("Your Password for the Login is: ");
		try {
			javaMailSender.send(sm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
