package BankPackage;

public class Balance {
    int Balance;
    public Balance() {
      Balance = 0;
    }
    public Balance(int initial) {
      Balance = initial;
    }
    public void add(int i) {
      Balance += i;
    }
    public void subtract(int i) {
      Balance -= i;
    }
    public int checkBalance() {
      return Balance;
    }
}
