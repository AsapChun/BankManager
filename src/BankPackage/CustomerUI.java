package BankPackage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CustomerUI extends JFrame { //Every customer has a checking and saving account
	//totalCustomer will be used to create reports
	Scanner scan = new Scanner(System.in);
	
	public class RegisterPageUI extends JFrame{
		public RegisterPageUI() {
			/*
			 * Make another JFrame
			 */
			JButton btn_register = new JButton( "Register" );
			JPanel panel = new JPanel();
			add(panel);
			panel.add(btn_register);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
			btn_register.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					//go  to sign in page
					/*
					 * Do everything above except we need to register the data
					 */
					Customer just_made = new Customer(); //DELETE LATER, MODIFY to fit whatever is typed in
					CustomerHomepageUI registerpage = new CustomerHomepageUI(just_made);
				}

			});
		}
	}
	
	public class LoginPageUI extends JFrame{
		
		public LoginPageUI() {
			/*
			 * Ask for user info and bring them to their respective page
			 */
			JLabel user_field = new JLabel("Username");
			JLabel password_field = new JLabel("Password");
			JTextField text_field_1 = new JTextField(8);
			JPasswordField password_field_1 = new JPasswordField(8);
			JButton btn_Log_In = new JButton( "Log In" );
			
			user_field.setBounds(80, 70, 200, 30);
			password_field.setBounds(80, 110, 200, 30);
			text_field_1.setBounds(300, 70, 200, 30);
			password_field_1.setBounds(300, 110, 200, 30);
			JPanel panel = new JPanel();
			add(panel);
			panel.add(user_field);
			panel.add(text_field_1);
			panel.add(password_field);
			panel.add(password_field_1);		
			panel.add(btn_Log_In);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
		
		
		btn_Log_In.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//go  to sign in page
				/*
				 * Do everything above except we need to register the data
				 */
				String input_name = text_field_1.getSelectedText(); //gets the name
				String password = password_field_1.getSelectedText(); //NOTE: Gotta handle null pnter
				if(Bank.findCustomer(input_name,password)) {
					Customer retrieving = Bank.retrieveCustomer(input_name, password);
					Customer existing = new Customer(); //DELETE LATER, SHOULD  CHECK DATABASE IF USER EXIST
					//i.e. check Bank.CustomerList if exist -> else -> error
					CustomerHomepageUI home_page = new CustomerHomepageUI(existing);
				}
				//else do nothing
			}
		});
		}
	}
	
	public class CustomerHomepageUI extends JFrame{
		public CustomerHomepageUI(Customer current_customer) {
			/*
			 * Inside CustomerUI actual main interface - i.e. has to go through validation or make a new one
			 * TODO: Show Customer Name using Jlabel?
			 * Make Loan Button 
			 */
			JButton checking = new JButton( "Checkings" );
			JButton savings = new JButton( "Savings" );
			JButton loans = new JButton("Loan");
			JPanel panel = new JPanel();
			add(panel);
			panel.add(checking);
			panel.add(savings);
			panel.add(loans);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
			checking.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			       if(current_customer.customer_checking == null) {
			    	   //Customer needs to create 1
			    	   CreateCheckingsUI making_one = new CreateCheckingsUI(current_customer);
			       }
			       else {
			    	   CheckingsUI checking_in_use = new CheckingsUI(current_customer.customer_checking); //pass in that info
			       }
			    }
			});
			
			savings.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			       if(current_customer.customer_saving == null) {
			    	   //Customer needs to create 1
			    	   CreateSavingsUI making_one = new CreateSavingsUI(current_customer);
			       }
			       else {
			    	   SavingsUI checking_in_use = new SavingsUI(current_customer.customer_saving); //pass in that info
			       }
			    }
			});
		
		}
	}
	
	public class CreateCheckingsUI extends JFrame{
		//Creates a checkings account popup
		public CreateCheckingsUI(Customer info) {
			
		}
	}
	
	public class CreateSavingsUI extends JFrame{
		//Creates a savings account popup
		public CreateSavingsUI(Customer info) {
			
		}
	}
	
	public class SavingsUI extends JFrame{
		//if they have savings
		public SavingsUI(SavingAccount info) {
			
		}
	}
	
	public class CheckingsUI extends JFrame{
		//if they have checkings
		public CheckingsUI(CheckingAccount info) {
			
		}
	}
			
	public CustomerUI() {
		JButton btn_login = new JButton( "Log In" );
		JButton btn_create_user = new JButton( "Create a new account" );
		JPanel panel = new JPanel();
		add(panel);
		
		panel.add(btn_login);
		panel.add(btn_create_user);
		setSize( 800, 800 );
		setLocation( 200, 100 );
		setVisible( true );
		  
		btn_login.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //go to login page?
		    	/*
		    	 * Log in page, should bring them to their own special frame
		    	 * They can create Checkings/Savings
		    	 * Check their Accounts (both saving and checking)
		    	 * Check loan amount/Make loans
		    	 */
		    	LoginPageUI loginpage = new LoginPageUI();
		    }
		});

		
		btn_create_user.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//go  to sign in page
				/*
				 * Do everything above except we need to register the data
				 */
				RegisterPageUI registerpage = new RegisterPageUI();
			}

		});
	}
		
	
}
