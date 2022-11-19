package com.employeemgt.utility;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.employeemgt.dto.EmailDetails;
import com.employeemgt.dto.UserDTO;


public class EmailBuilder {
	
	@Autowired 
	private static JavaMailSender javaMailSender;
	 
    @Value("${spring.mail.username}")
    private static String sender;

	public static String getForgetPasswordMessage(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your password is reccovered !! " + map.get("firstName") + " " + map.get("lastName") + "</H1>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}
	
	public static String getUserRegistration(HashMap<String, String> map) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML><BODY>");
		msg.append("<H1>Your Registation  Completed</H1>");
		msg.append("<H3>Your Registation Detail  !! " + map.get("firstName") + " " + map.get("lastName") + "</H3>");
		msg.append("<P><B>To access account user Login Id : " + map.get("login") + "<BR>" + " Password : "
				+ map.get("password") + "</B></p>");
		msg.append("</BODY></HTML>");

		return msg.toString();
	}

	
	public static String getEmployeeData( List<UserDTO> list) {
		StringBuilder msg = new StringBuilder();

		msg.append("<HTML>");
		msg.append("<Head>");
		msg.append("<style>");
		msg.append("table {font-family: arial, sans-serif;border-collapse: collapse;width: 50%;}");
		msg.append("td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;}");
		msg.append("h3{color:blue;}");
		msg.append("tr:nth-child(even) {background-color: #dddddd;}");
		msg.append("</style>");
		msg.append("</Head>");
		msg.append("<BODY>");
		msg.append("<h3>");
		msg.append("Employee List");
		msg.append("</h3>");

		msg.append("<table style='border=1;'>");
		msg.append("<tr>");
		msg.append("<th>#</th>");
		msg.append("<th>Employee Number</th>");
		msg.append("<th>First Name</th>");
		msg.append("<th>Last Name</th>");
		msg.append("<th>PhoneNumber</th>");
		msg.append("<th>Position</th>");
		msg.append("<th>Email</th>");
		msg.append("</tr>");

		double subTotal = 0;
		int i = 1;
		for (UserDTO entity : list) {
			msg.append("<tr>");
			msg.append("<td>" + (i++) + "</td>");
			msg.append("<td>" + entity.getEmpNumber() + "</td>");
			msg.append("<td>" + entity.getFirstName() + "</td>");
			msg.append("<td>" + entity.getLastName() + "</td>");
			msg.append("<td>" + entity.getPhoneNumber() + "</td>");
			msg.append("<td>" + entity.getPosition() + "</td>");
			msg.append("<td>" + entity.getEmail() + "</td>");
			msg.append("</tr>");
			
		}

		msg.append("</table>");

		msg.append("</BODY></HTML>");

		return msg.toString();
	}
	
	
	 public static String sendSimpleMail(EmailDetails details)
	    {
	 
	        // Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	        	e.printStackTrace();
	            return "Error while Sending Mail";
	        }
	    }
	

}
