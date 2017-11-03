package com.ezmed.util;

import com.ezmed.dto.Alerta;
import com.ezmed.dto.Cuidador;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Email
{
    private static String host;
    private static String porta;
    private static String auth;
    private static String de;
    private static String assunto;

    public Email()
    {
    }

    public static boolean enviarEmail(Alerta alerta)
    {
        loadConfigFile();

        Properties props = new Properties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", porta);
        props.put("mail.smtp.port", porta);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("alerta.ezmed@gmail.com", "SenhaAlertaEzMed");
                    }
                });

        try
        {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(de));

            Address[] toUser = InternetAddress.parse(String.join(", ", extrairEmailsAlerta(alerta)));

            message.setRecipients(Message.RecipientType.TO, toUser);

            message.setSubject(assunto + " " + alerta.getTratamento().getNome());

            message.setText(montarConteudoEmail(alerta));

            Transport.send(message);

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private static String montarConteudoEmail(Alerta alerta)
    {
        //TODO
        return "";
    }

    private static ArrayList<String> extrairEmailsAlerta(Alerta alerta)
    {
        ArrayList<String> listEmails = new ArrayList<>();

        for(Cuidador objC : alerta.getAssistantes())
        {
            listEmails.add(objC.getEmail());
        }

        return listEmails;
    }

    private static void loadConfigFile()
    {
        host = Ferramentas.lerPropriedade("email_host");
        porta = Ferramentas.lerPropriedade("email_smtp_porta");
        auth = Ferramentas.lerPropriedade("email_auth");
        de = Ferramentas.lerPropriedade("email_de");
        assunto = Ferramentas.lerPropriedade("email_assunto");
    }
}
