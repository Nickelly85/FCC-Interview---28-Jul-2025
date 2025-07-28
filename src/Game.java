public class Game {
	private final Player player;

	Game(int startingNumDice) {
		this.player = new Player(startingNumDice);
	}

	public int playGame() {
		while (!gameOver()) {
			player.rollDice();
			int numThrees = player.getNumThrees();
			int score = calculateScore(numThrees);
			int numDiceToRemove = calculateNumDiceToRemove(numThrees);
			player.updateScore(score);
			player.removeDice(numDiceToRemove);
		}
		return player.getScore();
	}

	private boolean gameOver() {
		return player.hasNoDiceLeft();
	}

	private int calculateScore(int numThrees) {
		if(numThrees > 0) {
			return 0;
		} else {
			return player.getMinDiceValue();
		}
	}

	private int calculateNumDiceToRemove(int numThrees) {
		if(numThrees > 0) {
			return numThrees;
		} else {
			return 1;
		}
	}
}
