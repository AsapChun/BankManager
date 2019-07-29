package BankPackage;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CustomerUI extends JFrame { //Every customer has a checking and saving account
	//totalCustomer will be used to create reports
	Scanner scan = new Scanner(System.in);
	
	public class RegisterPage extends JFrame{
		public RegisterPage() {
			/*
			 * Make another JFrame
			 */
		}
	}
	
	public class LoginPage extends JFrame{
		public LoginPage() {
			/*
			 * Ask for user info and bring them to their respective page
			 */
		}
	}
	
		
	public CustomerUI() {
		//TO DO:
		JButton btn_login = new JButton( "Log In" );
		JButton btn_create_user = new JButton( "Create a new account" );
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.add(btn_login);
		panel.add(btn_create_user);
		  
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
		    }
		});

		
		btn_create_user.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//go  to sign in page
				/*
				 * Do everything above except we neeed to register the data
				 */
			}

		});
	}
		
	
}
