package BankPackage;

public class CheckingAccount extends Account{
	Balance checking_account_balance;
	//Checking acount has its own balance
	Customer accountOwner;
	
	

	public CheckingAccount(Customer owner) {
		this.checking_account_balance = new Balance(); //these are parts of CheckingAccount
		accountOwner = owner;
	}
	public CheckingAccount(int inital, Customer owner) {
      this.checking_account_balance = new Balance(inital); //these are parts of CheckingAccount
      accountOwner = owner;
  }
  
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
	  checking_account_balance.subtract(amount);
		
	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
	  checking_account_balance.add(amount);
	}
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
	  checking_account_balance.subtract(amount);
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
	  System.out.println("Amount currently in Checking Account: " + checking_account_balance.checkBalance()); 
	}
	

}
