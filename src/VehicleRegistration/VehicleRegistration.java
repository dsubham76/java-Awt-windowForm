import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
import java.util.*;
class VehicleRegistration extends JFrame implements ActionListener{

//Components
private JLabel jlabels[] = new JLabel[10];
private JTextField jtextfields[] = new JTextField[10];
private JPasswordField passwordfield[] = new JPasswordField[10];
private String labels[] = {"USER ID/ EMAIL","PASSWORD","CAPTCHA"};
private JButton login = new JButton("LOGIN");
private JButton reload = new JButton("recap");
private JTextArea ta = new JTextArea();

	//Constructor
	public VehicleRegistration(){
		JLabel log = new JLabel("User Login");
		log.setBounds(245, 60, 200, 50);
		log.setFont(new Font("Serif", Font.BOLD, 37));
		log.setForeground(new Color(9, 67, 64));
		add(log);

		for (int height_login_labels = 130, count = 0; count < 3; count++){

			jlabels[count] = new JLabel(labels[count]);
			jlabels[count].setBounds(215, height_login_labels, 160, 30);
			jlabels[count].setFont(new Font("Serif", Font.PLAIN, 15));
			add(jlabels[count]);
			height_login_labels += 35;

			if (count == 1){
				passwordfield[count] = new JPasswordField();
				passwordfield[count].setBounds(215, height_login_labels, 240, 30);
				passwordfield[count].setFont(new Font("Serif", Font.PLAIN, 15));
				passwordfield[count].setBackground(new Color(233, 252, 251));
				add(passwordfield[count]);
			}
			else{
				jtextfields[count] = new JTextField();
				jtextfields[count].setBounds(215, height_login_labels, 240, 30);
				jtextfields[count].setFont(new Font("Serif", Font.PLAIN, 15));
				jtextfields[count].setBackground(new Color(233, 252, 251));
				add(jtextfields[count]);
			}
			height_login_labels += 50;
		}

		ta.setBounds(360, 305, 93,20);
		ta.setFont(new Font("Serif", Font.BOLD, 14));
		ta.setForeground(Color.BLACK);
		ta.setBackground(new Color(255, 236, 179));
		ta.setText(generateCaptchaString());
		add(ta);

		reload.setBounds(290, 305, 60,20);
		reload.setFont(new Font("Serif", Font.PLAIN, 12));
		reload.addActionListener(this);
		add(reload);

		login.setBounds(215,385,100,30);
		login.setFont(new Font("Serif", Font.PLAIN, 18));
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(0, 123, 255));
		login.addActionListener(this);
		add(login);

		JButton signup = new JButton("SIGNUP");
		signup.setBounds(353, 385, 100,30);
		signup.setFont(new Font("Serif", Font.PLAIN, 18));
		signup.setForeground(Color.BLACK);
		signup.setBackground(new Color(255, 193, 7));
		add(signup);

		header();
		pack();
		setVisible(true);
		setResizable(false);
		setBounds(300,50,700,650);
		setTitle("Vehicle Registration Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void header(){
		JLabel header = new JLabel("REGISTER YOUR VEHICLE",JLabel.CENTER);
      	header.setVerticalAlignment(JLabel.TOP);
      	header.setFont(new Font("Serif", Font.BOLD, 25));
      	header.setPreferredSize(new Dimension(250, 100));
      	header.setForeground(new Color(120, 90, 40));
      	header.setBackground(new Color(100, 20, 70));
      	add(header);
	}

	private String generateCaptchaString() {
		Random random = new Random();
		int length = 5 + (Math.abs(random.nextInt()) % 3);
		StringBuffer captchaStringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int baseCharNumber = Math.abs(random.nextInt()) % 62;
			int charNumber = 0;
			if (baseCharNumber < 26) {
				charNumber = 65 + baseCharNumber;
			}
			else if (baseCharNumber < 52){
				charNumber = 97 + (baseCharNumber - 26);
			}
			else {
				charNumber = 48 + (baseCharNumber - 52);
			}
			captchaStringBuffer.append((char)charNumber);
		}
		return captchaStringBuffer.toString();
	}
	
	public void actionPerformed(ActionEvent e){

		if (e.getSource() == reload){
			ta.setText(generateCaptchaString());
		}
		
		else if (e.getSource() == login){
			if(jtextfields[0].getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"User Id is Empty or Invalid","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if (passwordfield[1].getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Password is Empty or Invalid","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(jtextfields[2].getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Enter Captcha to Login","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(! jtextfields[2].getText().equals(ta.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Captcha","Error",JOptionPane.ERROR_MESSAGE);
			}
			else{
				new OwnerDetails();
				dispose();
			}
		}
	}

	public static void main(String [] args){
		new VehicleRegistration();
	}
}
