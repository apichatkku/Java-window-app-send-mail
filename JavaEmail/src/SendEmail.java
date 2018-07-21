import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    String username = "";
    String password = "";
	
	
	public SendEmail() {
		this.username = "java322252@gmail.com";
		this.password = "322252322252";
	}
	
   public void send(String pto,String ptitle,String pmsg) {
	   
      String to = pto;

      String title = ptitle;
      String msg = pmsg;
      
      String host = "smtp.gmail.com";
      
      //กำหนดคุณสมบัติสำหรับใช้ในการส่งอีเมล
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // สร้าง object Session เพื่อรับ Session ที่ใช้สำหรับส่งอีเมล
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // สร้าง object MimeMessage
         Message message = new MimeMessage(session);

         // กำหนดอีเมลต้นทางที่ใช้สำหรับส่งอีเมล
         message.setFrom(new InternetAddress(username));

         // กำหนดอีเมลปลายที่ที่ต้องการส่งอีเมลไป
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // กำหนดหัวเรื่องของอีเมล
         message.setSubject(title);

         // ใส่ข้อความที่ต้องการจะส่งไป
         message.setText(msg);

         // คำสั่งสำหรับเริ่มต้นทำการส่งอีเมล
         Transport.send(message);

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}