package store.service;

import javax.mail.MessagingException;

import store.persistence.model.MailSender;

public interface MailSenderService {
	
	public void send(MailSender mailSender)throws MessagingException;

}
