package BankPackage;

public class SavingAccount extends Account {
    private Balance savings_account_balance;
    private Data accountOwner;
    
    public SavingAccount(Data user) {
      this.setSavings_account_balance(new Balance());
      accountOwner = user;
      
    }
    public SavingAccount(int inital, Data user) {
      this.setSavings_account_balance(new Balance(inital));
      accountOwner = user;
    }

	@Override
	public void withdraw(float amount) {
		// TODO Auto-generated method stub
	    getSavings_account_balance().subtract(amount);
		
	}

	@Override
	public void deposit(float amount) {
		// TODO Auto-generated method stub
	    getSavings_account_balance().add(amount);
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
	    System.out.println("Amount currently in Saving Account: " + getSavings_account_balance().checkBalance()); 
	}

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
	    
	    getSavings_account_balance().subtract(amount);
		
	}
	
	public float getAmount() {
	  return getSavings_account_balance().checkBalance();
	}
	
	public float getBalance() {
      return getSavings_account_balance().checkBalance();
    }
	public Balance getSavings_account_balance() {
		return savings_account_balance;
	}
	public void setSavings_account_balance(Balance savings_account_balance) {
		this.savings_account_balance = savings_account_balance;
	}
	

}
