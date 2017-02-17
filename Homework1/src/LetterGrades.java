import java.util.Scanner;
public class LetterGrades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Letter Grade Converter\n");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter numerical grade: ");
			int score = 0;
			try {
				score = sc.nextInt();
			} catch (Exception e) {
				System.out.println(e + "\n");
				sc.next();
				continue;
			}
			String grade = "Not Defined";
			if (score >= 88) {
				grade = "A";
			} else if (score >= 80) {
				grade = "B";
			} else if (score >= 67) {
				grade = "C";
			} else if (score >= 60) {
				grade = "D";
			} else {
				grade = "F";
			}
			System.out.println("Letter grade: " + grade + "\n");	
			System.out.print("Continue? (y/n): ");
			choice = sc.next(); 
		}
		sc.close();
	}
}