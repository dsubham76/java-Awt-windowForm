import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 

class OwnerDetails extends JFrame implements ActionListener{

//Components
private boolean isFieldEmpty = false;

private JLabel reg_type[] = new JLabel[5];
private JLabel owner_labels[] = new JLabel[20];

private JTextField search_textfields[] = new JTextField[5];
private JTextField owner_textfields[] = new JTextField[20];

private String reg_labels[] = {"Chassis Number","Engine/ Motor Number(Last 5 Chars)"};
private String owner_labels_str[] = {"Registration Type","Purchase/Delivery Date","Owner Name","Ownership Type","Son/Wife/Daughter of","Ownership Serial","Owner Category","Mobile No","Email Id","PAN No","Aadhaar No","Passport No","Ration Card No","Voter Id","DL/LL No","Address"};
private String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
private String months[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
private String years[]={"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995"};
private String reg_types_str[] = {"NEW"};
private String owner_types[] = {"INDIVISUAL"};
private String owner_category[] = {"GENERAL","SC","ST","OBC"};

private JButton details = new JButton("Get Details");
private JButton inward = new JButton("Inward Application (Partial Save)");
private JButton back = new JButton("Back");
private JButton logout = new JButton("Logout");

	//Constructor
	public OwnerDetails(){

        for (int width_reg_labels = 20, count_login_label = 0; count_login_label < 2; count_login_label++){
			reg_type[count_login_label] = new JLabel(reg_labels[count_login_label]);
			reg_type[count_login_label].setBounds(width_reg_labels, 50, 290, 25);
			reg_type[count_login_label].setFont(new Font("Serif", Font.PLAIN, 15));
			add(reg_type[count_login_label]);
			width_reg_labels += 350;
		}
		for (int width_reg_labels = 20, count_login_label = 0; count_login_label < 2; count_login_label++){
			search_textfields[count_login_label] = new JTextField();
			search_textfields[count_login_label].setBounds(width_reg_labels, 80, 290, 25);
			search_textfields[count_login_label].setFont(new Font("Serif", Font.PLAIN, 15));
			search_textfields[count_login_label].setBackground(new Color(233, 252, 251));
			add(search_textfields[count_login_label]);
			width_reg_labels += 350;
		}
		
		details.setBounds(260,120,150,25);
		details.setFont(new Font("Serif", Font.PLAIN, 18));
		details.setForeground(Color.WHITE);
		details.setBackground(new Color(40, 167, 69));
		details.addActionListener(this);
    	add(details);

        for (int width_owner_labels = 20,height=200,count = 0; count < 15; count++){
        	if (count == 5){
        		width_owner_labels = 240;
        		height = 200;
        	}
        	else if (count == 10){
        		width_owner_labels = 460;
        		height = 200;
        	}
			owner_labels[count] = new JLabel(owner_labels_str[count]);
			owner_labels[count].setBounds(width_owner_labels, height, 150, 25);
			owner_labels[count].setFont(new Font("Serif", Font.PLAIN, 15));
			add(owner_labels[count]);
			height += 30;
			if (count==0){
				JComboBox r_type = new JComboBox<String>(reg_types_str);
				r_type.setBounds(width_owner_labels, height, 200, 25);
				r_type.setFont(new Font("Serif", Font.PLAIN, 15));
				add(r_type);
			}else if (count==1){
				JComboBox day=new JComboBox<String>(days);
				JComboBox month=new JComboBox<String>(months);
				JComboBox year=new JComboBox<String>(years);
				day.setBounds(width_owner_labels, height, 62, 25);
				day.setFont(new Font("Serif", Font.PLAIN, 15));
				month.setBounds(width_owner_labels+67, height, 62, 25);
				month.setFont(new Font("Serif", Font.PLAIN, 15));
				year.setBounds(width_owner_labels+137, height, 62, 25);
				year.setFont(new Font("Serif", Font.PLAIN, 15));
				add(day);add(month);add(year);
			}else if (count==3){
				JComboBox owner_type = new JComboBox<String>(owner_types);
				owner_type.setBounds(width_owner_labels, height, 200, 25);
				owner_type.setFont(new Font("Serif", Font.PLAIN, 15));
				add(owner_type);
			}else if (count==6){
				JComboBox categ = new JComboBox<String>(owner_category);
				categ.setBounds(width_owner_labels, height, 200, 25);
				categ.setFont(new Font("Serif", Font.PLAIN, 15));
				add(categ);
			}
			else{
			owner_textfields[count] = new JTextField();
			owner_textfields[count].setBounds(width_owner_labels, height, 200, 25);
			owner_textfields[count].setFont(new Font("Serif", Font.PLAIN, 15));
			owner_textfields[count].setBackground(new Color(233, 252, 251));
			add(owner_textfields[count]);
			}
			height += 30;
		}
		
		inward.setBounds(200, 530, 290,27);
		inward.setFont(new Font("Serif", Font.PLAIN, 18));
		inward.setForeground(Color.WHITE);
		inward.setBackground(new Color(40, 167, 69));
		inward.addActionListener(this);
		add(inward);

		
		back.setBounds(50, 530, 100,27);
		back.setFont(new Font("Serif", Font.PLAIN, 18));
		back.setForeground(Color.BLACK);
		back.setBackground(new Color(255, 193, 7));
		back.addActionListener(this);
		add(back);

		
		logout.setBounds(530, 530, 100,27);
		logout.setFont(new Font("Serif", Font.PLAIN, 18));
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(220, 53, 69));
		logout.addActionListener(this);
		add(logout);

		header();
		setVisible(true);
		setResizable(false);
		setBounds(300,50,700,650);
		setTitle("Vehicle Registration Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void header(){
		JLabel header = new JLabel("OWNER DETAILS",JLabel.CENTER);
      	header.setVerticalAlignment(JLabel.TOP);
      	header.setFont(new Font("Serif", Font.BOLD, 25));
      	header.setPreferredSize(new Dimension(250, 100));
      	header.setForeground(new Color(120, 90, 40));
      	header.setBackground(new Color(100, 20, 70));
      	add(header);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == inward){
			if(search_textfields[0].getText().isEmpty() || search_textfields[1].getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Empty Search field found or Invalid","Error",JOptionPane.ERROR_MESSAGE);
			}

			else{
				for (int i = 0 ; i < 15; i++){
					if(i == 0||i == 1||i == 3||i == 6){
						// Do nothing
					}
					else if(owner_textfields[i].getText().isEmpty()){
						isFieldEmpty = true;
						break;
					}
				}
				if(isFieldEmpty){
					JOptionPane.showMessageDialog(this,"Empty input field found or Invalid","Error",JOptionPane.ERROR_MESSAGE);
					isFieldEmpty = false;
				}
				else{
					new VehiclesDetails();
					dispose();			
				}
			}
		}
		else if(e.getSource() == back){
				int a=JOptionPane.showConfirmDialog(this,"Are you sure? Changes will be not saved");
				if(a==JOptionPane.YES_OPTION){
				    new VehicleRegistration();
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
		new OwnerDetails();
	}
}