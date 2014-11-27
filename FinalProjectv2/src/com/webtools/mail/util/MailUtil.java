package com.webtools.mail.util;


import java.security.Security;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class MailUtil {



        private static final String SMTP_HOST_NAME = "smtp.gmail.com";
        private static final String SMTP_PORT = "465";
        private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    public static final void sendMail(MailDTO mailDTO)
    {
       Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
       if(mailDTO!=null)
       {
        Properties props=new Properties();
        props.setProperty("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.smtp.port",SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session =Session.getInstance(props,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("www.healthcareservices.care", "Tcs@9-10-1984");
            }
        });
        session.setDebug(true);
      MimeMessage mimeMessage=new MimeMessage(session);

      try
      {
          
            //Transport bus=session.getTransport("smtp");
            //bus.connect("smtp.google.com",465,"abhijeet.kushe", "Tcs@9-10-1984");
          //Set the subject and Body
          mimeMessage.setSubject(mailDTO.getSubject());
          mimeMessage.setContent(mailDTO.getMailBody(),"text/html");


          Address[] addresses=null;
          //Set From Addresses
          {
                String[] fromAddress=(mailDTO.getFromAddress()!=null)?mailDTO.getFromAddress().split(","):null;
                if(fromAddress!=null)
                {
                    addresses=new InternetAddress[fromAddress.length] ;
                    for(int i=0;i<fromAddress.length;i++)
                    {
                       addresses[i]=new InternetAddress(fromAddress[i]);
                    }
                }
                 mimeMessage.addFrom(addresses);
          }

          //Set TO Addresses
          {
             String[] toAddress=(mailDTO.getAddressTO()!=null)?mailDTO.getAddressTO().split(","):null;

             if(toAddress!=null)
            {
                 addresses=new InternetAddress[toAddress.length] ;
                 for(int i=0;i<toAddress.length;i++)
                {
                    addresses[i]=new InternetAddress(toAddress[i]);

                }
                mimeMessage.setRecipients(RecipientType.TO, addresses);
             }
          }

          //Set CC Addresses

          {
             String[] ccAddress=(mailDTO.getAddressCC()!=null)?mailDTO.getAddressCC().split(","):null;

             if(ccAddress!=null)
            {
                 addresses=new InternetAddress[ccAddress.length] ;
                 for(int i=0;i<ccAddress.length;i++)
                {
                    addresses[i]=new InternetAddress(ccAddress[i]);

                }
                mimeMessage.setRecipients(RecipientType.CC, addresses);
             }
          }

          //Set BCC addresses
           {
              String[] bccAddress=(mailDTO.getAddressBCC()!=null)?mailDTO.getAddressBCC().split(","):null;
              if(bccAddress!=null)
              {
                 addresses=new InternetAddress[bccAddress.length] ;
                 for(int i=0;i<bccAddress.length;i++)
                 {
                    addresses[i]=new InternetAddress(bccAddress[i]);
                 }
                 mimeMessage.setRecipients(RecipientType.BCC, addresses);
              }
          }

          Transport.send(mimeMessage);
      }
      catch(MessagingException me)
      {
          me.printStackTrace();
      }
    }
    }

    public static void main(String[] args)
    {
        MailDTO mailDTO =new MailDTO();
        mailDTO.setSubject("Mail Test");
        mailDTO.setAddressTO("abhijeet.kushe@gmail.com");
        mailDTO.setFromAddress("abhijeet.kushe@gmail.com");
        mailDTO.setMailBody("This is a Test2 body of Mail");
        sendMail(mailDTO);
    }
}

