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
		
		btn_customer_list.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		        //List the customers
		    	for(int i = 0; i < Bank.Customers.size(); i++) {
		    		// TODO: add a new JFrame to List all the customers, not sure how this will work
		    		Customer toPrint = Bank.Customers.get(i);
		    		System.out.println(toPrint.user_info);
		    	}
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
		    }
		});
		
		setSize( 800, 800 );
		setLocation( 200, 100 );
		setVisible( true );
	}

}
