package BankPackage;

public class CheckingAccount extends Account{
	Balance checking_account_balance;
	Data accountOwner;
	//Checking acount has its own balance
	

	public CheckingAccount(Data user_info) {
		this.accountOwner = user_info;
		this.checking_account_balance = new Balance(); //initialized to 0
		
	}
	public CheckingAccount(Data user_info, int inital) {
		this.accountOwner = user_info;
		this.checking_account_balance = new Balance(inital); //these are parts of CheckingAccount
  }
  
	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
	  checking_account_balance.subtract(amount);
		
	}

	@Override
	public void deposit(float amount) {
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
	
	public float getBalance() {
	  return checking_account_balance.checkBalance();
	}
	

}
