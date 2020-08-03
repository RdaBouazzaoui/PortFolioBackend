package org.sid.service;

import org.sid.metier.entities.Contact;
import org.sid.metier.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationtService {
	
   private JavaMailSender javaMailSender;
   
   @Value("${gmail.email}")
   private String emailToSend;
   
   @Autowired
   public NotificationtService(JavaMailSender javaMailSender) {
	   
	   this.javaMailSender=javaMailSender;
	   
   }
   public void sendNotification(Contact contact) throws MailException {
	   //send email to user
	   SimpleMailMessage mail = new SimpleMailMessage();
	   mail.setTo(emailToSend);
	   mail.setFrom(contact.getEmail());
	   mail.setSubject(contact.getSubject());
	   mail.setText(contact.getMessage());
	 //send email to admin
	   SimpleMailMessage mail1 = new SimpleMailMessage();
	   mail1.setTo(contact.getEmail());
	   mail1.setFrom(emailToSend);
	   mail1.setSubject(contact.getSubject());
	   mail1.setText("votre message a bien été envoyé. merci");
	   
	   javaMailSender.send(mail1);
	   javaMailSender.send(mail);
	
    }
	
	
}
