import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 

class VehiclesDetails extends JFrame implements ActionListener{

// Components
private boolean isFieldEmpty = false;

private JLabel vehile_labels[] = new JLabel[40];

private JTextField vehicle_textfields[] = new JTextField[40];

private String vehile_labels_str[] = {"Maker","Chassis No","Vehicle Category","Seating Capacity","Landen Weight(Kg)","Color","Body Type","Manufacture Month","Audio Fitted","Maker Model","Vehile Type","Fuel","No of Cylinders","Norms","Cubic Capacity","Video Fitted","Dealer","Vehile Class","Engine/Motor No","Unlanden Weight(Kg)","Purchase As","AC Fitted","Manufacture Year","Sale Amount","Other Criteria","Imported Vehicle","Model Manufactured Location"};
private String makers[] = {"HERO MOTOCORP LTD"};
private String makers_model[] = {"HF DELUXE-(ZZJN0008069)"};
private String dealers[] = {"a","b","c","d"};
private String vehicle_type[] = {"Transport","Non Transport"};
private String vehicle_class[] = {"M-Cycle/ Scooter","Car","Bus/ Minibus","Transport Car"};
private String vehicle_category[] = {"TWO WHEELER(NT)","THREE WHEELER","FOUR WHEELER"};
private String fuels[] = {"PETROL","DIESEL"};
private String norms[] = {"BHARAT STAGE IV"};
private String purchases[] = {"Fully Built"};
private String ac_fitted[] = {"NO","YES"};
private String audio_fitted[] = {"NO","YES"};
private String video_fitted[] = {"NO","YES"};

private JButton savevehicle = new JButton("Save Vehicle Details");
private JButton back = new JButton("Back");
private JButton logout = new JButton("Logout");

	//Constructor
	public VehiclesDetails(){

		for (int width_vehicle_labels = 20,height=50,count = 0; count < 27; count++){
			
        	if (count == 9){
        		width_vehicle_labels = 240;
        		height = 50;
        	}
        	else if (count == 18){
        		width_vehicle_labels = 460;
        		height = 50;
        	}

			vehile_labels[count] = new JLabel(vehile_labels_str[count]);
			vehile_labels[count].setBounds(width_vehicle_labels, height, 150, 25);
			vehile_labels[count].setFont(new Font("Serif", Font.PLAIN, 15));
			add(vehile_labels[count]);
			height += 25;
			if(count==0){
				JComboBox maker = new JComboBox<String>(makers);
				maker.setBounds(width_vehicle_labels, height, 200, 25);
				maker.setFont(new Font("Serif", Font.PLAIN, 15));
				add(maker);
			}
			else if(count==9){
				JComboBox maker_mod = new JComboBox<String>(makers_model);
				maker_mod.setBounds(width_vehicle_labels, height, 200, 25);
				maker_mod.setFont(new Font("Serif", Font.PLAIN, 15));
				add(maker_mod);
			}else if(count==16){
				JComboBox dealer = new JComboBox<String>(dealers);
				dealer.setBounds(width_vehicle_labels, height, 200, 25);
				dealer.setFont(new Font("Serif", Font.PLAIN, 15));
				add(dealer);
			}else if(count==10){
				JComboBox type = new JComboBox<String>(vehicle_type);
				type.setBounds(width_vehicle_labels, height, 200, 25);
				type.setFont(new Font("Serif", Font.PLAIN, 15));
				add(type);
			}else if(count==17){
				JComboBox vclass = new JComboBox<String>(vehicle_class);
				vclass.setBounds(width_vehicle_labels, height, 200, 25);
				vclass.setFont(new Font("Serif", Font.PLAIN, 15));
				add(vclass);
			}else if(count==2){
				JComboBox category = new JComboBox<String>(vehicle_category);
				category.setBounds(width_vehicle_labels, height, 200, 25);
				category.setFont(new Font("Serif", Font.PLAIN, 15));
				add(category);
			}else if(count==11){
				JComboBox fuel = new JComboBox<String>(fuels);
				fuel.setBounds(width_vehicle_labels, height, 200, 25);
				fuel.setFont(new Font("Serif", Font.PLAIN, 15));
				add(fuel);
			}else if(count==13){
				JComboBox norm = new JComboBox<String>(norms);
				norm.setBounds(width_vehicle_labels, height, 200, 25);
				norm.setFont(new Font("Serif", Font.PLAIN, 15));
				add(norm);
			}else if(count==20){
				JComboBox purchase = new JComboBox<String>(purchases);
				purchase.setBounds(width_vehicle_labels, height, 200, 25);
				purchase.setFont(new Font("Serif", Font.PLAIN, 15));
				add(purchase);
			}else if(count==21){
				JComboBox ac = new JComboBox<String>(ac_fitted);
				ac.setBounds(width_vehicle_labels, height, 200, 25);
				ac.setFont(new Font("Serif", Font.PLAIN, 15));
				add(ac);
			}else if(count==8){
				JComboBox audio = new JComboBox<String>(audio_fitted);
				audio.setBounds(width_vehicle_labels, height, 200, 25);
				audio.setFont(new Font("Serif", Font.PLAIN, 15));
				add(audio);
			}else if(count==15){
				JComboBox video = new JComboBox<String>(video_fitted);
				video.setBounds(width_vehicle_labels, height, 200, 25);
				video.setFont(new Font("Serif", Font.PLAIN, 15));
				add(video);
			}
			else{
			vehicle_textfields[count] = new JTextField();
			vehicle_textfields[count].setBounds(width_vehicle_labels, height, 200, 25);
			vehicle_textfields[count].setFont(new Font("Serif", Font.PLAIN, 15));
			vehicle_textfields[count].setBackground(new Color(233, 252, 251));
			add(vehicle_textfields[count]);
			}
			height += 25;
		}
		
		savevehicle.setBounds(220, 540, 250, 27);
		savevehicle.setFont(new Font("Serif", Font.PLAIN, 18));
		savevehicle.setForeground(Color.WHITE);
		savevehicle.setBackground(new Color(40, 167, 69));
		savevehicle.addActionListener(this);
		add(savevehicle);

		
		back.setBounds(50, 540, 100,27);
		back.setFont(new Font("Serif", Font.PLAIN, 18));
		back.setForeground(Color.BLACK);
		back.setBackground(new Color(255, 193, 7));
		back.addActionListener(this);
		add(back);

		
		logout.setBounds(530, 540, 100,27);
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
		JLabel header = new JLabel("VEHICLE DETAILS",JLabel.CENTER);
      	header.setVerticalAlignment(JLabel.TOP);
      	header.setFont(new Font("Serif", Font.BOLD, 25));
      	header.setPreferredSize(new Dimension(250, 100));
      	header.setForeground(new Color(120, 90, 40));
      	header.setBackground(new Color(100, 20, 70));
      	add(header);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == savevehicle){

			for (int i = 0 ; i < 27; i++){
				if(i == 0||i == 2||i == 8||i == 9||i == 10||i == 11||i == 13||i == 15||i == 16||i == 17||i == 20||i == 21){
					// Do nothing
				}
				else if(vehicle_textfields[i].getText().isEmpty()){
					isFieldEmpty = true;
					break;
				}
			}
			if(isFieldEmpty){
				JOptionPane.showMessageDialog(this,"Empty input field found or Invalid","Error",JOptionPane.ERROR_MESSAGE);
				isFieldEmpty = false;
			}
			else{
				new InsuranceDetails();
				dispose();			
			}
		}
		else if(e.getSource() == back){
			int a=JOptionPane.showConfirmDialog(this,"Are you sure? Changes will be not saved");
			if(a==JOptionPane.YES_OPTION){
			    new OwnerDetails();
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