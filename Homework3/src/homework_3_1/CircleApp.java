package homework_3_1;
import java.util.Scanner;

public class CircleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		System.out.println("Welcome to the Circle Tester\n");
		while (choice.equalsIgnoreCase("y")) {
			double radius = Validator.getDouble(sc, "Enter radius: ");
			Circle cir = new Circle(radius);
			System.out.println("Circumference: " + cir.getFormattedCircumference());
			System.out.println("Area: " + cir.getFormattedArea());
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
		}
		System.out.println("Goodbye. You created " + Circle.getObjectCount() + " Circle object(s).");
	}
}
