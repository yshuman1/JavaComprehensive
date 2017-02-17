import java.util.Scanner;
public class Temperature {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		System.out.println("Welcome to the Area and Perimeter Calculator\n");
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter degrees in Fahrenheit: ");
			double f = sc.nextDouble();
			double c = (f-32) * 5/9;
			System.out.println("Degrees in Celsius: " + String.format( "%.2f", c ) + "°C" );
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		}
		sc.close();
	}

}
