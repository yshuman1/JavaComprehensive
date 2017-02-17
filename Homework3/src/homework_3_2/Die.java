package homework_3_2;

public class Die {
	private int sides;
	private static int value;
	public Die() {
		this(6);
	}
	public Die(int sides) {
		this.sides = sides;
	}
	public void roll() {
		value =  (int) (Math.random() * sides + 1);
	}
	public int getValue() {
		return value;
	}
}
