package BankPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {
  public static ArrayList<Loans> existingLoans = new ArrayList();
  public static ArrayList<Customer> Customers = new ArrayList();
  Balance earnings;
  /*
   * Removed  Account since that should be in Customers class
   * We can  access them through Customer, in that way we also provide information about the id
   * Also added public + static keywords so it can be accesssed by Manager
   * 
   * TODO:
   * makesure when Customer is created no duplicate  exist
   */
  
  Report report;
  
  
  public Bank() {
    report = new Report();
    earnings = new Balance();
  }
  
  public static boolean findCustomer(String name, String password) {
	  for(int i =0; i < Customers.size() ; i++) {
		  if(Customers.get(i).getName().equals(name) & Customers.get(i).Password.equals(password)) {
			  return true;
		  }
	  }
	  return false;
  }
  
  public static Customer retrieveCustomer(String name, String password) {
	  for(int i =0; i < Customers.size() ; i++) {
		  if(Customers.get(i).getName().equals(name) & Customers.get(i).Password.equals(password)) {
			  return Customers.get(i);
		  }
	  }
	  return null; //Note: Remember to remove/change blah blah blah	  
  }
  public String CreateReport() {
    //Bank Balance
    report.resetReport();
    float BankBalance = earnings.checkBalance();
    report.dailyReport.append("Total Bank's earnings: " + BankBalance + "\n");
    Iterator iter = Customers.iterator();
    report.dailyReport.append("----------------------------------------");
    Boolean checkCustomer = true;
    //Customer Report
    report.dailyReport.append("Bank's Customers Report: " + "\n");
    while(iter.hasNext()) {
      checkCustomer = false;
      Customer c = (Customer) iter.next();
      String name = c.getName();
      float checkingBalance = c.customer_checking.getBalance();
      float savingBalance = c.customer_saving.getBalance();
      String currency = c.Currency;
      report.dailyReport.append("*" + name +"'s Account Details: *" + "/n");
      report.dailyReport.append("       Checking Account Balance - " + currency + checkingBalance  + "Saving Account Balance - "+ currency + savingBalance);
      report.dailyReport.append("       Current Loan - " + c.customer_loan.value + "; Length of Loan - "+ c.customer_loan.lengthOfLoan + "months; interest rate - "+ c.customer_loan.interest);
      report.dailyReport.append("----------------------------------------");
    }
    if(checkCustomer) {
      report.dailyReport.append("No Customer Accounts on file!");
    } 
    return report.dailyReport.toString();
  }
  public String getReport() {
    String report = CreateReport();
    return report;
  }
  
  //print exisitng stuff TODO
  public void checkLoans() {
    Iterator iter = existingLoans.iterator();
    while(iter.hasNext()) {
      System.out.println((String) iter.next().toString());
    }
    
    
    
  }
  public void checkAccounts() {
    Iterator iter = existingLoans.iterator();
    while(iter.hasNext()) {
      System.out.println((String) iter.next().toString());
    }
    
  }
  //check all accounts
  public void checkCustomers() {

    Iterator iter = existingLoans.iterator();
    while(iter.hasNext()) {
      System.out.println((String) iter.next().toString());
    }
  }
  //create Accounts
  public void newAccount() {
    System.out.println("To create a new account, please enter the necessary information!");
    Scanner scan = new Scanner(System.in);
    System.out.println("Name?");
    String name = scan.next();
    System.out.println("Day of Birth?");
    int day = scan.nextInt();
    System.out.println("Month of Birth?");
    int month = scan.nextInt();
    System.out.println("Year of Birth?");
    int year = scan.nextInt();
    System.out.println("Age?");
    int age = scan.nextInt();
    System.out.println("Currency choice ($, ¥, €, £, ฿)");
    String currency = scan.next();
    Customer create = new Customer(name, day, month, year, age, currency);
    Customers.add(create);
    System.out.println("Note: The bank will chage a $5 fee for creating a new checking or savings account!");
    System.out.println("Do you want to add funds to your Checking Account? (Y/N)");
    String input = scan.next();
    if(input.equals("Y")) {
      earnings.add(5);
      System.out.println("How much do you want to deposit?");
      int deposit = scan.nextInt();
      if(deposit < 0) {
        System.out.println("Invalid input!");
      }
      else {
        create.add_checking(deposit);
      }
    } else {
      System.out.println("No Checking Account created!");
    }
    System.out.println("Do you want to add funds to your new Saving Account? (Y/N)");
    String in = scan.next();
    if(in.equals("Y")) {
      earnings.add(5);
      System.out.println("How much do you want to deposit?");
      int deposit = scan.nextInt();
      if(deposit < 0) {
        System.out.println("Invalid input!");
      }else {
        create.add_saving(deposit);
      }
    } else {
      System.out.println("No Saving Account created!");
    }
  }
  //Update an exisiting Account
  public void updateAccount() {

    Boolean exist = true;
    System.out.println("You have selected update Account!");
    System.out.println("What is the account holders name?");
    Scanner scan = new Scanner(System.in);
    String name = scan.next();
    Iterator iter = Customers.iterator();
    while(iter.hasNext()) {
      Customer c = (Customer) iter.next();
      if(c.getName().equals(name)) {
        exist = false;
        System.out.println("Which account do you want to access? 1. Checking 2. Savings");
        int choice = scan.nextInt();
        System.out.println("Do you want to: 1. Deposit 2. Withdraw ");
        int select = scan.nextInt();
        System.out.println("How much?");
        int amount = scan.nextInt();
        switch(choice) {
          case 1: //Checking
            switch(select) {
              case 1:// deposit
                c.customer_checking.deposit(amount);
                break;
              case 2: //withdraw
                c.customer_checking.withdraw(amount);
                break;
            }
            break;
          case 2: //Saving
            switch(choice) {
              case 1:
                c.customer_saving.deposit(amount);
                break;
              case 2:
                c.customer_saving.withdraw(amount);
                break;
            }
            break;
        }
      }
    }
    if(exist) {
      System.out.println("Account does not exist!");
    }
  }
  //Check a individual Account
  public void checkCustomer() {
    if(Customers.isEmpty()) {
      System.out.println("No customers in file");
    }else {
      Boolean exists = true;
      System.out.println("Which customer do you want to check? Please enter account name!");
      Scanner scan = new Scanner(System.in);
      String name = scan.next();
      Iterator iter = Customers.iterator();
      while(iter.hasNext()) {
        Customer current_customer = (Customer) iter.next();
        if(current_customer.getName().equals(name)) {
          exists = false;
          current_customer.printInformation();
        }
      }
      if(exists) {
        System.out.println("Customer Does Not Exist!");
      }
    }
  }
  // withdraw
  public void withdrawAccount() {
    System.out.println("You have selected to withdraw from a Customer's account!");
    System.out.println("Note: The bank will chage a $5 fee for withdrawing from a account!");
    System.out.println("Do you wish to proceed? (Y/N)");
    Scanner scan = new Scanner(System.in);
    String input = scan.next();
    if (input.equals("Y")) {
      System.out.println("What is the name of the account?");
      String in = scan.next();
      System.out.println("Which account do you want to withdraw from? 1. Checking 2. Savings");
      int choice =  scan.nextInt();
      System.out.println("How much do you want to withdraw?");
      int amount = scan.nextInt();
      Iterator iter = Customers.iterator();
      Boolean Notfound = true;
      while(iter.hasNext()) {
        Customer it = (Customer) iter.next();
        if(it.getName().equals(in)) {
          if(choice == 1) { //checking
            it.customer_checking.checking_account_balance.subtract(amount);
            System.out.println(amount + " has been withdrawn!");
          }else { //saving
            it.customer_saving.savings_account_balance.subtract(amount);
            System.out.println(amount + " has been withdrawn!");
          }
        }   
      }
      if(Notfound) {
        System.out.println("Customer Not Found!");
      }
      
    }else {
      System.out.println("Withdraw process cancelled!");
    }
  }
  //remove Customer account
  public void RemoveCustomer() {
    System.out.println("You have selected to close a Customer's account!");
    System.out.println("Note: The bank will chage a $5 fee for closing a account!");
    System.out.println("Do you wish to proceed? (Y/N)");
    Scanner scan = new Scanner(System.in);
    String input = scan.next();
    if (input.equals("Y")) {
      System.out.println("What is the name of the account?");
      String in = scan.next();
      Iterator iter = Customers.iterator();
      Boolean Notfound = true;
      while(iter.hasNext()) {
        Customer it = (Customer) iter.next();
        if(it.getName().equals(in)) {
          Customers.remove(it);
          earnings.add(5); 
          Notfound = false;
        }   
      }
      if(Notfound) {
        System.out.println("Customer Not Found!");
      }
    }
    else {
      System.out.println("Closure process cancelled!");
    }
  }
  //print all customers
  public void CheckAllCustomer() {
    if(Customers.isEmpty()) {
      System.out.println("No customers in file");
    }else {
      StringBuilder sb = new StringBuilder();
      Iterator iter = Customers.iterator();
      while(iter.hasNext()) {
        Customer c = (Customer) iter.next();
        String name = c.getName();
        sb.append("Account Name: "+ name + "Age: "+ c.user_info.age + "\n");
        sb.append("Checking Account Balance: "+ c.Currency + c.customer_checking.getBalance() + "; Saving Account Balance: " + c.Currency+ c.customer_saving.getBalance() + "\n");
        sb.append("-----------------" + "\n"); 
      }
      System.out.println(sb);
    }
  }
  //create a new Loan
  public void addLoans(){
    System.out.println("You have selected to create a new Loan!");
    System.out.println("Note: There is a $5 fee for creating a new loan!");
    System.out.println("Do you wish to proceed? (Y/N)");
    Scanner scan = new Scanner(System.in);
    String input = scan.next();
    if (input.equals("Y")) {
      System.out.println("What is the name of the account?");
      String in = scan.next();
      Iterator iter = Customers.iterator();
      Customer x;
      float interest = 0;
      int length = 0;
      Boolean Notfound = true;
      while(iter.hasNext()) {
        Customer it = (Customer) iter.next();
        x= it;
        if(it.getName().equals(in)) {
          Notfound = false;
          System.out.println("Options for length of loan: 1. 3 month (0.05%) 2. 6 month (0.1%) 3. 6 month (0.15%)");
          int add = scan.nextInt();
          switch(add) {
            case(1):
              interest = (float) 0.05;
              length = 3;
              break;
            case(2):
              interest = (float) 0.1;
              length = 6;
              break;
            case(3):
              interest = (float) 0.15;
              length = 12;
              break;
          }
          System.out.println("Enter the value of loan that you wish: ");
          int value = scan.nextInt();
          earnings.add(5);
          it.create_loan(value, interest, length);
          System.out.println("Do you want to add loan to your: 1. Checking 2. Saving ");
          int choice = scan.nextInt();
          switch(choice) {
            case 1:
              x.add_checking(value);
              break;
            case 2:
              x.add_saving(value);
              break;
          }
          }   
      }
      if(Notfound) {
        System.out.println("Customer Not Found!");
      }
    }else {
      System.out.println("Loan process cancelled!");
    }
    
  }
}
  


