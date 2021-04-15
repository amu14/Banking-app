import java.util.Scanner;

public class Account {
	int balance;
	int previousTransaction;
	String custName;
	String custID;
	
	Account(String name, String id) {
		custName = name;
		custID = id;
	}
	
	//Deposit money
	void deposit(int amount) {
		if (amount != 0 ) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Withdraw money
	void withdraw(int amount) {
		if (amount != 0 ) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//previousTransaction
	void getPreviousTransaction() {
		if (previousTransaction > 0 ) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0 ) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}
	
	//calculate interest
	void calculateInterest(int years) {
		double interestRate = .042;
		double newBal = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate));
		System.out.println("After " + years + "years, your balance will be: " + newBal);
	}
	
	//main menu
	void showMenu(){
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + custName + "!");
		System.out.println("Your customer ID is: " + custID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check balance");
		System.out.println("B. Deposit money");
		System.out.println("C. Withdraw money");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
				//case A to check balance
				case 'A':
					System.out.println("=======================");
					System.out.println("Balance = " + balance + "DKK");
					System.out.println("=======================");
					System.out.println();
					break;
					
				//case B to deposit money
				case 'B':
					System.out.println("Enter an amount to deposit: ");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println();
					break;
					
				//case C to withdraw money
				case 'C':
					System.out.println("Enter an amount to withdraw: ");
					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println();
					break;
					
				//case D to view previous transaction
				case 'D':
					System.out.println("=======================");
					getPreviousTransaction();
					System.out.println("=======================");
					System.out.println();
					break;
					
				//case E to view accrued interest over a number of years
				case 'E':
					System.out.println("Enter the number of years to calculate interest: ");
					int years = scanner.nextInt();
					calculateInterest(years);
					break;
					
				//case F to exit
				case 'F':
					System.out.println("=======================");
					break;
					
				default:
					System.out.println("Error: invalid option. Please enter from A, B, C, D, E or F.");
					break;
			}
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");	
	}
	
}