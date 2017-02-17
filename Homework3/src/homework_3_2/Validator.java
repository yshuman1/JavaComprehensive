package homework_3_2;

import java.util.Scanner;

public class Validator {
	public static String getString(Scanner sc, String prompt) {
		String d = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.next();
				isValid = true;
			} else {
				System.out.println("Error! Invalid choice. Try again.");
			}
			sc.nextLine();
		}
		return d;
	}	
}
