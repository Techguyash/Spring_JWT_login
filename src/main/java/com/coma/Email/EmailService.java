/**
 * 
 */
package com.coma.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



/**
 * @author tweety
 *
 */
@Service
public class EmailService implements EmailSender
{
    @Autowired
    private JavaMailSender mailSender;

    private static Logger LOGGER=org.slf4j.LoggerFactory.getLogger(EmailService.class);
    
    @Override
    @Async
    public void send(String to, String email)
    {
	try
	{
	    MimeMessage mimeMessage=mailSender.createMimeMessage();
	    MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"UTF-8");
	    helper.setText(email,true);
	    helper.setTo(to);
	    helper.setSubject("Please confirm the mail");
//	    helper.setFrom("ashiq.s@gmail.com");
	    helper.setFrom("ashiq@codemachines.in");
	    mailSender.send(mimeMessage);
	    
	    
	    
	    
	    
	}
	catch (MessagingException e) 
	{
	    LOGGER.error("Failed to send email");
	    throw new IllegalStateException("Failed to send eMail");
	}
    }
    
}

