
    import java.util.Scanner;

// BankAccount class to store and manage account balance
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class to handle user interactions
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performWithdraw();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 4);
    }

    private void showMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void performWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: ₹" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: ₹" + account.getBalance());
        } else {
            System.out.println("Deposit failed. Please enter a valid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: ₹" + account.getBalance());
    }
}

// Main class to run the program
public class ATMProgram {
    public static void main(String[] args) {
        // Starting balance for the user
        BankAccount userAccount = new BankAccount(10000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

    

