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
			//need to take the return so we know which method we will be calling						
			String accountType = Validator.getChoiceString(sc, "Checking or savings? (c/s): " , "c", "s");
			//need to take the return to know which object we are working with
		System.out.println("Amount?: ");
		amount = sc.nextDouble();
			//trying to figure out how to pass over the choice of which account to be using
			/*if (accountType.equalsIgnoreCase("w")) {
					withdrawal(Account, amount);
				}
				*/
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


