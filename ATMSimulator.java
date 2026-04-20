package atm;

public class Transaction {
		
		    public void showMenu() {
		        System.out.println("\n===== ATM MENU =====");
		        System.out.println("1. Check Balance");
		        System.out.println("2. Deposit");
		        System.out.println("3. Withdraw");
		        System.out.println("4. Exit");
		    }
		   }
package atm;

public class Account {
	    private int accountNumber;
	    private int pin;
	    private double balance;

	    public Account(int accountNumber, int pin, double balance) {
	        this.accountNumber = accountNumber;
	        this.pin = pin;
	        this.balance = balance;
	    }

	    public boolean validatePin(int inputPin) {
	        return this.pin == inputPin;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Amount Deposited: " + amount);
	    }

	    public boolean withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdraw Successful: " + amount);
	            return true;
	        } else {
	            System.out.println("Insufficient Balance!");
	            return false;
	        }
	    }
	}
package atm;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create objects
        Account user = new Account(12345, 1111, 5000);
        Transaction t = new Transaction();

        // PIN check
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (!user.validatePin(pin)) {
            System.out.println("Invalid PIN!");
            return;
        }

        int choice;

        do {
            t.showMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: " + user.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    user.deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    user.withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
