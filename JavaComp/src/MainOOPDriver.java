/**
 * @author bineetsharma
 *	This is the driver app for demo day 6. 
 *	It uses all of the classes used defined in this demo
 */
public class MainOOPDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Part I Test the StillNOOPBox - this one behaves 
	    //as Not so OOP 
		System.out.println("\nTesting StillNOOPBox Class");
	    
		StillNOOPBox noopBox1 = new StillNOOPBox();
		noopBox1.setMyName("My Name is First NOOPBox");
		System.out.println(noopBox1);
		noopBox1.drawYourself(); //draw default size

		//now create a different box
		StillNOOPBox noopBox2 = new StillNOOPBox();
		noopBox2.setMyName("My Name is Second StillNOOPBox");
		System.out.println(noopBox2);
		noopBox2.drawYourself(); //draw default size

		//let us change the first box
		noopBox1.sethSize(8);
		noopBox1.setvSize(4);
		noopBox1.sethStr("-");
		noopBox1.setvStr("|");
		noopBox1.setMyName("My Name is First Cool StillNOOPBox");
		System.out.println(noopBox1);
		noopBox1.drawYourself(); //draw changed first box
		
		//let us draw second box again without changing anything
		System.out.println(noopBox2);
		noopBox2.drawYourself(); //draw second box

		//noopBox2 sees all of the state of noopBox1
		
		//That is why the StillNOOPBox is not really a OOP
		
		//Now let us test the OOPBox
		
		//Part II Test the OOPBox - this one behaves 
	    //as perfect OOP
		System.out.println("\n\nTesting OOPBox Class");
	    
		OOPBox oopBox1 = new OOPBox();
		noopBox1.setMyName("My Name is First OOPBox");
		System.out.println(oopBox1);
		oopBox1.drawYourself(); //draw default size

		//now create a different box
		OOPBox oopBox2 = new OOPBox();
		oopBox2.setMyName("My Name is Second OOPBox");
		System.out.println(oopBox2);
		oopBox2.drawYourself(); //draw default size

		//let us change the first box
		oopBox1.sethSize(8);
		oopBox1.setvSize(4);
		oopBox1.sethStr("-");
		oopBox1.setvStr("|");
		oopBox1.setMyName("My Name is First Cool OOPBox");
		System.out.println(oopBox1);
		oopBox1.drawYourself(); //draw changed first box
		
		//let us draw second box again without changing anything
		System.out.println(oopBox2);
		oopBox2.drawYourself(); //draw second box
		
		//Now, the first and second box are totally different
		//and they don't share the state. They only share behaviors
			
		//can create using different constructors as well
		OOPBox oopBoxNew = new OOPBox(8, 6, "&", "%", "I am not a default Box");
		System.out.println(oopBoxNew);
		oopBoxNew.drawYourself();		
		}
}
