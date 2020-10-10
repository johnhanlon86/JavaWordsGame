// Create an instantiable class to create random a letter.

// Import library to generate random values.
import java.util.Random;

public class RandomLetterGenerator{

	// Create object of the type Random.
	Random random = new Random();

	// Create instance variables.
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	char randomLetter;

	// Processing to create random word.
	public void createRandomLetter(){
		randomLetter = alphabet.charAt(random.nextInt(alphabet.length()));
	}

	// Create Getter.
	public char getRandomLetter(){
		createRandomLetter();
	    return randomLetter;
 	}
}