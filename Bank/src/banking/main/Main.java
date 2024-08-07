package banking.main;

import banking.abstracts.AbstractAccount;
import banking.exceptions.AccountException;
import banking.implementations.PersonalAccount;
import banking.implementations.SavingsAccount;
import banking.implementations.BusinessAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        System.out.println("Choose account type:");
        System.out.println("1. Personal Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Business Account");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        AbstractAccount account = null;

        try {
            switch (choice) {
                case 1:
                    System.out.println("Creating a Personal Account");
                    account = new PersonalAccount();
                    break;
                case 2:
                    System.out.println("Creating a Savings Account");
                    account = new SavingsAccount();
                    break;
                case 3:
                    System.out.println("Creating a Business Account");
                    account = new BusinessAccount();
                    break;
                default:
                    System.out.println("Invalid choice, please run the program again and select a valid option");
                    return;
            }

            account.createAccount(name, email, phoneNumber, initialBalance);
            System.out.println("Account created successfully!");
            System.out.println(account);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1) Withdraw");
                System.out.println("2) Deposit");
                System.out.println("3) Check Balance");
                System.out.println("4) Exit");
                System.out.print("Enter choice: ");
                int menuChoice = scanner.nextInt();

                switch (menuChoice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            account.withdraw(withdrawAmount);
                            System.out.println("Withdrawal successful");
                            System.out.println("New balance: " + account.getBalance());
                        } catch (AccountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful");
                        System.out.println("New balance: " + account.getBalance());
                        break;
                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, please select a valid option.");
                }
            }
        } catch (AccountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
