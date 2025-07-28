public class Main {
	public static void main(String[] args) {
		int numIterations = 10000;
		int numDice = 2;
		GameSimulator simulator = new GameSimulator(numIterations, numDice);

		simulator.runSimulation();
	}
}