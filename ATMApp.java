import java.util.Scanner;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        if (initialBalance >= 0) 
        {
            this.balance = initialBalance;
        } 
        else 
        {
            this.balance = 0;
        }
    }

    public double getBalance() 
    {
        return balance;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }
}

class ATM 
{
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() 
    {
        int choice;
        do 
        {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } 
        while (choice != 4);
    }

    private void checkBalance() 
    {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }

    private void deposit() 
    {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) 
        {
            account.deposit(amount);
            System.out.println("Deposit successful! Updated balance: ₹" + account.getBalance());
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() 
    {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful! Updated balance: ₹" + account.getBalance());
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class ATMApp 
{
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(5000); 
        ATM atm = new ATM(account);
        atm.start();
    }
}
