//Let us use the ModularDrawBoxII class from outside of same class

public class TestModularDrawBox {
	public static void main (String[] args) {
		//How Do I call drawBox() method?
		
		//Can I call like this, the way I used in main of ModularDrawBoxII
		
		//drawBox(10,20); //Not it does not work becuase the method is not 
		                  //In this class
		
		//Can I do this?  I have to use the class name where that method belongs
		ModularDrawBoxII.drawBox(10, 20);  //Nice
		//Sure that works, because drawBox is a public static method and
		//I can call using class name.
		
		//Can I instantiate the object from this class and call drawBox?
		ModularDrawBoxII myDrawBox = new ModularDrawBoxII();
		myDrawBox.drawBox(15,  22); //wow even that works
		
		//So, I can call a static method using Class name or object reference
		
		//Now, question.  This does not look like a object oriented program though
		//In an object oriented program, objects should keep the data with them
		//meaning, provide the data usually during object creation
		//That would be constructor and when we want it do something we just
		//invoke its behavior which is simply method.
		
		//May be like this:
		//ModularDrawBoxII myDrawBox = new ModularDrawBoxII(15, 20);
		//myDrawBox.drawBox(); //wow even that works
		
		//See the difference.  When we invoke the behavior drawBox(), 
		//our object already knows how to draw using its own data which
		//is already stored as state.
		
		//How to do that.  To get started, let us create a 
		//NotSoOOPBox class by using the code from ModularDrawBoxII
		
		//Check TestOOPBox class which uses NotSoOOPBox.
	}
}
