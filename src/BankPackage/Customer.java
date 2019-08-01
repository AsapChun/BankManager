package BankPackage;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private Data user_info;
	private CheckingAccount customer_checking ;
	private String Password = "";
	private SavingAccount customer_saving;
	private ArrayList<Loans> customer_loan = new ArrayList<Loans>();
	private boolean collateral = false;
	private String Currency; 
	
	
	public Customer(String name, int day, int month, int year, int age, String curr) {
		this.setUser_info(new Data(name, day, month, year, age));
		setCurrency(curr);
	}
	
	public String CustomerSummary(){
	  StringBuilder report = new StringBuilder();
	  report.append("Customer Summary! " + "\n");
	  int age = getUser_info().age;
	  int dayOfBirth = getUser_info().birth_day;
	  int monthOfBirth = getUser_info().birth_month;
	  int yearOfBirth = getUser_info().birth_year;
	  String name = getUser_info().customer_name;
	  report.append("Name: " + name+ "; Age: " + age + "; DOB: " + monthOfBirth + "/" + dayOfBirth + "/" + yearOfBirth + "\n");
	  report.append("--------------------------------------------------"+ "\n");
	  report.append(name + "'s Account Summary: " + "\n");
	  if(getCustomer_checking() == null) {
	    report.append(name + "'s Checking Account: DOES NOT EXIST!" + "\n");
	  }else {
	    report.append(name + "'s Checking Account: " + "\n");
	    report.append("          - Balance: "+ getCustomer_checking().getBalance() + "\n");
	  }
	  if(getCustomer_saving() == null) {
	    report.append(name + "'s Saving Account: DOES NOT EXIST!" + "\n");
	  }else {
	    report.append(name + "'s Saving Account: " + "\n");
        report.append("          - Balance: "+ getCustomer_saving().getBalance() + "\n");
	  }
	  Iterator iter = getCustomer_loan().iterator();
	  Boolean check = true;
	  report.append(name + "'s Loans: " + "\n");
	  int count = 1;
	  while(iter.hasNext()) {
	    report.append("Loan "+count + "\n");
	    Loans x = (Loans) iter.next();
	    report.append("          - Amount: "+ x.getValue() +"; Interest Rate: " + x.getInterest()+ "; Length of Loan:  " + x.getLengthOfLoan() + "\n");
	    report.append("          - Total Repayment - " + getCurrency() + x.totalRepayment()+ "\n");
	    count ++;
	  }
	  if(check) {
	    report.append("          - No Loans on File!"+ "\n");
	  }
      
      report.append("----------------End of Customer Report------------------"+ "\n");
	  
	  return report.toString();
	  
	}


	public void create_loan(int total, float Rate, int length) {
	  Loans new_loan = new Loans(total, Rate, length);
	  this.getCustomer_loan().add(new_loan); //add to array list of loans
	}
	
	public void addLoan(Loans a) {
		this.getCustomer_loan().add(a);
	}
	
	public void create_checking(float initial) {
		this.setCustomer_checking(new CheckingAccount(getUser_info()));
		this.getCustomer_checking().deposit(initial - 5);
		Bank.earnings.add(5);
	}
	
	public void add_checking(float amount) {
	  this.getCustomer_checking().deposit(amount);;
	}
	
	public void create_saving(float initial) {
		this.setCustomer_saving(new SavingAccount(getUser_info()));
		this.getCustomer_saving().deposit(initial - 5);
		Bank.earnings.add(5);
	}
	
	public void add_saving(float amount) {
      this.getCustomer_saving().deposit(amount);
    }
	
	
	public String getName() {
	  return this.getUser_info().customer_name;
	}
	
	public void printInformation() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("Account Name: "+ getUser_info().getCustomer_name() + "\n");
	  sb.append("Customer's DOB: "+ getUser_info().birth_month + "/" + getUser_info().birth_day + "/" + getUser_info().birth_year + "\n");
	  sb.append("Cusomter's age: "+ getUser_info().age + "\n");
	  sb.append("Checking Account Balance: "+ getCurrency() + getCustomer_checking().getBalance() + "\n");
	  sb.append("Saving Account Balance: "+ getCurrency() + getCustomer_saving().getBalance() + "\n");
	  //Todo
	  sb.append("Existing Loans on File: (TODO need to add)");
	  System.out.println(sb);
	}
	
	  //take out loans if (they have collateral).
	  //must have money in checkings or savings
	  public boolean checkColl(Customer c) {
	    if(c.getCustomer_checking().getBalance() > 0 || c.getCustomer_saving().getBalance() > 0) {
	      return true;
	    }else {
	      return false;
	    }
	  }

	public Data getUser_info() {
		return user_info;
	}

	public void setUser_info(Data user_info) {
		this.user_info = user_info;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public CheckingAccount getCustomer_checking() {
		return customer_checking;
	}

	public void setCustomer_checking(CheckingAccount customer_checking) {
		this.customer_checking = customer_checking;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public SavingAccount getCustomer_saving() {
		return customer_saving;
	}

	public void setCustomer_saving(SavingAccount customer_saving) {
		this.customer_saving = customer_saving;
	}

	public ArrayList<Loans> getCustomer_loan() {
		return customer_loan;
	}

	public void setCustomer_loan(ArrayList<Loans> customer_loan) {
		this.customer_loan = customer_loan;
	}

	public boolean isCollateral() {
		return collateral;
	}

	public void setCollateral(boolean collateral) {
		this.collateral = collateral;
	}
	
	
}
