package application;

//used to generate random values
import java.util.Random;

public class RandomDemoApplication {

	public static void main(String[] args) {

		RandomDemoApplication rda = new RandomDemoApplication();
		for (int iRand = 0; iRand < 10; iRand++) {

			System.out.printf("%d%s ", rda.generateRandomValue(), iRand < 9 ? "," : "");
		}

	}

	public int generateRandomValue() {
		// Declaration and initialization
		Random rnd = new Random();
		// Represents the random value
		int rndValue;
		rnd.setSeed(9);
		// generate a random value between 1 and 10
		rndValue = rnd.nextInt(10) + 1;

		return rndValue;
	}
}
