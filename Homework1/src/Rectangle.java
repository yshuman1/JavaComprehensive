import java.util.Scanner;
public class Rectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Area and Perimeter Calculator\n");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {	
			System.out.print("Enter length: ");
			double length = sc.nextDouble();
			System.out.print("Enter width: ");
			double width = sc.nextDouble();
			
			double area = length * width;
			System.out.println("Area: " + area);
			double perimeter =  2 * width + 2 * length;
			System.out.println("Perimeter: " + perimeter + "\n\n");
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		}
		sc.close();
	}
}