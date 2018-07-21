import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormSendEmail implements ActionListener{
	private JFrame fr;
	private JPanel pTop,pC1,pC2,pBottom,pCenter;
	private JLabel lbHead,lbTo,lbTitle,lbMessage;
	private JButton btnSend;
	private JTextField tfTo,tfTitle;
	private JTextArea taMsg;
	static SendEmail sendMail ;
	
	public void init(){
		fr = new JFrame("Form Send Mail");
		
		pTop = new JPanel();
		pC1 = new JPanel();
		pC2 = new JPanel();
		pBottom = new JPanel();
		pCenter = new JPanel();
		
		lbHead = new JLabel("Form Send Email");
		lbTo = new JLabel("To : ");
		lbTitle = new JLabel("Title : ");
		lbMessage = new JLabel("Message : ");
		
		tfTo = new JTextField(30);
		
		tfTitle = new JTextField(30);
		
		taMsg = new JTextArea(15, 20);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		
		pTop.setLayout(new FlowLayout());
		pTop.add(lbHead);
		
		pC1.setLayout(new GridLayout(5,1));
		pC1.add(lbTo);
		pC1.add(tfTo);
		pC1.add(lbTitle);
		pC1.add(tfTitle);
		pC1.add(lbMessage);
		
		pC2.setLayout(new GridLayout(1,1));
		pC2.add(taMsg);
		
		pCenter.setLayout(new GridLayout(2,1));
		pCenter.add(pC1);
		pCenter.add(pC2);
		
		pBottom.setLayout(new FlowLayout());
		pBottom.add(btnSend);
		
		Container c = fr.getContentPane();
		c.add(pTop,BorderLayout.PAGE_START);
		c.add(pCenter,BorderLayout.CENTER);
		c.add(pBottom,BorderLayout.PAGE_END);
		fr.setSize(400, 400);
		fr.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		FormSendEmail obj = new FormSendEmail();
		sendMail = new SendEmail();
		obj.init();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == btnSend){
			sendMail.send(tfTo.getText(), tfTitle.getText(), taMsg.getText());
			JOptionPane.showMessageDialog(null,"Sent message successfully....\n");
		}
		
	}

}
