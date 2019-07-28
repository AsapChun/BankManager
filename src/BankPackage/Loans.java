package BankPackage;

public class Loans {
  int value;
  float interest;
  int lengthOfLoan;
  public Loans(int total, float Rate, int length) {
    value = total;
    interest = Rate;
    lengthOfLoan = length;
  }
  public int getValue() {
    return value;
  }
  public float getInterest() {
    return interest;
  }
  public int getLength() {
    return lengthOfLoan;
  }
  public float totalRepayment() {
    float i = interest + 1;
    float x = value * i;
    return x;
  }

}
