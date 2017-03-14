
public class ModularDrawBox {

	
	public static void drawHLine(int hSize, String hStr) {
		int i = 0;
		while (i++  < hSize)
			System.out.print(hStr);
	}

	public static void drawVLine(int hSize, int vSize, 
			                     String vStr, String hStr) {
		int i = 0;
		int temphSize = hSize;
		hSize = hSize-2; 
		String temphStr = hStr;
		hStr = " ";
		while (i++ < vSize - 2) {
			System.out.print(vStr);
			drawHLine(hSize, hStr);
			System.out.println(vStr);
		}
		//make sure to reset back the hSize an hStr;
		hSize = temphSize;
		hStr  = temphStr;
	}
/*
	public static void main(String[] args) {
		drawHLine(10, "*");
		System.out.printf("\n"); //new line is not drawn by drawHLine
		drawVLine(10, 10, "*", "*");
		drawHLine(10, "*");
		System.out.printf("\n");
	}
*/
	//Modular program has methods.  Let us convert the 
	//V. Ultimate improvement in drawing 10X10 box into modular program
	//What part of code are candidate for creating methods
	
	//I.  For first attempt just create methods to draw first line
	//    and the body with the nested loop.  First line method 
	//    can be re-used to draw the last line as well.
	
	//    How do we pass those constants?  Let us send them as arguments

	public static void drawHorizontalLine(int width){
		int i = 0;
		while (i < width) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();		
	}
	
	public static void drawBody (int height, int width){
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

	//Do we need another method to draw last line?
	//No we will reuse the drawVertical line
	
	public static void main (String [] args) {
		final int HEIGHT = 15;
		final int WIDTH = 20;
		//Now, we just need to call these methods appropriately
		drawHorizontalLine(WIDTH);  //we can call these methods directly
		                            //without using class names or object references
		                            //because these methods are static and this main
		                            //is also a method of same class.
		drawBody(HEIGHT, WIDTH);
		drawHorizontalLine(WIDTH);
	}
}

