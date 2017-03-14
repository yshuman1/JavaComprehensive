import java.util.Scanner;

public class NotSoOOPBox {

	//Now we need to store the height and width outside of methods
	//so that it will be our state.
	//However, our drawBox method is static, so, we need to make
	//these variables of static

	private static int height;
	private static int width;
	
	//Well, since we are writing OOP, then let us write constructor as well
	
	public NotSoOOPBox(int h, int w) {
		height = h; //initialize your class data with parameters
		width = w;
	}
	
	//Should I create default constructor as well?
	public NotSoOOPBox() {
		//Let us give default size to height and width
		height = 10;
		width = 10;
	}
	
	//Now, let us modify the methods and remove parameters as we can
	//directly use our class variables
	private static void drawHorizontalLine(){
		int i = 0;
		while (i < width) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();		
	}
	
	private static void drawBody (){
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

	public static void drawBox() {
		drawHorizontalLine();
		drawBody();
		drawHorizontalLine();	
	}
	
	//Do I need to have a main method?
	//Not really, unless I want to test out my methods myself.
	
	//Let us create a TestOOPBox class to test out OOPBox classes
	
}


