// import Scanner util

import java.util.Scanner;

// main class to launch the app
public class LaunchApp {
    public static void main (String[] args) {
        MainAccount user1 = new MainAccount("James Amo", "00001");
        user1.displayMenu();
    }
}

// class for the main account

class MainAccount {
    // Instance variables
    int accountBalance;
    int previousTransaction; 

    String firstName;
    String lastName;
    String customerName = firstName + " " + lastName;

    String customerId;
    String pinCode;

    // Constructor
    MainAccount(String username, String userID) {
        customerName = username;
        customerId = userID;
    }


    // Methods
    void displayMenu() {
        char choice = '\0';
        Scanner get = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your user ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transactions");
        System.out.println("E. To Exit");

        do {
            System.out.println("*************************");
            System.out.println("Please Enter an Option");
            System.out.println("*************************");

            choice = get.next().charAt(0);
            System.out.println("..........................");

            switch (choice) {
                case 'A':
                    System.out.println("--------------------");
                    System.out.println("Your balance is " + accountBalance);
                    System.out.println("--------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------");
                    System.out.println("Enter amount to deposit...");
                    int depositAmount = get.nextInt();
                    deposit(depositAmount);
                    System.out.println("--------------------");
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("--------------------");
                    System.out.println("Enter amount to withdraw...");
                    int withdrawAmount = get.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("--------------------");
                    System.out.println("\n");
                    break;

                case 'D':
                System.out.println("--------------------");
                getPreviousTransaction();
                System.out.println("--------------------");
                System.out.println("\n");
                break;

                case 'E':
                    System.out.println("Bye! for now.. come back soon...");
                    break;

                default:
                    System.out.println("Invalid option ... Please try again");
                    break;
            }
        }while (choice != 'E');

        System.out.println("Thanks for using the service");


    }

    void deposit(int amount) {
        if (amount != 0) {
            accountBalance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            accountBalance -= amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + previousTransaction);
        }
        else{
            System.out.println("No transaction occurred");
        }
    }

}