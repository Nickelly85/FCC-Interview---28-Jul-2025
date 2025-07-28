public class GameSimulator {
	private final int numIterations;
	private final int numDice;
	private final int[] gameScores;
	private final int[] scoreStats;
	private long duration;

	GameSimulator(int numIterations, int numDice) {
		this.numIterations = numIterations;
		this.numDice = numDice;
		this.gameScores = new int[numIterations];
		this.scoreStats = new int[6 * numDice + 1];
	}

	public void runSimulation() {
		long startTime = System.nanoTime();
		for (int i = 0; i < numIterations; i++) {
			Game game = new Game(numDice);
			gameScores[i] = game.playGame();
		}
		long endTime = System.nanoTime();
		duration = (endTime - startTime) / 1_000_000;
		printScoreStats();
	}

	public void printScoreStats() {
		calculateStats();
		for (int i = 0; i < scoreStats.length; i++) {
			System.out.println("Score " + i + " occurs " + ((float) scoreStats[i] / numIterations) + " occurred " + scoreStats[i] + " times.");
		}
		System.out.println("Simulation took " + duration + " milliseconds.");
	}

	private void calculateStats() {
		for (int score : gameScores) {
			scoreStats[score]++;
		}
	}
}
