
/**
 * parent class of all Savings and Checking class objects.
 *sets the beginning balance
 *
 */
public abstract class Account implements Bankable {
	double balance = 1000.00;
	/**
	*method which deducts from and updates the balance
	*updates the account balance
	*@param i transaction amount
	*/
	@Override
	public double withdraw(double i) throws Exception {
		if (i <= balance) {
			return balance -= i;
		}
		throw new Exception("Insufficient funds to cover the withdrawal.");
	}
	/**
	*method which adds to and updates the balance 
	*@param i transaction amount
	*/
	@Override
	public double deposit(double i) throws Exception {
		if (i >= 0.01) {
			return balance += i;
		}
		throw new Exception("Deposits must be at least 1 cent.");
	}
	@Override
	public double calcInterest() {
		return 0;
	}	
	/**
	 * calls the proper transaction method depending on the user input provided
	 * @param trans either a withdrawal or a deposit
	 * @param amount the amount of the transaction
	 * @return updates the balance 
	 * @throws Exception if amount attempted to be deposited or withdrawn violates rules 
	 *  that a deposit must be at least 0.01 and that a withdrawal must not cause an overdraft 
	 */
	public double transact(String trans, double amount) throws Exception {
		if (trans.equalsIgnoreCase("w")) {
			withdraw(amount);
		} else {
			deposit(amount);
		}
		return balance;
	}
}
