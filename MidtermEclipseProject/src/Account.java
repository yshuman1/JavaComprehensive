
public abstract class Account implements Bankable{
	double balance = 1000.00;
	double amount;
	public double withdraw(double i) {
		amount = i;
		return balance -= amount;
		
	}
	public double deposit(double i) {
		amount = i;
		return balance += amount;
	}
	public double calcInterest() {
		return 0;
	}	
	public double transact(String trans, double amount) {
		if (trans.equalsIgnoreCase("w")){
			withdraw(amount);
		} else {
			deposit(amount);
		}
		
		return balance;
	}
}
