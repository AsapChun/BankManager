package BankPackage;

public class Customer { //Every customer has a checking and saving account
	//This is what the customer sees
	Data user_info; //this will contain name, date of birth (not sure  needed)
	CheckingAccount customer_checking;
	SavingAccount customer_saving; //will not be initialzied  in constructor, only in button
	Loans customer_loan;
	boolean collateral;
	String Currency;
	
	public Customer(String name, int day, int month, int year, int age, String curr) {
		this.user_info = new Data(name, day, month, year, age);
		//we should ask for collateral info?
		create_checking();
		create_saving();
		Currency =  curr;
	}
	
	public void create_checking() {
		this.customer_checking = new CheckingAccount();
	}
	public void add_checking(int inital) {
	  this.customer_checking.deposit(inital);;
	}
	
	public void create_saving() {
		this.customer_saving = new SavingAccount(this.user_info);
	}
	public void add_saving(int inital) {
      this.customer_saving.deposit(inital);
    }
	
	public void takeLoans() {
		//ask user whether they want to take from checking or saving
		
		//First checks for collateral
		
		//if checking TO DO:
		
		//if savings TO DO:
		
	}
	public String getName() {
	  return this.user_info.getCustomer_name();
	}
	
	public void printInformation() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("Account Name: "+ user_info.getCustomer_name() + "\n");
	  sb.append("Customer's DOB: "+ user_info.birth_month + "/" + user_info.birth_day + "/" + user_info.birth_year + "\n");
	  sb.append("Cusomter's age: "+ user_info.age + "\n");
	  sb.append("Checking Account Balance: "+ Currency + customer_checking.getBalance() + "\n");
	  sb.append("Saving Account Balance: "+ Currency + customer_saving.getBalance() + "\n");
	  //Todo
	  sb.append("Existing Loans on File: (TODO need to add)");
	  System.out.println(sb);
	}
	
	  //take out loans if (they have collateral).
	  //must have money in checkings or savings
	  public boolean checkColl(Customer c) {
	    if(c.customer_checking.getBalance() > 0 || c.customer_saving.getBalance() > 0) {
	      return true;
	    }else {
	      return false;
	    }
	  }
	
	
}
