public class OOPBox {

	//To make is OOP, we must remove static from
	//variables and methods as well.

	private int height;
	private int width;
	
	//Well, since we are writing OOP, then let us write constructor as well
	
	public OOPBox(int h, int w) {
		height = h; //initialize your class data with parameters
		width = w;
	}
	
	//Should I create default constructor as well?
	public OOPBox() {
		//Let us give default size to height and width
		height = 10;
		width = 10;
	}
	
	//Now, let us modify the methods and remove parameters as we can
	//directly use our class variables
	private  void drawHorizontalLine(){
		int i = 0;
		while (i < width) {
			System.out.print("*");
			i++;
		}
		//what would happen if you don't have this line?
		System.out.println();		
	}
	
	private void drawBody (){
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

	public void drawBox() {
		drawHorizontalLine();
		drawBody();
		drawHorizontalLine();	
	}
	
	//Let see the miracle already happened.  Go and check the TestOOPBox class
	//Phase II
}
