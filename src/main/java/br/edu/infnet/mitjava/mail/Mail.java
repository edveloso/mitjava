package br.edu.infnet.mitjava.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.edu.infnet.mitjava.util.Messages;

public class Mail {

	private Properties props;
	private Session session;
	private Message message;
	private String to;
	private String from;
	private String textMessage;
	private String assunto;

	private Mail() {
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.socketFactory.port", "465"); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", "465"); 

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Messages.getString("mail.usuario"), Messages.getString("mail.senha")); 
			}
		});
		session.setDebug(true);
	}

	public static Mail getInstance() {
		return new Mail();
	}

	public Mail to(String to) {
		this.to = to;
		return this;
	}

	public Mail from(String from) {
		this.from = from;
		return this;
	}

	public void send() {
		try {
			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from)); // Remetente
			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(to);
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);// Assunto
			message.setText(textMessage);
			Transport.send(message);
			System.out.println("Feito!!!"); //$NON-NLS-1$
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public Mail message(String textMessage) {
		this.textMessage = textMessage;
		return this;
	}

	public Mail subject(String assunto) {
		this.assunto = assunto;
		return this;
	}

}
