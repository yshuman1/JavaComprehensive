import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author yasin
 *This is the main class of the banking application
 */
public class AccountApplication {
	/**
	 * cash is an object of the NumberFormat class that 
	 * converts any double into currency format using format method.
	 */
	public static NumberFormat cash = NumberFormat.getCurrencyInstance();
	/**
	 * prompts user to choose between 1 of their 2 accounts.
	 * prompts user to choose between 1 of 2 possible transaction types.
	 * prompts user for the amount of money to be used in the respective transaction. 
	 * prompts user if they want to do another transaction. 
	 * if and when the user selects to not continue final balances will be displayed as well
	 * as any fees or interest earned on the accounts.
	 * 
	 * @param args is the default parameter of the main method. 
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		double amount;
		Savings s = new Savings();
		Checking c = new Checking();
		
		System.out.println("Welcome to the Account application\n\n" +
				"Starting Balances\nChecking: " + cash.format(s.balance) + 
				"\nSavings: " + cash.format(c.balance));
		System.out.println("\nEnter the transactions for this month\n");
		
		while (choice.equalsIgnoreCase("y")) {
			String trans = Validator.getChoiceString(sc, "\nWithdrawal or deposit? (w/d): " , "w", "d");
			String accountType = Validator.getChoiceString(sc, "Checking or savings? (c/s): " , "c", "s");
			
			amount = Validator.validateAmount(sc, "Amount?: ", 0.01);
			try {
				if (accountType.equalsIgnoreCase("c")) {
					c.transact(trans, amount);	
				} else {
					s.transact(trans, amount);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			sc.nextLine();
		}
		displayOnExit(s,c); 
	}
	/**
	 * method used to display information regarding the interest earned or fees charged to 
	 * the accounts.
	 *  also displays the final balances of both accounts.
	 * 
	 * @param s is a savings account
	 * @param c is a checking account
	 */
	public static void displayOnExit(Savings s, Checking c) {
		System.out.println("\nMonthly Payments and Fees\n" +
				"Checking fees:\t\t   " + cash.format(c.FEES) + 
				"\nSavings interest payment:  " + cash.format(s.calcInterest()) + 
				"\n\nFinal Balances\nChecking: " + cash.format(c.balance - c.FEES) + "\n" +
				"Savings:  " + cash.format(s.balance + s.calcInterest()));
	}
}


