package BankPackage;

public class CheckingAccount extends Account{
	Balance checking_account_balance;
	//Checking acount has its own balance
	
	

	public CheckingAccount() {
		this.checking_account_balance = new Balance(); //these are parts of CheckingAccount
	}
	
	
	@Override
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	

}
