import java.util.Scanner;

/**
 * simple class that validates all user input
 *
 */
public class Validator {
	      /**
	     *checks user input to ensure was entered 
	     * @param sc the scanner object in this case using the keyboard as input
	     * @param prompt message displayed to prompt user for input
	     * @return if user input is there changes boolean to true, if not will continue prompting user
	     */
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
	      /**
	     *validates user input. to be valid must equal either s1 or s2
	     * @param sc the scanner object in this case using the keyboard as input
	     * @param prompt prompt message displayed to prompt user for input
	     * @param s1 String 
	     * @param s2 String
	     * @return true if user inputs either one of the 2 specified strings
	     */
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
	      /**
	     *validates user input when double is entered 
	     * @param sc the scanner object in this case using the keyboard as input
	     * @param prompt prompt message displayed to prompt user for input
	     * @return true id user inputs a double
	     */
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
	      /**
	     *validates that input is greater than or equal to min
	     * @param sc the scanner object in this case using the keyboard as input
	     * @param prompt prompt message displayed to prompt user for input
	     * @param min minimum amount accepted for user input to be true
	     * @return true when conditions met
	     */
	    public static double validateAmount(Scanner sc, String prompt, double min) {
	    	  while (true) {
	    		  double d = validateAmount(sc, prompt);
	    		  if (d >= min) {
	    			  return d;
	    		  } 
	    		  System.out.println("Error! Deposit must be greater than $" + min + ".");
	    	  }
	      }
}
