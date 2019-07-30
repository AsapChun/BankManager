package BankPackage;

public class SavingAccount extends Account {
    Balance savings_account_balance;
    Data accountOwner;
    
    public SavingAccount(Data user) {
      this.savings_account_balance =  new Balance();
      accountOwner = user;
      
    }
    public SavingAccount(int inital, Data user) {
      this.savings_account_balance =  new Balance(inital);
      accountOwner = user;
    }

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
	    savings_account_balance.subtract(amount);
		
	}

	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub
	    savings_account_balance.add(amount);
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
	    System.out.println("Amount currently in Saving Account: " + savings_account_balance.checkBalance()); 
	}

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
	    
	    savings_account_balance.subtract(amount);
		
	}
	
	public float getAmount() {
	  return savings_account_balance.checkBalance();
	}
	
	public float getBalance() {
      return savings_account_balance.checkBalance();
    }
	

}
