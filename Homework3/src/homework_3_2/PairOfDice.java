package homework_3_2;

public class PairOfDice {
	private Die firstDie;
	private Die secondDie;
	public PairOfDice() {
		firstDie = new Die();
		secondDie = new Die();
	}
	public PairOfDice(int sides) {
		firstDie = new Die(sides);
		secondDie = new Die(sides);
	}
	public void roll() {
		firstDie.roll();
		secondDie.roll();
	}
	public int getValue1() {
		return firstDie.getValue();
	}
	public int getValue2() {
		return secondDie.getValue();
	}
	public int getSum() {
		return getValue1() + getValue2();
	}
}
