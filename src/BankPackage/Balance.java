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
      int check = Balance - i;
      if(check <= 0) {
        System.out.println("INVALID ACTION: insufficient balance");
      }else {
        Balance -= i;
      }
    }
    public int checkBalance() {
      return Balance;
    }
}
