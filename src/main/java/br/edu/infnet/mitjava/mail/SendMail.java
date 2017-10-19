package br.edu.infnet.mitjava.mail;

public class SendMail {

	public static void main(String[] args) {
		Mail.getInstance()
				.from("edveloso@gmai.com")
				.to("edveloso@gmail.com")
				.message("<h1>Olá este é um teste de envio de email</h1>")
				.subject("Mais um email para enviar para o pessoal");
//				.send();
	}

}
