/**
* interface used by different bank accounts to handle transactions 
*/
public interface Bankable {
	/**
	 * deducts amount of transaction and updates balance
	 * @param i amount of transaction
	 * @return updated balance amount
	 * @throws Exception if amount is greater than balance or is less than 0.01
	 */
	public abstract double withdraw(double i) throws Exception;
	/**
	 * adds amount of transaction and updates balance
	 * @param i amount of transaction
	 * @return updated balance 
	 * @throws Exception amount is less than 0.01
	 */
	public abstract double deposit(double i) throws Exception;
	
	public abstract double calcInterest();
}
