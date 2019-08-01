package BankPackage;

public class Loans {
  private int value;
  private float interest;
  private int lengthOfLoan;
  
  public Loans() {
	  value = 0;
	  interest = 0;
	  lengthOfLoan = 0;
  }
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
public int getLengthOfLoan() {
	return lengthOfLoan;
}
public void setLengthOfLoan(int lengthOfLoan) {
	this.lengthOfLoan = lengthOfLoan;
}
public void setValue(int value) {
	this.value = value;
}
public void setInterest(float interest) {
	this.interest = interest;
}

}
