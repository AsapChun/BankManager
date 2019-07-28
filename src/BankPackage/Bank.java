package BankPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {
  ArrayList<Loans> existingLoans = new ArrayList();
  ArrayList<Customer> Customers = new ArrayList();
  ArrayList<Account> Accounts = new ArrayList();
  Report r;
  public Bank() {
    r = new Report();
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
    System.out.println("Do you want to add funds to your Checking Account? (Y/N)");
    String input = scan.next();
    if(input.equals("Y")) {
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
        Customer c = (Customer) iter.next();
        if(c.getName().equals(name)) {
          exists = false;
          c.printInformation();
        }
      }
      if(exists) {
        System.out.println("Customer Does Not Exist!");
      }
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
}

