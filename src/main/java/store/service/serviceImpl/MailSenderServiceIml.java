package store.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import store.persistence.entity.User;
import store.persistence.model.MailSender;

@Service
public class MailSenderServiceIml implements store.service.MailSenderService{

	@Autowired
    private JavaMailSender javaMailSender;

    private MimeMessage message;
    private MimeMessageHelper helper;
    
	@Override
	public void send(MailSender mailSender) throws MessagingException {
		
	    message = javaMailSender.createMimeMessage();
        helper = new MimeMessageHelper(message, true); 
        helper.setSubject(mailSender.getSubject());
        helper.setTo(mailSender.getTo());
        helper.setText(mailSender.getText(), true); 
        
        javaMailSender.send(message);
			
	
	}


}
