import java.util.Scanner;

public class AccountApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Savings s = new Savings();
		Checking c = new Checking();
		
		System.out.println("Welcome to the Account application\n\n" +
				"Starting Balances\nChecking: " + s.cash.format(s.balance) + 
				"\nSavings: " + c.cash.format(c.balance));
		System.out.println("\nEnter the transactions for this month\n");
		
		Validator.getChoiceString(sc, "Withdrawal or deposit? (w/d): " , "w", "d");
		
}
	}
