
public class Savings extends Account {
	final double INTEREST = .01;
	@Override
	public double calcInterest() {
		return balance * INTEREST;
	}	
}


