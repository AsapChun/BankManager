package BankPackage;

public class Customer {
	//This is what the customer sees
	Data user_info; //this will contain name, date of birth (not sure  needed)
	CheckingAccount customer_checking;
	SavingAccount customer_saving; //will not be initialzied  in constructor, only in button
	Loans customer_loan;
	boolean collateral;
	
	public Customer(String name, int day, int month, int year, int age) {
		this.user_info = new Data(name, day, month, year, age);
		//we should ask for collateral info?
	}
	
	public void create_checking() {
		this.customer_checking = new CheckingAccount(this.user_info);
	}
	public void create_checking(int inital) {
	  this.customer_checking = new CheckingAccount(inital, this.user_info);
	}
	
	public void create_saving() {
		this.customer_saving = new SavingAccount(this.user_info);
	}
	public void create_saving(int inital) {
      this.customer_checking = new SavingAccount(inital, this.user_info);
    }
	
	public void takeLoans() {
		//ask user whether they want to take from checking or saving
		
		//First checks for collateral
		
		//if checking TO DO:
		
		//if savings TO DO:
		
		
	}
	
	
}
