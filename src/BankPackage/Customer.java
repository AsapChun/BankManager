package BankPackage;

import java.util.ArrayList;

public class Customer {
	//Private customer attribute
	/* TO DO:
	 * Add Passwords to the class 
	 */
	Data user_info; //this will contain name, date of birth (not sure needed)
	CheckingAccount customer_checking ;
	String Password = "";
	SavingAccount customer_saving ; //will not be initialized  in constructor, only in button
	Loans customer_loan = new Loans();
	boolean collateral = false;
	String Currency; //NEED TO CHANGE
	Bank bank;
	
	public Customer() {
		//Delete later, TESTING THIS MUST NOT EXIST
	}
	
	public Customer(String name, int day, int month, int year, int age, String curr) {
		this.user_info = new Data(name, day, month, year, age);
		//we should ask for collateral info?
		Currency =  curr;
	}
	public void initBank(Bank b) {
	  bank = b;
	}
	public String CustomerSummary(){
	  StringBuilder report = new StringBuilder();
	  report.append("Customer Summary! " + "\n");
	  int age = user_info.age;
	  int dayOfBirth = user_info.birth_day;
	  int monthOfBirth = user_info.birth_month;
	  int yearOfBirth = user_info.birth_year;
	  String name = user_info.customer_name;
	  report.append("Name: " + name+ "; Age: " + age + "; DOB: " + monthOfBirth + "/" + dayOfBirth + "/" + yearOfBirth + "\n");
	  report.append("--------------------------------------------------"+ "\n");
	  report.append(name + "'s Account Summary: " + "\n");
	  if(customer_checking == null) {
	    report.append(name + "'s Checking Account: DOES NOT EXIST!" + "\n");
	  }else {
	    report.append(name + "'s Checking Account: " + "\n");
	    report.append("          - Balance: "+ customer_checking.getBalance() + "\n");
	  }
	  if(customer_saving == null) {
	    report.append(name + "'s Saving Account: DOES NOT EXIST!" + "\n");
	  }else {
	    report.append(name + "'s Saving Account: " + "\n");
        report.append("          - Balance: "+ customer_saving.getBalance() + "\n");
	  }
      report.append(name + "'s Loans: " + "\n");
      report.append("          - Amount: "+ customer_loan.value +"; Interest Rate: " + customer_loan.interest+ "; Length of Loan:  " + customer_loan.lengthOfLoan + "\n");
      report.append("----------------End of Customer Report------------------"+ "\n");
	  
	  return report.toString();
	  
	}
	public void bank_profit(Bank b) {
	  b.earnings.add(5);
	}
	public void create_loan(int total, float Rate, int length) {
	  customer_loan = new Loans(total, Rate, length);
	}
	
	public void create_checking(float initial) {
		this.customer_checking = new CheckingAccount(user_info);
		this.customer_checking.deposit(initial - 5);
	}
	
	public void add_checking(float amount) {
	  this.customer_checking.deposit(amount);;
	}
	
	public void create_saving(float initial) {
		this.customer_saving = new SavingAccount(user_info);
		this.customer_saving.deposit(initial - 5);
	}
	
	public void add_saving(float amount) {
      this.customer_saving.deposit(amount);
    }
	
	public void takeLoans() {
		//ask user whether they want to take from checking or saving
		
		//First checks for collateral
		
		//if checking TO DO:
		
		//if savings TO DO:
		
	}
	
	public String getName() {
	  return this.user_info.customer_name;
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
