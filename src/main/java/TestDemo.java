import java.util.Random;

public class TestDemo {

	// Chose to run error checks first in method to condense if condition
	// If error checks don't return the Exception, we assume the parameters are good and can add the values
	
	public int addPositive(int a, int b) {
			
		if (a <= 0 || b <= 0 ) {
			throw new IllegalArgumentException ("Both parameters must be positive!");
		} else {
			return a + b;
		}
	}
	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
	}
	
	int getRandomInt() {	
		  Random random = new Random(); //declare instance of old class in new class
		  return random.nextInt(10) + 1;
		}
	
}
