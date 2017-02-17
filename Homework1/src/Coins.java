import java.util.Scanner;
public class Coins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		System.out.println("Welcome to the Change Calculator\n");
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("Enter number of cents (0-99): ");
			int cents = sc.nextInt();
			int quarters = cents / 25;
			int total = cents - (quarters *25);
			int dimes = total / 10;
			total -= dimes * 10;
			int nickels = total /5;
			total -= nickels * 5;
			int pennies = total / 1;
			System.out.println("\nQuarters: " + quarters +"\n" + "Dimes: " + dimes + "\n" + "Nickels: " + nickels + "\n" + "Pennies: " + pennies);
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
		}
		sc.close();
	}
}
