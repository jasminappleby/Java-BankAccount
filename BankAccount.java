//imports
import java.util.Scanner;

//Class, this will define the structure. 
public class BankAccount { 

  //declare variables in the class before the constructor
  private double balance;

//Constructor, this will initialise the account with an opening balance. 
  public BankAccount(String accountNumber, double openingBalance) {
    //Attributes, these are private instance variables of the class. 
    this.balance = openingBalance;
  }

//Method, this will actually make the withdraw function work. 
  public void withdraw(double amount) {
    //if the current withdrawal amount is more than 0, but less than the total balance
    if(amount > 0 && amount <= balance) {
      //then take the amount away from the balance
      balance -= amount; 
      System.out.println("\nYou have withdrawn: £" + amount + "\nYour updated balance is: £" + balance);
    } else if(amount == 0) {
      //else if you have chosen to remove £0, your total will remain the same
      System.out.println("\nYou cannot remove £" + amount + ", therefore your balance will remain at £" + balance);
    } else if (amount > balance) {
      // else if you try and remove more than you have, you will be told you have not got sufficient funds
        System.out.println("\nYou have insufficient funds, please try again.");
    }
  }

  //Method, this will actually make the deposit function work. 
    public void deposit(double amount) {
        //if deposit amount is over 0
        if(amount > 0) {
        //then add money to balance
        balance += amount; 
        System.out.println("\nYou have deposited: " + amount + "\nYour updated balance is: £" + balance);
        } else {
        //else, you cannot add any funds
        System.out.println("\nYou cannot deposit £" + amount + ", please try again.");
        } 
    }

    //Method to make display balance display... the balance in the console. 
    public void displayBalance() {
        System.out.println("You currently have: £" + balance);
    }

    //Main Method, creates the instance bank account, and can withdraw and display balances from this.
    public static void main(String[] args) {

        System.out.println("Welcome to your bank account, please enter your account number below to continue...");
        
        //scanner allows for user input
        @SuppressWarnings("resource")
        Scanner myScanner = new Scanner(System.in);
        String accountNumber;

        //checks if the account is valid or not
        boolean isValidAccount = false;

        while(!isValidAccount) {

            System.out.println("Account Number: ");

            //reads the user input
            accountNumber = myScanner.nextLine();
            
            //checks if the account number entered matches the account number stored 
            if (accountNumber.equals("12345")) {
                //Confirm account number
                System.out.println("\nAccess to account: " + accountNumber + " has been granted");
                
                //Bank account set up. the two values were set up earlier in the constructor. these are the account number and opening balance
                BankAccount myAccount = new BankAccount("12345", 1250.0);
                
                //show the functions working, you can only access these from the account.
                myAccount.displayBalance();
                myAccount.withdraw(100.02);
                myAccount.deposit(1000.0);

                isValidAccount = true;
            } else {
                System.out.println("Incorrect account number, try again...");
            }
            
        }
    }
}