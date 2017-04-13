package store.service;

import javax.mail.MessagingException;

import store.persistence.model.MailSender;

public interface MailSenderService {
	
	public void end(MailSender mailSender)throws MessagingException;

}
