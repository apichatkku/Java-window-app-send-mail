import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MyClass {
	
   public static void main(String[] args) {
	  //email ���·ҧ
      String to = "java322252@gmail.com";
      
      //email �鹷ҧ
      final String username = "java322252@gmail.com";
      //password
      final String password = "322252322252";
      
      String host = "smtp.gmail.com";
      
      //��˹��س���ѵ�����Ѻ��㹡���������
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // ���ҧ object Session �����Ѻ Session ���������Ѻ�������
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // ���ҧ object MimeMessage
         Message message = new MimeMessage(session);

         // ��˹�����ŵ鹷ҧ���������Ѻ�������
         message.setFrom(new InternetAddress(username));

         // ��˹�����Ż��·�����ͧ�����������
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // ��˹��������ͧ�ͧ�����
         message.setSubject("Testing Subject");

         // ����ͤ�������ͧ��è����
         message.setText("Hello, this is sample for to check send "
            + "email using JavaMailAPI ");

         // ���������Ѻ������鹷ӡ���������
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}