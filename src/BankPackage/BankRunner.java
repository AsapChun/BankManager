package BankPackage;

import java.util.Scanner;

public class BankRunner {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Boolean exit = true;
    System.out.println("Welcome Bank Manager!");
    Bank bank = new Bank();
    while(exit) {
      System.out.println("What would you like to do?");
      System.out.print("Options: 1. Account Management 2. Loans Management 3. Customer Management 4. Exit");
      //Account Manage (new accounts, existing, deposits)
      //Loan manage (new loans etc...)
      //Customer Management (check customers, ATM functionality)
      Scanner scan = new Scanner(System.in);
      int input = scan.nextInt();
      switch(input) {
        case 1: 
        //Account Manage (new accounts, existing, deposits)
          System.out.println("You have selected Account Management!");
          System.out.println("What would you like to do?");
          System.out.print("Options: 1. Check Accounts 2. Add New Account 3. Update Existing Account 4. Exit");
          Scanner sc = new Scanner(System.in);
          int in = sc.nextInt();
          switch(in) {
            case 1:
              System.out.println("You have selected Check Accounts!");
              System.out.println("Do you want to check: 1. All Accounts 2. Specific Account");
              int n =  sc.nextInt();
              switch(n) {
                case 1: 
                  bank.CheckAllCustomer();
                  break;
                case 2:
                  bank.checkCustomer();
                  break;
              }
              break;
            case 2:
              bank.newAccount();
              break;
            case 3:
              bank.updateAccount();
              break;
            case 4:
              exit = false;
              break;
          }
          break;
        case 2:
        //Customer Management (check customers, ATM functionality)
          System.out.println("You have selected Customer Management!");
          System.out.println("What would you like to do?");
          System.out.print("Options: 1. Check Account 2. Add New Account 3. Update Existing Account 4. Exit");
          Scanner s = new Scanner(System.in);
          int i = s.nextInt();
          switch(i) {
            case 1:
              break;
            case 2:
              break;
            case 3:
              break;
            case 4:
              exit = false;
              break;
          }
          break;
        case 3:
          System.out.println("You have selected Account Management!");
          System.out.println("What would you like to do?");
          System.out.print("Options: 1. Check Accounts 2. Add New Account 3. Update Existing Account 4. Exit");
          Scanner y= new Scanner(System.in);
          int a = y.nextInt();
          switch(a) {
            case 1:
              break;
            case 2:
              break;
            case 3:
              break;
            case 4:
              exit = false;
              break;
          }
          break;
        case 4:
          exit = true;
          break;
      }
    }
   
    

  }

}
