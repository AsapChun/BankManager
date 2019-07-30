package BankPackage;

import java.util.Iterator;

public class Report {
	//I should have the ability to get a fully daily report or a report that just gives
    //me an update from the last time I ran the repo
  StringBuilder report = new StringBuilder();
  public Report() {
    report.append("Full Daily Report: "+ "\n");
  }
  public void updateReport(String add) {
    
    
  }
  public void resetReport() {
    report = new StringBuilder();
  }
  public void addCustomerReport(Bank b) {
    //Bank Balance
    int BankBalance = b.earnings.checkBalance();
    report.append("Total Bank's earnings: " + BankBalance + "\n");
    Iterator iter = b.Customers.iterator();
    report.append("\n");
    //Customer Report
    report.append("Bank's Customers Report: " + "\n");
    while(iter.hasNext()) {
      Customer c = (Customer) iter.next();
      String name = c.getName();
      int checkingBalance = c.customer_checking.getBalance();
      int savingBalance = c.customer_saving.getBalance();
      String currency = c.Currency;
      report.append(name +"'s Account Details: " + "/n");
      report.append("       Checking Account Balance - " + currency +checkingBalance + "Saving Account Balance - "+ currency + savingBalance);
      report.append("       Current Loan - " + c.customer_loan.value + "; Length of Loan - "+ c.customer_loan.lengthOfLoan + "months; interest rate - "+ c.customer_loan.interest);
    }
  }
  
}
