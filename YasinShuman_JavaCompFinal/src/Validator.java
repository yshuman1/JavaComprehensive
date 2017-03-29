import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Validator {
	public static int validChoice(Scanner sc, String menu) {
		while (true) {
	  		  System.out.print(menu);
	  		  if (sc.hasNextInt()) {
	  			  int choice = sc.nextInt();
	  			  if (choice >= 1 && choice <= 5) {
	  				  return choice;
	  			  }
	    	  }   
	  		  System.out.println("\nError! Invalid value. Try again.");
	  		  sc.nextLine();
  	  	}
    }

	public static String validFile() {
		String fileName = "";
		try {
			Path textPath = Paths.get("/Users/yasin/Documents/yasinsTextFile.txt");
			File textFile = textPath.toFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
}


