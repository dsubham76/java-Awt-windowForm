import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class HotelMenuCard extends JFrame{


final JLabel food_order[] = new JLabel[7];
final String foods[] = {"1. FRIED RICE","2. PLAIN RICE","3. BANGUS","4. TANGEGE","5. PUSIT","6. TILAPIA","7. HIPON"};
final String prices[] = {"25.00","15.00","85.00","120.00","100.00","100.00","150.00"};
final JCheckBox price_checkbox[] = new JCheckBox[7];
final JLabel quantity[] = new JLabel[7];
final JTextField quantity_textfield[] = new JTextField[7];
final JLabel amount[] = new JLabel[7];
final JTextField amount_textfield[] = new JTextField[7];

	// Contructor
	HotelMenuCard(){
		
		// Food Order Label
		for (int height_food_order = 60, count_food_order = 0; count_food_order < 7; count_food_order++){
			food_order[count_food_order] = new JLabel(foods[count_food_order]);
			food_order[count_food_order].setBounds(50, height_food_order, 130, 30);
			add(food_order[count_food_order]);
			height_food_order += 40;
		}

		// Price Checkbox
		for (int height_checkbox = 60, count_checkbox = 0; count_checkbox < 7; count_checkbox++){
			price_checkbox[count_checkbox] = new JCheckBox(prices[count_checkbox]);
			price_checkbox[count_checkbox].setBounds(150, height_checkbox, 100, 30);
			add(price_checkbox[count_checkbox]);
			height_checkbox += 40;
		}

		// Quantity Label 
		for (int height_quantity_label = 60, count_quantity_label = 0; count_quantity_label < 7; count_quantity_label++){
			quantity[count_quantity_label] = new JLabel("QUANTITY");
			quantity[count_quantity_label].setBounds(250, height_quantity_label, 100, 30);
			add(quantity[count_quantity_label]);
			height_quantity_label += 40;
		}
		// Quantity Textfield
		for (int height_quantity_textfield = 60, count_quantity_textfield = 0; count_quantity_textfield < 7; count_quantity_textfield++){
			quantity_textfield[count_quantity_textfield] = new JTextField();
			quantity_textfield[count_quantity_textfield].setBounds(350, height_quantity_textfield, 100, 30);
			add(quantity_textfield[count_quantity_textfield]);
			height_quantity_textfield += 40;
		}
		// Amount Label
		for (int height_amount_label = 60, count_amount = 0; count_amount < 7; count_amount++){
			amount[count_amount] = new JLabel("AMOUNT");
			amount[count_amount].setBounds(500, height_amount_label, 100, 30);
			add(amount[count_amount]);
			height_amount_label += 40;
		}
		// Amount textfield
		for (int height_amount_textfield = 60, count_amount_textfield = 0; count_amount_textfield < 7; count_amount_textfield++){
			amount_textfield[count_amount_textfield] = new JTextField();
			amount_textfield[count_amount_textfield].setBounds(600, height_amount_textfield, 100, 30);
			add(amount_textfield[count_amount_textfield]);
			height_amount_textfield += 40;
		}

		// Setting up buttons
		setButtons();


		/* 
			Title: Major bug found here .. need help !
			Issue: Without giving and setting a propery (Label, Textfield, Textarea, etc) ,
				   The JFrame returns an unexpected class(Last entered property).
		*/

		// Add Header
		JLabel header = new JLabel("Welcome to Kunal's Place! Choose your Order",JLabel.CENTER);
      	header.setVerticalAlignment(JLabel.TOP);
      	header.setFont(new Font("Verdana", Font.PLAIN, 24));
      	header.setPreferredSize(new Dimension(250, 100));
      	header.setForeground(new Color(120, 90, 40));
      	header.setBackground(new Color(100, 20, 70));
      	add(header);
    
		setSize(790,600);
		setVisible(true);
	}

	public void setButtons(){
		/*
			Setting up the JButton class for minor tasks.
		*/
		JButton calculate = new JButton("CALCULATE");
		calculate.setBounds(100, 400, 130, 30);
		add(calculate);

		JTextField calculate_textfield = new JTextField();
		calculate_textfield.setBounds(250, 400, 200, 45);
		add(calculate_textfield);

		JLabel entered_cash = new JLabel("ENTERED CASH");
		entered_cash.setBounds(100, 450, 150, 20);
		add(entered_cash);

		JTextField entered_cash_textfield = new JTextField();
		entered_cash_textfield.setBounds(250, 450, 150, 20);
		add(entered_cash_textfield);

		JLabel change = new JLabel("CHANGE");
		change.setBounds(100, 480, 150, 20);
		add(change);

		JTextField change_textfield = new JTextField();
		change_textfield.setBounds(250, 480, 150, 20);
		add(change_textfield);

		JButton add_to_cart = new JButton("ADD TO CART");
		add_to_cart.setBounds(530, 400, 155, 30);
		add(add_to_cart);

		JButton order_now = new JButton("ORDER NOW");
		order_now.setBounds(530, 440, 155, 30);
		add(order_now);

		JButton download_receipt = new JButton("DOWNLOAD RECEIPT");
		download_receipt.setBounds(530, 480, 155, 30);
		add(download_receipt);
	}

	//Main method
	public static void main(String[] args){
		HotelMenuCard h = new HotelMenuCard();
		h.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}