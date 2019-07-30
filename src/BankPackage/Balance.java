package BankPackage;

public class Balance {
    float Balance;
    
    public Balance() {
      Balance = 0;
    }
    public Balance(float initial) {
      Balance = initial;
    }
    public void add(float amount) {
      Balance += amount;
    }
    public void subtract(float i) {
      float check = Balance - i;
      if(check <= 0) {
        System.out.println("INVALID ACTION: insufficient balance");
      }else {
        Balance -= i;
      }
    }
    public float checkBalance() {
      return Balance;
    }
}
