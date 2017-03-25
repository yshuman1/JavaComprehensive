import java.util.Scanner;
import java.lang.Thread;
public class MarathonRaceApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "Welcome to the Marathon Race Runner Program\n\n1.  "
				+ "Derby database\n2.  "
				+ "XML file\n3.  "
				+ "Text file\n4.  "
				+ "Default two runners\n5.  "
				+ "Exit\n\n"
				+ "Enter your choice: ";
		//String xmlPrompt = "Enter XML file name: ";
		//String textPrompt = "Enter text file name: ";
		int choice = Validator.validChoice(sc, menu);
		//create second prompt about file name or proceed to getting info
		Thread t2 = new ThreadRunner("Tortouise", 0, 10);
		Thread t3 = new ThreadRunner("Hare", 90, 100);
		t2.start();
		t3.start();
		t2.run();
		
	}
}

