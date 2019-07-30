package BankPackage;

public abstract class Account {

	//Withdraw
	public abstract void withdraw(float amount);
	
	//Deposit
	public abstract void deposit(float amount);
	
	//Check  amount in Balance or CurrentBalance
	public abstract void check();
	
	//pay current balance
	public abstract void pay(int amount);
	
	
	
	
	
}
