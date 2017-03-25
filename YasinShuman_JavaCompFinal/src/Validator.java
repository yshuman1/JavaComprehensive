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
}


