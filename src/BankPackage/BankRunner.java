package BankPackage;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

import java.util.Scanner;

/*
 * BankRunner is our main JFrame interface object
 * Customer and Manager is its own JFrame which we open  depending
 */
			
public class BankRunner extends JFrame{
	static Scanner scan = new Scanner(System.in); //Scanner object

	public BankRunner(Bank bank) { //Create an instance of the Interface
		JButton jbtManager = new JButton( "Manager" );
		JButton jbtCustomer = new JButton( "Customer" );
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.setLayout( new FlowLayout(FlowLayout.CENTER) );
		panel.add( new JLabel( "Welcome to the Bank! Options:" ) );
		panel.add( jbtManager );
		panel.add( jbtCustomer );
		  
		jbtManager.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        Manager manager_window = new Manager(bank); // Main Form to show after the Login Form..
		    }
		});

		jbtCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				CustomerUI customer_window = new CustomerUI();
			}

		});
	}
	
	
  public static void main(String[] args) {
        Bank bank = new Bank();
	  	Bank.Customers.add(new Customer("Ethan",19,12,1997,12,"$"));
	  	Bank.Customers.add(new Customer("Sean",12,12,1222,12,"$"));
	  	Bank.Customers.get(0).Password = "0";
	  //Create a JFrame instance of the BankRunner interface
	    JFrame frame = new BankRunner(bank);	
		// Initialize frame information
		frame.setTitle( "Main Menu" );
		frame.setSize( 800, 800 );
		frame.setLocation( 200, 100 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		// Turn it on
		frame.setVisible( true );
  }
  
  
  public void run() {
	    Boolean exit = true;
	    System.out.println("Welcome Bank Manager!");
	    Bank bank = new Bank();
	    while(exit) {
	      System.out.println("What would you like to do?");
	      System.out.print("Options: 1. Account Management 2. Loans Management 3. Daily Report 4. Exit");
	      //Account Manage (new accounts, existing, deposits)
	      //Loan manage (new loans etc...)
	      //Customer Management (check customers, ATM functionality)
	      int input = scan.nextInt();
	      switch(input) {
	        case 1: 
	        //Account Manage (new accounts, existing, deposits)
	          System.out.println("You have selected Account Management!");
	          System.out.println("What would you like to do?");
	          System.out.print("Options: 1. Check Accounts 2. Add New Account 3. Update Existing Account 4. Exit");
	          Scanner sc = new Scanner(System.in);
	          int in = sc.nextInt();
	          switch(in) {
	            case 1:
	              System.out.println("You have selected Check Accounts!");
	              System.out.println("Do you want to check: 1. All Accounts 2. Specific Account");
	              int n =  sc.nextInt();
	              switch(n) {
	                case 1: 
	                  bank.CheckAllCustomer();
	                  break;
	                case 2:
	                  bank.checkCustomer();
	                  break;
	              }
	              break;
	            case 2:
	              bank.newAccount();
	              break;
	            case 3:
	              bank.updateAccount();
	              break;
	            case 4:
	              break;
	          }
	          break;
	        case 2:
	        //Customer Management (check customers, ATM functionality)
	          System.out.println("You have selected Loans Management!");
	          System.out.println("What would you like to do?");
	          System.out.print("Options: ToDo 4. Exit");
	          Scanner s = new Scanner(System.in);
	          int i = s.nextInt();
	          switch(i) {
	            case 1:
	              break;
	            case 2:
	              break;
	            case 3:
	              break;
	            case 4:
	              break;
	          }
	          break;
	        case 3:
	          System.out.println("You have selected Daily Report!");
	          System.out.println("What would you like to do?");
	          System.out.print("Options: Todo 4. Exit");
	          Scanner y= new Scanner(System.in);
	          int a = y.nextInt();
	          switch(a) {
	            case 1:
	              break;
	            case 2:
	              break;
	            case 3:
	              break;
	            case 4:
	              break;
	          }
	          break;
	        case 4:
	          exit = false;
	          break;
	      }
	    }
  }

}
