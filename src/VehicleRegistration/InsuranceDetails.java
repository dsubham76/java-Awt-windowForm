import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
import java.time.*;
import java.util.*;
class InsuranceDetails extends JFrame implements ActionListener{

//Components
private boolean isFieldEmpty = false;

private JLabel insurance_labels[] = new JLabel[10];
private JLabel table_header[] = new JLabel[10];
private JTextField insurance_textfields[] = new JTextField[10];
private JTextField table_textfields[] = new JTextField[10];

private String insurance_labels_str[] = {"Insurance Type","Insurance Company","Policy/CoverNote No","Insurance from","Insurance Upto","Insurance Declared Value"};
private String column[] = {"Sr. No","Application No","Date","Vehicle No","Movement No","Status","Action"};
private String ins_types[] = {"Comprehensive","Not Available","Theft and third Party","Third Party"};
private String ins_company[] = {"AARVI GENERAL INS","ABN AMERO BANK LTD","Acko General Insurance Limited","Aditya Birla Health Insurance Co Ltd","ICIC BANK"};
private String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
private String months[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
private String years[]={"2024","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};

private JButton saveinsurance = new JButton("Save and File Movement");
private JButton print = new JButton("Print Disclaimer");
private JButton back = new JButton("Back");
private JButton payment = new JButton("Payment Method");
private JButton logout = new JButton("Logout");
private JButton invoice = new JButton("Check Invoice Status");
private JButton action = new JButton("Verify");

	//Constructor
	public InsuranceDetails(){
		 
		for (int width_vehicle_labels = 100,height=100,count = 0; count < 6; count++){
			
        	if (count == 3){
        		// if(count==5)
        		width_vehicle_labels = 370;
        		height = 100;
        	}
        	

			insurance_labels[count] = new JLabel(insurance_labels_str[count]);
			insurance_labels[count].setBounds(width_vehicle_labels, height, 180, 25);
			insurance_labels[count].setFont(new Font("Serif", Font.PLAIN, 15));
			add(insurance_labels[count]);
			height += 30;
			if(count==0){
				JComboBox ins_type = new JComboBox<String>(ins_types);
				ins_type.setBounds(width_vehicle_labels, height, 200, 25);
				ins_type.setFont(new Font("Serif", Font.PLAIN, 15));
				add(ins_type);
			}else if (count==1){
				JComboBox ins_comp = new JComboBox<String>(ins_company);
				ins_comp.setBounds(width_vehicle_labels, height, 200, 25);
				ins_comp.setFont(new Font("Serif", Font.PLAIN, 15));
				add(ins_comp);
			}else if(count==3 || count==4){
				JComboBox day=new JComboBox<String>(days);
				JComboBox month=new JComboBox<String>(months);
				JComboBox year=new JComboBox<String>(years);
				year.setSelectedIndex(3);
				day.setBounds(width_vehicle_labels, height, 60, 25);
				day.setFont(new Font("Serif", Font.PLAIN, 15));
				month.setBounds(width_vehicle_labels+65, height, 60, 25);
				month.setFont(new Font("Serif", Font.PLAIN, 15));
				year.setBounds(width_vehicle_labels+130, height, 65, 25);
				year.setFont(new Font("Serif", Font.PLAIN, 15));
				add(day);add(month);add(year);
			}

			else {
			insurance_textfields[count] = new JTextField();
			insurance_textfields[count].setBounds(width_vehicle_labels, height, 200, 25);
			insurance_textfields[count].setFont(new Font("Serif", Font.PLAIN, 15));
			insurance_textfields[count].setBackground(new Color(233, 252, 251));
			add(insurance_textfields[count]);
			}

			height += 30;
		}

		
		saveinsurance.setBounds(230, 300, 220, 27);
		saveinsurance.setFont(new Font("Serif", Font.PLAIN, 18));
		saveinsurance.setForeground(Color.WHITE);
		saveinsurance.setBackground(new Color(40, 167, 69));
		saveinsurance.addActionListener(this);
		add(saveinsurance);

		print.setBounds(245, 335, 190, 27);
		print.setFont(new Font("Serif", Font.PLAIN, 18));
		print.setForeground(Color.WHITE);
		print.setBackground(new Color(23, 162, 184));
		print.addActionListener(this);
		add(print);

		
		logout.setBounds(290, 370, 100,27);
		logout.setFont(new Font("Serif", Font.PLAIN, 18));
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(220, 53, 69));
		logout.addActionListener(this);
		add(logout);
		

		for (int width_reg_labels = 30, count_login_label = 0; count_login_label < 7; count_login_label++){
			if(count_login_label==1){
				width_reg_labels = 125;
			}
			if(count_login_label==2){
				width_reg_labels = 240;
			}
			if(count_login_label==3){
				width_reg_labels = 315;
			}
			if(count_login_label==4){
				width_reg_labels = 397;
			}
			if(count_login_label==5){
				width_reg_labels = 505;
			}
			if(count_login_label==6){
				width_reg_labels = 595;
			}
			table_header[count_login_label] = new JLabel(column[count_login_label]);
			table_header[count_login_label].setBounds(width_reg_labels, 430, 120, 25);
			table_header[count_login_label].setFont(new Font("Serif", Font.PLAIN, 14));
			add(table_header[count_login_label]);
			width_reg_labels += 110;	
		}
		for (int width_reg_labels = 30,width=50, count_login_label = 0; count_login_label < 6; count_login_label++){
			table_textfields[count_login_label] = new JTextField();
			table_textfields[count_login_label].setBounds(width_reg_labels, 460, 91, 50);
			table_textfields[count_login_label].setFont(new Font("Serif", Font.PLAIN, 14));
			table_textfields[count_login_label].setBackground(new Color(233, 252, 251));
			add(table_textfields[count_login_label]);
			width_reg_labels += 90;	
		}
		
		action.setBounds(580, 470, 80, 27);
		action.setFont(new Font("Serif", Font.PLAIN, 18));
		action.setForeground(Color.WHITE);
		action.setBackground(new Color(23, 162, 184));
		action.addActionListener(this);
		add(action);

		
		back.setBounds(50, 530, 100,27);
		back.setFont(new Font("Serif", Font.PLAIN, 18));
		back.setForeground(Color.BLACK);
		back.setBackground(new Color(255, 193, 7));
		back.addActionListener(this);
		add(back);

		
		payment.setBounds(215, 530, 160, 27);
		payment.setFont(new Font("Serif", Font.PLAIN, 18));
		payment.setForeground(Color.WHITE);
		payment.setBackground(new Color(0, 123, 255));
		add(payment);

		
		invoice.setBounds(430, 530, 190, 27);
		invoice.setFont(new Font("Serif", Font.PLAIN, 18));
		invoice.setForeground(Color.WHITE);
		invoice.setBackground(new Color(0, 123, 255));
		add(invoice);

		header();

		setVisible(true);
		setResizable(false);
		setBounds(300,50,700,650);
		setTitle("Vehicle Registration Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void header(){
		JLabel header = new JLabel("INSURANCE DETAILS",JLabel.CENTER);
      	header.setVerticalAlignment(JLabel.TOP);
      	header.setFont(new Font("Serif", Font.BOLD, 25));
      	header.setPreferredSize(new Dimension(250, 100));
      	header.setForeground(new Color(120, 90, 40));
      	header.setBackground(new Color(100, 20, 70));
      	add(header);
	}
	private String generateRandomCharacter() {
		Random random = new Random();
		int length = 7 + (Math.abs(random.nextInt()) % 3);
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
		return captchaStringBuffer.toString().toUpperCase();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==saveinsurance)  
        {
			for (int i = 0 ; i < 6; i++){
				if(i == 0||i == 1||i == 3||i == 4){
					// Do nothing
				}
				else if(insurance_textfields[i].getText().isEmpty()){
					isFieldEmpty = true;
					break;
				}
			}
			if(isFieldEmpty){
				JOptionPane.showMessageDialog(this,"Empty input field found or Invalid","Error",JOptionPane.ERROR_MESSAGE);
				isFieldEmpty = false;
			}
			else{
				if(!table_textfields[0].getText().isEmpty()){
					JOptionPane.showMessageDialog(this,"You have already applied. Your Application Number is: "+table_textfields[1].getText(),"Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
				table_textfields[0].setText("1");
				table_textfields[1].setText("CR"+generateRandomCharacter());
				table_textfields[2].setText(LocalDate.now().toString());
				table_textfields[3].setText("WB"+generateRandomCharacter().substring(2,5));
				table_textfields[4].setText("MV"+generateRandomCharacter());
				table_textfields[5].setText("Pending");
				}
			}
		
        }
        else if(e.getSource()==action){
        	if(!table_textfields[5].getText().isEmpty()){
        		table_textfields[5].setText("Verified");
        		table_textfields[5].setBackground(new Color(179, 255, 179));
        	}
        }
        else if(e.getSource() == back){
			int a=JOptionPane.showConfirmDialog(this,"Are you sure? Changes will be not saved");
			if(a==JOptionPane.YES_OPTION){
			    new VehiclesDetails();
				dispose();
			}
		}
		else if(e.getSource() == logout){
			int a=JOptionPane.showConfirmDialog(this,"Are you want to Logout ?");
			if(a==JOptionPane.YES_OPTION){
			    new VehicleRegistration();
				dispose();
			}
		}
	}
	public static void main(String [] args){
		new VehicleRegistration();
		
	}
}