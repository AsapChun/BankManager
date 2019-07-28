package BankPackage;

import java.util.Scanner;

public class BankRunner {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Boolean exit = false;
    System.out.println("Welcome Bank Manager!");
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
          AccountRunner run = new AccountRunner();
          break;
        case 2:
        //Customer Management (check customers, ATM functionality)
          break;
        case 3:
          break;
        case 4:
          exit = true;
          break;
      }
    }
   
    

  }

}
