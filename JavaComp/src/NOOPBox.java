public class NOOPBox {

	//class variables, must be private
	 static int 		vSize = 10;
	 static int 		hSize = 20;
	 static String 	hStr = "*";
	 static String 	vStr = "*";
	 static String  myName = "I am a Box"; 
	 
	/**
	 * Must provide a default constructor so that we can make a call like this
	 * NOOPBox oopBox = new NOOPBox();
	 */
	public NOOPBox() {
		super();
	}

	public NOOPBox(int vSize, int hSize, String hStr, 
			       String vStr, String name) {
		super();
		this.vSize = vSize;
		this.hSize = hSize;
		this.hStr = hStr;
		this.vStr = vStr;
		this.myName = name;
	}

	//hStr and hSize is private variables, you can directly use them
	public static void drawHLine() {
		int i = 0;
		while (i++  < hSize)
			System.out.print(hStr);
	}

	//vSize, vStr, hStr are private, can use directly
	public static void drawVLine() {
		int i = 0;
		//trick is to use drawHLine to draw inner hSize-2 spaces
		//problem is drawhLine uses hSize private variable, which should not be changed
		//so, you save hSize in a temp variable and reset when drawLine is done
		int temphSize = hSize;
		hSize = hSize-2; //reduce by two for two outer surrounding characters
		//  *          *
		//also in this case the drawHLine, really needs to draw a 
		//horizontal line with spaces, so, we need to do set the hStr as well
		String temphStr = hStr;
		hStr = " ";
		while (i++ < vSize - 2) {
			System.out.print(vStr);
			drawHLine();
			System.out.println(vStr);
		}
		//make sure to reset back the hSize an hStr;
		hSize = temphSize;
		hStr  = temphStr;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Can I use my own?  I can't use as object
		//but, I can all these methods
		drawHLine();
		System.out.printf("\n"); //new line is not drawn by drawHLine
		drawVLine();
		drawHLine();
		System.out.printf("\n");
		
		//can I create object? yes, I can
		System.out.println("\nTesting NOOPBox Class");
	    
		NOOPBox noopBox1 = new NOOPBox();
		System.out.println(noopBox1);
		//let us change the first box
		noopBox1.hSize = 8;
		noopBox1.vSize=4;
		noopBox1.hStr ="-";
		noopBox1.vStr="|";
		noopBox1.myName = "I am not an OOP";
		System.out.println(noopBox1);
		noopBox1.drawHLine();
		System.out.printf("\n"); //new line is not drawn by drawHLine
		noopBox1.drawVLine();
		noopBox1.drawHLine();
		System.out.printf("\n");
		
		//now draw directly, what happens?
		drawHLine();
		System.out.printf("\n"); //new line is not drawn by drawHLine
		drawVLine();
		drawHLine();
		System.out.printf("\n");

		//now create a new one and print
		NOOPBox noopBox2 = new NOOPBox();
		System.out.println(noopBox2);
		noopBox2.drawHLine();
		System.out.printf("\n"); //new line is not drawn by drawHLine
		noopBox2.drawVLine();
		noopBox2.drawHLine();
		System.out.printf("\n");
		
		//WOW, that is not what you would expect it to behave
		//do you?	
	}
}
