
public abstract class Account implements Bankable{
	double balance = 1000.00;
	public double withdraw(double i) throws Exception {
		if (i <= balance) {
			return balance -= i;
		}
		throw new Exception("Insufficient Funds!");
	}
	public double deposit(double i) throws Exception {
		if (i >= 0.01) {
			return balance += i;
		}
		throw new Exception("Must Deposit at least 1 cent.");
	}
	public double calcInterest() {
		return 0;
	}	
	public double transact(String trans, double amount) throws Exception {
		if (trans.equalsIgnoreCase("w")){
			withdraw(amount);
		} else {
			deposit(amount);
		}
		return balance;
	}
}
