package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;
@org.springframework.stereotype.Service
public class Service {
	@Autowired
  private JavaMailSender javaMailSender;
	public String generateOtp()
	{
		Random random=new Random();
		int otp=100000+random.nextInt(900000);
		return String.valueOf(otp);
	}
	public void sendMail(Model1 model,String otp)
	{
		try 
		{
			String subject="Hye this otp is send by Gadi Dheko,[do not reply back]";
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setFrom("nitinsr246@gmail.com");
			helper.setTo(model.getDemail());
			helper.setSubject(subject);
			helper.setText("Your One Time Password is:"+"\t"+otp);
			javaMailSender.send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sendMail1(Model7 model7,String otp)
	{
		try 
		{
			String subject="Hye this otp is send by Gadi Dheko,[do not reply back]";
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setFrom("nitinsr246@gmail.com");
			helper.setTo(model7.getSemail());
			helper.setSubject(subject);
			helper.setText("Your One Time Password is:"+"\t"+otp);
			javaMailSender.send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	 public void sendMail2(Model11 model11,String otp)
	{
		try 
		{
			String subject="Hye this otp is send by Gadi Dheko,[do not reply back]";
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setFrom("nitinsr246@gmail.com");
			helper.setTo(model11.getFmail());
			helper.setSubject(subject);
			helper.setText("Your One Time Password is:"+"\t"+otp);
			javaMailSender.send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 
	 
	   public void sendMaill5(Model12 model12,String otp)
	{
		try 
		{
			String subject1="Hye this otp is send by Gadi Dheko,[do not reply back]";
			MimeMessage message1=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message1);
			helper.setFrom("nitinsr246@gmail.com");
			helper.setTo(model12.getFmaill());
			helper.setSubject(subject1);
			helper.setText("Your One Time Password is:"+"\t"+otp);
			javaMailSender.send(message1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	  
	 
}
