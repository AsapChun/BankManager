package BankPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager extends JFrame{
	
	public Manager() {
		JButton btn_customer_list = new JButton("Customers List");//List all of the Customer
		JButton btn_report = new JButton("Report");
		JButton btn_loan_check = new JButton("Loan Check");
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.add( btn_customer_list );
		panel.add( btn_report );
		panel.add(btn_loan_check);
		
		
		
		setSize( 800, 800 );
		setLocation( 200, 100 );
		setVisible( true );
		
		btn_customer_list.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //List the customers
		    	for(int i = 0; i < Bank.Customers.size(); i++) {
		    		// TODO: add a new JFrame to List all the customers, not sure how this will work
		    		Customer toPrint = Bank.Customers.get(i);
		    		System.out.println(toPrint.user_info);
		    	}
		    	customerListUI customerlist = new  customerListUI();
		    }
		});
		
		btn_report.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //TODO: Create reports JFrame
		    	
		    }
		});
		
		btn_loan_check.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //TODO: Create Loan Jframe
		    	loanCheckerUI loancheck = new  loanCheckerUI();
		    }
		});
		
	}
	
	/*
	 * Additional  JFRAMES 
	 */
	
	public class customerListUI extends JFrame {
		public customerListUI() {
			JPanel panel = new JPanel();
			add(panel);
			/*
			 * Don't even know whether this code works,
			 * Purpose: adds a button to Jframe for every customer in our databse
			 */
			for(int i = 0; i < Bank.Customers.size(); i++) {
				panel.add(new JButton((i+1) + Bank.Customers.get(i).getName()));
			}
			
			for(int i = 0; i < panel.getComponentCount();i++) {
				JButton toMod = (JButton) panel.getComponent(i);
				toMod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Show info
					}
				});
			}
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
			
		}
	}
	
	/*
	 * TODO: Add some stuff
	 */
	
	public class reportUI extends JFrame{
		public reportUI() {
			JPanel panel = new JPanel();
			add(panel);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
		}
	}
	
	public class loanCheckerUI extends JFrame{
		public loanCheckerUI() {
			JPanel panel = new JPanel();
			add(panel);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
		}
	}
	
	public class customerInfo extends JFrame{
		//Call for individuals customer info
		public customerInfo() {
			JPanel panel = new JPanel();
			add(panel);
			setSize( 800, 800 );
			setLocation( 200, 100 );
			setVisible( true );
		}
	}
	
	

}
