import java.util.Scanner;

public class Validator {
	      public static String getRequiredString(Scanner sc, String prompt) {
	             String s = "";
	             boolean isValid = false;
	             while (isValid == false)
	             {
	                   System.out.print(prompt);
	                   s = sc.nextLine();
	                   if (s.equals(""))
	                   {
	                         System.out.println("Error! This entry is required. Try again.");
	                   }
	                   else
	                   {
	                          isValid = true;
	                   }
	             }
	                   return s;
	      }
	      // add another new method that forces the user to enter one of two string
	      public static String getChoiceString(Scanner sc, String prompt, String s1, String s2) {
	             String s = "";
	             boolean isValid = false;
	             while (isValid == false)
	             {
	                   s = getRequiredString(sc, prompt);
	                   if (
	                                !s.equalsIgnoreCase(s1) &&
	                                !s.equalsIgnoreCase(s2)
	                          )
	                   {
	                         System.out.println("Error! Entry must be '"+ s1 +"' or '"+ s2 +"'. Try again.");
	                   }
	                   else
	                   {
	                          isValid = true;
	                   }
	             }
	             return s;
	      }
	      public static double validateAmount(Scanner sc, String prompt) {
	    	  while (true) {
	    		  System.out.print(prompt);
	    		  if (sc.hasNextDouble()) {
	    			  return sc.nextDouble();
	      		  }   
	    		  System.out.println("Error! Invalid value. Try again.");
	    		  sc.nextLine();
	    	  }
	      }
	      public static double validateAmount(Scanner sc, String prompt, double min) {
	    	  while (true) {
	    		  double d = validateAmount(sc, prompt);
	    		  if (d >= min) {
	    			  return d;
	    		  } 
	    		  System.out.println("Error! Amount must be greater than " + min + ".");
	    	  }
	      }
}
