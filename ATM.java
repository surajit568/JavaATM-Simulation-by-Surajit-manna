import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    // User account information
    private int pin;
    private double balance;
    private List<String> transactionHistory;

    // Constructor to initialize account information
    public ATM(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to authenticate user PIN
    private boolean authenticatePin(int inputPin) {
        return inputPin == this.pin;
    }

    // Method to display account balance
    public void displayBalance() {
        System.out.println("Your account balance is: " + String.format("%.2f", balance));
    }

    // Method to withdraw cash
    public void withdrawCash(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            this.balance -= amount;
            this.transactionHistory.add("Withdrawal of " + String.format("%.2f", amount));
            System.out.println("Withdrawal successful. Your new balance is: " + String.format("%.2f", balance));
        }
    }

    // Method to deposit cash
    public void depositCash(double amount) {
        this.balance += amount;
        this.transactionHistory.add("Deposit of " + String.format("%.2f", amount));
        System.out.println("Deposit successful. Your new balance is: " + String.format("%.2f", balance));
    }

    // Method to change PIN
    public void changePin(int oldPin, int newPin) {
        if (authenticatePin(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid old PIN. PIN change failed.");
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : this.transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main method to simulate ATM machine
    public static void main(String[] args) {
        ATM atm = new ATM(1234, 10000.00); // Initialize ATM with PIN 1234 and balance 10000.00

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to ATM Machine Simulation!");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. PIN Change");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your PIN: ");
                    int pin = scanner.nextInt();
                    if (atm.authenticatePin(pin)) {
                        atm.displayBalance();
                    } else {
                        System.out.println("Invalid PIN. Access denied.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your PIN: ");
                    pin = scanner.nextInt();
                    if (atm.authenticatePin(pin)) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = scanner.nextDouble();
                        atm.withdrawCash(amount);
                    } else {
                        System.out.println("Invalid PIN. Access denied.");
                    }
                    break;
                case 3:
                    System.out.print("Enter your PIN: ");
                    pin = scanner.nextInt();
                    if (atm.authenticatePin(pin)) {
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        atm.depositCash(amount);
                    } else {
                        System.out.println("Invalid PIN. Access denied.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your old PIN: ");
                    int oldPin = scanner.nextInt();
                    System.out.print("Enter your new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePin(oldPin, newPin);
                    break;
                case 5:
                    System.out.print("Enter your PIN: ");
                    pin = scanner.nextInt();
                    if (atm.authenticatePin(pin)) {
                        atm.displayTransactionHistory();
                    } else {
                        System.out.println("Invalid PIN. Access denied.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting ATM Machine Simulation. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}