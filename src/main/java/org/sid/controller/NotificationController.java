package org.sid.controller;

import org.sid.metier.entities.Contact;
import org.sid.metier.entities.User;
import org.sid.service.NotificationtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NotificationController {
	
	
	private Logger log = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private NotificationtService notificationService;
	
	
	@PostMapping("/contactez-moi")
	public Contact sendEmail(@RequestBody Contact cont ) {
		
		//send email
		try {
			notificationService.sendNotification(cont);
			
		} catch (MailException e) {
			// TODO: handle exception
			log.info("error"+e.getMessage());
		}
		
		
		return cont;
		
	}

}
