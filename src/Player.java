import java.util.ArrayList;
import java.util.List;

public class Player {
	private final List<Die> dice;
	private int score;

	Player(int startingNumDice) {
		this.dice = new ArrayList<>();
		this.score = 0;
		for (int i = 0; i < startingNumDice; i++) {
			this.dice.add(new Die());
		}
	}

	public int getScore() {
		return score;
	}

	public int getNumThrees() {
		int numThrees = 0;
		for (Die die : dice) {
			if (die.getValue() == 3) {
				numThrees++;
			}
		}
		return numThrees;
	}

	public int getMinDiceValue() {
		int currentMinDiceValue = Integer.MAX_VALUE;
		for (Die die : dice) {
			currentMinDiceValue = Math.min(die.getValue(), currentMinDiceValue);
		}
		return currentMinDiceValue;
	}

	public void rollDice() {
		for (Die die : dice) {
			die.roll();
		}
	}

	public void updateScore(int score) {
		this.score += score;
	}

	public void removeDice(int numDice) {
		if (numDice > 0) {
			this.dice.subList(0, numDice).clear();
		}
	}

	public boolean hasNoDiceLeft() {
		return dice.isEmpty();
	}
}
