
/**
 * child class for savings account objects
 * sets interest rate to 1%
 */
public class Savings extends Account {
	final double INTEREST = .01;
	/**
	*calculates the interest earned on an accounts balance
	*/
	@Override
	public double calcInterest() {
		return balance * INTEREST;
	}	
}


