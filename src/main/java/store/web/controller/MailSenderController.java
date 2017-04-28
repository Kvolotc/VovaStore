package store.web.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import store.persistence.model.MailSender;
import store.service.MailSenderService;

@RestController
@Async
public class MailSenderController {
	
	@Autowired
	private MailSenderService service;
	
    @RequestMapping(value="/mailsender", method = RequestMethod.POST)
    public void sendMail(@RequestBody MailSender mailSender){
    	
    	System.out.println("MailSENDER == "+mailSender);
    	
    	try {
			service.send(mailSender);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
