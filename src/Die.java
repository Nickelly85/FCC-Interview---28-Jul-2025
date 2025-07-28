import java.util.Random;

public class Die {
	private static final Random rand = new Random();
	private int value;

	Die() {
		this.value = 1;
	}

	public void roll() {
		value = rand.nextInt(6) + 1;
	}

	public int getValue() {
		return value;
	}
}
