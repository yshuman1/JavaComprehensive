//interface used by different bank accounts to handle transactions 
public interface Bankable {
	public abstract double withdraw(double i) throws Exception;
	public abstract double deposit(double i) throws Exception;
	public abstract double calcInterest();
}
