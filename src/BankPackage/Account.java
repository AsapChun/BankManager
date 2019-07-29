package BankPackage;

public abstract class Account {
  
	//Withdraw
	public abstract void withdraw(int amount);
	
	//Deposit
	public abstract void deposit(int amount);
	
	//Check  amount in Balance or CurrentBalance
	public abstract void check();
	
	//pay current balance
	public abstract void pay(int amount);
	
}
