import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {
    public String accountHolder;
    private double balance;
    private final String pin;
    public BankApplication(String name, double initialAmount, String pin) {
        this.balance = initialAmount;
        this.pin = pin;
        this.accountHolder = name;
    }
    public boolean verifyPIN(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs. " + amount + " has been deposited successfully");
        } else {
            System.out.println("Invalid Deposit amount");
        }
    }
    public void withdraw(double withdraw) {
        if (withdraw > 0 && withdraw <= balance) {
            balance -= withdraw;
            System.out.println("Rs. " + withdraw + " has been successfully withdrawn");
        } else {
            System.out.println("Insufficient Bank Balance");
        }
    }
    public void checkBalance() {
        System.out.println("Current Bank Balance: " + balance + " INR");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter account holder name: ");
            String name = sc.nextLine();
            System.out.print("Set your 4-Digit PIN: ");
            String pin = sc.nextLine();

            BankApplication account = new BankApplication(name, 0, pin);


            int attempts = 3;
            while (attempts > 0) {
                System.out.print("Enter your 4-Digit PIN: ");
                String enteredPin = sc.nextLine();

                if (account.verifyPIN(enteredPin)) {
                    int choice = 0;
                    do {
                        System.out.println("Welcome, " + name);
                        System.out.println("1. Deposit \n2. Withdraw \n3. Check Balance \n4. Exit");
                        try {
                            System.out.print("Enter choice: ");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter amount to deposit: ");
                                    double deposit = sc.nextDouble();
                                    account.deposit(deposit);
                                    break;
                                case 2:
                                    System.out.println("Enter amount to withdraw: ");
                                    double withdraw = sc.nextDouble();
                                    account.withdraw(withdraw);
                                    break;
                                case 3:
                                    account.checkBalance();
                                    break;
                                case 4:
                                    System.out.println("Thank you for using Bank Application");
                                    break;
                                default:
                                    System.out.println("Invalid Option. Please Try Again");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("An Error Occurred");
                        }
                    } while (choice != 4);
                    break;
                } else {
                    attempts--;
                    System.out.println("Invalid PIN");
                    if (attempts == 0) {
                        System.out.println("Too many wrong attempts, Access Denied");
                    }
                }
            }
        sc.close();
    }
}
