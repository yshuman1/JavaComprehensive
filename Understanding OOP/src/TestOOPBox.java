
public class TestOOPBox {

	public static void main(String[] args) {

		//Now, let us test our newest OOP class we called NotSoOOpBox
		NotSoOOPBox notOOPBoxI = new NotSoOOPBox(10, 20);
		notOOPBoxI.drawBox(); //wow awesome, it worked first time, hurrah!!!
		
		//Let us create another one
		NotSoOOPBox notOOPBoxII = new NotSoOOPBox(5, 10);
		notOOPBoxII.drawBox(); //wow that works too.
		
		//Can I draw first one again, which is 10X20 box?
		notOOPBoxI.drawBox(); //what?  Whey did it print 5X10 and not 10X20?
		
		//It does not look right, let me create a third one
		NotSoOOPBox notOOPBoxIII = new NotSoOOPBox(8, 16);
		notOOPBoxIII.drawBox(); //wow that works too.
		
		//Can I draw first (10,20), second (5,10) and third (8.16) once again?
		notOOPBoxI.drawBox(); 
		notOOPBoxII.drawBox(); 
		notOOPBoxIII.drawBox(); 
		
		//Wow, that is crazy, now, all of them are drawing same box
		
		//This is definitely Not an OOP.  Meaning, each object is not keeping
		//their own state (meaning not storing their data separately, or independently
		//of each other).  Rather looks like they are sharing their data.
		
		//Why?
		
		//The culprit is data is static, static data is calls class data and 
		//all of the object of class will share that data.
		
		//To make data specific to an object, we should remove static from the data
		
		//Walk through the code in OOPBox first before checking running and checking 
		//the code below.
		
		//Phase II testing.  Now let us test our new OOPBox in similar fashion
		//It does not look right, let me create a third one
		OOPBox OOPBoxI = new OOPBox(10, 20);
		OOPBoxI.drawBox(); 

		OOPBox OOPBoxII = new OOPBox(5, 10);
		OOPBoxII.drawBox(); 

		OOPBox OOPBoxIII = new OOPBox(8, 16);
		OOPBoxIII.drawBox(); 

		//Now, let us repeat, do these objects keep their state separately?
		OOPBoxI.drawBox(); 
		OOPBoxII.drawBox(); 
		OOPBoxIII.drawBox(); 
		
		//Yes they did!  Wow, Triumph!
		
		//We wrote our vey own OOP.  Pat in your back and enjoy the ship of coffee!
		
				
	}

}
