
public class ProceduralDrawBox {
	public static void main(String[] args) {
		
	/* Draw a 10x10 box with stars:
	 
				**********
				*        *
				*        *
				*        *
				*        *
				*        *
				*        *
				*        *
				*        *
				**********
	 */
//I. First attempt
		
		System.out.println("**********");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("*        *");
		System.out.println("**********");

//II. Second attempt.  Let us improve using loops
		//Draw the first line
		System.out.println("**********");
		//Repeat following (10-2) times
		//System.out.println("*        *");
		int i;  // declare the variable;
		i= 0;   //initialize to zero
		while (i < 10-2) {
			System.out.println("*        *");
			i++;
		}
		//Draw the last line
		System.out.println("**********");
		
//III. Third attempt
		//can we use loop to draw 10 stars instead of following line 
		//System.out.println("**********");
		
		i = 0; //i is already defined
		while (i < 10) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();
		
		//print 10-2 of these lines
		i = 0;
		while (i < 10-2) {
			System.out.println("*        *");
			i++;
		}

		//Unfortunately we need to repeat the code to draw last line
		i = 0; //i is already defined
		while (i < 10) {
			System.out.print("*");
			i++;
		}

		//We need another println if there are more printing
		System.out.println();

//IV. Can we improve this line, because it has 8 spaces between stars?
		//System.out.println("*        *");
		
		//We could use nested loops to draw 8 spaces "       ";

		i = 0; //i is already defined
		while (i < 10) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();
		
		//print 10-2 of these lines
		i = 0;
		while (i < 10-2) {
			System.out.print("*");
			int j = 0;
			while (j < 10-2) {
				System.out.print(" ");
				j++;
			}
			System.out.println("*");
			i++;
		}

		//Unfortunately we need to repeat the code to draw last line
		i = 0; //i is already defined
		while (i < 10) {
			System.out.print("*");
			i++;
		}
		
		System.out.println();

//V. Ultimate improvement in drawing 10X10 box
		//Let us define two integer constants for height and width
		final int HEIGHT = 10;
		final int WIDTH = 10;
		
		//now instead of 10 for height and 10 for width in the code
		//let us use HEIGHT and WIDTH;

		i = 0; //i is already defined
		while (i < WIDTH) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();
		
		//print 10-2 of these lines
		i = 0;
		while (i < HEIGHT-2) {
			System.out.print("*");
			int j = 0;
			while (j < WIDTH-2) {
				System.out.print(" ");
				j++;
			}
			System.out.println("*");
			i++;
		}

		//Unfortunately we need to repeat the code to draw last line
		i = 0; //i is already defined
		while (i < WIDTH) {
			System.out.print("*");
			i++;
		}
		
		//Question for you.  If you look at attempt V. what advantage you see?
		//You could simply change the constant value of HEIGHT and WIDTH
		//to draw the Box, it will draw a different box without changing code
		
		//You could even get the height and width from user instead of constants
	}
}
