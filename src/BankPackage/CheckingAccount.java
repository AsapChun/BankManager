package BankPackage;

public class CheckingAccount extends Account{
	private Balance checking_account_balance;
	private Data accountOwner;
	//Checking account has its own balance
	

	public CheckingAccount(Data user_info) {
		this.accountOwner = user_info;
		this.setChecking_account_balance(new Balance()); //initialized to 0
		
	}
	public CheckingAccount(Data user_info, int inital) {
		this.accountOwner = user_info;
		this.setChecking_account_balance(new Balance(inital)); //these are parts of CheckingAccount
  }
  
	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
	  getChecking_account_balance().subtract(amount);
		
	}

	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub
	  getChecking_account_balance().add(amount);
	}
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
	  getChecking_account_balance().subtract(amount);
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
	  System.out.println("Amount currently in Checking Account: " + getChecking_account_balance().checkBalance()); 
	}
	
	public float getBalance() {
	  return getChecking_account_balance().checkBalance();
	}
	public Balance getChecking_account_balance() {
		return checking_account_balance;
	}
	public void setChecking_account_balance(Balance checking_account_balance) {
		this.checking_account_balance = checking_account_balance;
	}
	

}
