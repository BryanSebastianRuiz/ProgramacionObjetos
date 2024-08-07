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
        boolean exitProgram = false;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        while (!exitProgram) {
            System.out.println("\nChoose account type:");
            System.out.println("1. Personal Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Business Account");
            System.out.println("4. Exit program");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 4) {
                exitProgram = true;
                continue;
            }

            AbstractAccount account = null;

            try {
                switch (choice) {
                    case 1:
                        System.out.println("\nCreating a Personal Account...");
                        account = new PersonalAccount();
                        break;
                    case 2:
                        System.out.println("\nCreating a Savings Account...");
                        account = new SavingsAccount();
                        break;
                    case 3:
                        System.out.println("\nCreating a Business Account...");
                        account = new BusinessAccount();
                        break;
                    default:
                        System.out.println("Invalid choice, please select a valid option.");
                        continue;
                }

                account.createAccount(name, email, phoneNumber, initialBalance);
                System.out.println("Account created successfully!");
                System.out.println(account);

                boolean exitAccount = false;
                while (!exitAccount) {
                    System.out.println("\nMenu:");
                    System.out.println("1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit to account creation");
                    System.out.print("Enter choice: ");
                    int menuChoice = scanner.nextInt();

                    switch (menuChoice) {
                        case 1:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            try {
                                account.withdraw(withdrawAmount);
                                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                            } catch (AccountException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            System.out.println("Deposit successful. New balance: " + account.getBalance());
                            break;
                        case 3:
                            System.out.println("Current balance: " + account.getBalance());
                            break;
                        case 4:
                            exitAccount = true;
                            break;
                        default:
                            System.out.println("Invalid choice, please select a valid option.");
                    }
                }
            } catch (AccountException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}
