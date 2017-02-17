import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		System.out.println("Welcome to the Travel Time Calculator\n");
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles: ");
			double miles = sc.nextDouble();
			System.out.print("Enter miles per hour: ");
			double speed = sc.nextDouble();
			int hours = (int) miles / (int) speed;
			int minutes = (int) miles % (int) speed;
			System.out.println("Estimated travel time\n" + "Hours: " + hours + "\n" + "Minutes: " + minutes + "\n");
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		}
		sc.close();
	}
}
