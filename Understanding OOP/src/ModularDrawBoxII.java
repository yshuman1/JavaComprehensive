import java.util.Scanner;

public class ModularDrawBoxII {

	//We can improve ModularDrawBox by creating yet another
	//method which is called drawBox that calls drawHorizontalLine
	//and drawBody methods.
	
	//If we do that, then drawHorizontalLine and drawBody can be private
	
	//We can also use Scanner to get the height and width from user
	//instead of having constants
	
	private static void drawHorizontalLine(int width){
		int i = 0;
		while (i < width) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();		
	}
	
	private static void drawBody (int height, int width){
		//print 10-2 of these lines
		int i = 0;
		while (i < height-2) {
			System.out.print("*");
			int j = 0;
			while (j < width-2) {
				System.out.print(" ");
				j++;
			}
			System.out.println("*");
			i++;
		}	
	}

	public static void drawBox(int height, int width) {
		drawHorizontalLine(width);
		drawBody(height, width);
		drawHorizontalLine(width);	
	}
	
	public static void main (String [] args) {
		int height, width;
		
		//Now let us get the height and width from user
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter height and width separated by space: ");
		height = sc.nextInt();
		width = sc.nextInt();
		
		//Now, we just need to call drawBox method
		drawBox(height, width);
		
		sc.close(); //why we do this?
	}
}

