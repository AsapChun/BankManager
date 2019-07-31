package BankPackage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class CustomerUI extends JFrame { //Every customer has a checking and saving account
	//totalCustomer will be used to create reports
	Scanner scan = new Scanner(System.in);
	
	/*
	 * --------------------------------Additional JFRAMES --------------------------------------------
	 */
	
	public class RegisterPageUI extends JFrame{
		public RegisterPageUI() {
			/*
			 * Make another JFrame
			 */
			JButton btn_register = new JButton( "Register" );
			
			JSpinner date = new JSpinner();
			JPanel panel = new JPanel();
			add(panel);
			panel.add(date);
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
					 * Use JSpinner
					 */
					
					Customer just_made = new Customer(); //DELETE LATER, MODIFY to fit whatever is typed in
					CustomerHomepageUI registerpage = new CustomerHomepageUI(just_made);
					dispose();
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
				String input_name = text_field_1.getText(); //gets the name
				String password = password_field_1.getText(); //NOTE: Gotta handle null pnter
				if(Bank.findCustomer(input_name,password)) {
					Customer retrieving = Bank.retrieveCustomer(input_name, password);
					//i.e. check Bank.CustomerList if exist -> else -> error
					CustomerHomepageUI home_page = new CustomerHomepageUI(retrieving);
					System.out.println("Found him");
				}
				System.out.println(input_name); //DELETE LATER
				System.out.println(password);
//				dispose();
				//else do nothing
			}
		});
		}
	}
	
	public class CreateCheckingsUI extends JFrame{
		//Creates a checkings account popup
		public CreateCheckingsUI(Customer info) {
			JButton Create_Checkings = new JButton( "Create Checkings" );
			JLabel l1=new JLabel("Creating a Checking Account, please enter amount to deposit");  
			JTextField initial_balance = new JTextField(8);
			l1.setBounds(50,50, 100,30);  
			JPanel panel = new JPanel();
			add(panel);			
			panel.add(l1);
			panel.add(initial_balance);
			panel.add(Create_Checkings);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );  
			
			
			Create_Checkings.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					float amount = Float.parseFloat(initial_balance.getText());
					info.create_checking(amount);
					CheckingsUI checkings = new CheckingsUI(info.customer_checking);
					dispose();
				}
				
			});
			
		}
	}
	
	public class CreateSavingsUI extends JFrame{
		//Creates a savings account popup
			public CreateSavingsUI(Customer info) {
				JButton Create_Savings = new JButton( "Create Savings" );
				JLabel l1=new JLabel("Creating a Savings Account, please enter amount to deposit");  
				JTextField initial_balance = new JTextField(8);
				l1.setBounds(50,50, 100,30);  
				JPanel panel = new JPanel();
				add(panel);			
				panel.add(l1);
				panel.add(initial_balance);
				panel.add(Create_Savings);
				setSize( 800, 800 );
				setLocation( 200, 100 );
				setVisible( true );  
				
				
				Create_Savings.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						float amount = Float.parseFloat(initial_balance.getText());
						info.create_saving(amount);
						SavingsUI checkings = new SavingsUI(info.customer_saving);
						dispose();
					}
					
				});
				
			}
		}
	
	public class SavingsUI extends JFrame{
		//if they have savings
		public SavingsUI(SavingAccount info) {
			
			//use revalidate(); to refresh page
			JTextField deposit_field_1 = new JTextField(8);
			JButton Deposit = new JButton("Deposit");
			JTextField withdraw_field_1 = new JTextField(8);
			JButton Withdraw = new JButton("Withdraw");
			
			JPanel panel = new JPanel();
			add(panel);
			
			JLabel intro = new JLabel("Your current Savings Balance is " + info.getBalance());
			panel.add(intro);
			
			panel.add(deposit_field_1);
			panel.add(Deposit);
			panel.add(withdraw_field_1);
			panel.add(Withdraw);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
			Deposit.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	float amount = Float.parseFloat(deposit_field_1.getText());
			    	info.deposit(amount);
			    	System.out.println(info.getBalance());
			    	intro.setText("Your current Savings Balance is " + info.getBalance());
			    }
			});
			
			Withdraw.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	float amount = Float.parseFloat(deposit_field_1.getText());
			    	info.withdraw(amount);
			    	System.out.println(info.getBalance());
			    	intro.setText("Your current Savings Balance is " + info.getBalance());
			    }
			});
		}
	}
	
	public class CheckingsUI extends JFrame{
		//if they have checkings
		public CheckingsUI(CheckingAccount info) {
			JTextField deposit_field_1 = new JTextField(8);
			JButton Deposit = new JButton("Deposit");
			JTextField withdraw_field_1 = new JTextField(8);
			JButton Withdraw = new JButton("Withdraw");
			
			JPanel panel = new JPanel();
			add(panel);
			
			JLabel intro = new JLabel("Your current Checkings Balance is " + info.getBalance());
			panel.add(intro);
			
			panel.add(deposit_field_1);
			panel.add(Deposit);
			panel.add(withdraw_field_1);
			panel.add(Withdraw);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
			Deposit.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	float amount = Float.parseFloat(deposit_field_1.getText());
			    	info.deposit(amount);
			    	System.out.println(info.getBalance());
			    	intro.setText("Your current Checkings Balance is " + info.getBalance());
			    }
			});
			
			Withdraw.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	float amount = Float.parseFloat(deposit_field_1.getText());
			    	info.withdraw(amount);
			    	System.out.println(info.getBalance());
			    	intro.setText("Your current Savings Balance is " + info.getBalance());
			    }
			});
		}
	}
		
	public class LoansUI extends JFrame{
		public LoansUI(Customer current) {
			JTextField take_field_1 = new JTextField(8);
			JButton TakeLoan = new JButton("Take Loan");
			JTextField repay_field_1 = new JTextField(8);
			JButton Repay = new JButton("Repay Loan");
			
			JPanel panel = new JPanel();
			add(panel);
			
			JLabel intro = new JLabel("Your current Loans is ");
			JLabel can_loan = new JLabel("");
			panel.add(intro);
			
			panel.add(take_field_1);
			panel.add(TakeLoan);
			panel.add(repay_field_1);
			panel.add(Repay);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
		}
	}
	
	/*
	 * ---------------------------------------------IMPORTANT JFRAME---------------------------------------
	 */
	
	public class CustomerHomepageUI extends JFrame{
		public CustomerHomepageUI(Customer current_customer) {
			/*
			 * Inside CustomerUI actual main interface - i.e. has to go through validation or make a new one
			 * TODO: 			 * Make Loan Button 
			 */
			JButton checking = new JButton( "Checkings" );
			JButton savings = new JButton( "Savings" );
			JButton loans = new JButton("Loan");
			JPanel panel = new JPanel();
			add(panel);
			panel.add(checking);
			panel.add(savings);
			panel.add(loans);
			panel.add(new JLabel("Welcome " + current_customer.getName()));
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
			checking.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {
			    	System.out.println(current_customer.customer_checking);
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
			
			loans.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) {	
			    	LoansUI loans = new LoansUI(current_customer);
			    }
			});
			
		
		}
	}
	
	
	/*
	 * --------------------------------MAIN JFRAME --------------------------------------------
	 */
			
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