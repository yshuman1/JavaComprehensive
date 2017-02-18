//interface used by different bank accounts to handle transactions 
public interface Bankable {
	//
	public abstract double withdrawal(Account a, double i);
	public abstract double deposit(Account a, double i);
	public abstract double calcInterest();
}
