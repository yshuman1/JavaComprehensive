//interface used by different bank accounts to handle transactions 
public interface Bankable {
	//
	public abstract double withdraw(double i);
	public abstract double deposit(double i);
	public abstract double calcInterest();
}
