import java.text.NumberFormat;
import java.util.Scanner;

public class AccountApplication {
	public static NumberFormat cash = NumberFormat.getCurrencyInstance();
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
			//System.out.println("Amount?: ");
			//amount = sc.nextDouble();
			
			/*need to make an if else maybe? because the maximum for a withdrawal is different than the max for a deposit*/
			amount = Validator.validateAmount(sc, "Amount?: ", 0.01, 1.00);
			
			if (accountType.equalsIgnoreCase("c")) {
				c.transact(trans, amount);	
			} else {
				s.transact(trans, amount);
			}
			
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			sc.nextLine();
		}
		displayOnExit(s,c); 
	}
	
	public static void displayOnExit(Savings s, Checking c) {
		System.out.println("\nMonthly Payments and Fees\n" +
				"Checking fees:\t\t   " + cash.format(c.FEES) + 
				"\nSavings interest payment:  " + cash.format(s.calcInterest()) + 
				"\n\nFinal Balances\nChecking: " + cash.format(c.balance - c.FEES) + "\n" +
				"Savings:  " + cash.format(s.balance + s.calcInterest()));
	}
}


