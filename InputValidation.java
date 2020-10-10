// Create an instantiable class to manage input validation.

// Import Scanner class.
import java.util.Scanner;

public class InputValidation{

	// Declare/initialise instance variables.
	private char randomLetter;
	private String word;
	private String previousWord = " ";
	private String previousCorrectWord = " ";
	private boolean valid;
	private String vowels = "aeiou";
	private int numberOfA = 0;
	private int numberOfE = 0;
	private int numberOfI = 0;
	private int numberOfO = 0;
	private int numberOfU = 0;
	private int score = 0;
	
	// Declare a constructor with 2 parameters that take in the word and previous word.
	public InputValidation(String fpWord, String fpPreviousWord) {
		this.word = fpWord;
		this.previousWord = fpPreviousWord;
	}
	
	// Setter method to assign a value to the instance variable randomLetter.
	public void setRandomLetter(char randomLetter){
		this.randomLetter = randomLetter;
	}
	
	// Getter
	public int getScore() {
		return score;
	}
	
	// Method to validate words (takes in 1 parameter - word).
	public void validateWord(String word){
		
		// Create object of LimitedVocabulary class if a word is input for validation.
		if (!word.equals("-")){
			
			LimitedVocabulary limitedVocabulary = new LimitedVocabulary(word);
			
			// If a previous word entered that isn't correct, we will use the previous correct word to compare words against.
			if (!previousCorrectWord.equals(" ")) {
				previousWord = previousCorrectWord;
			}
			
			// If no previous word (For the first turn of the first round).
			if (previousWord.equals(" ")){
				// The word is validated against a computer generated letter, not any previous word.
				if (limitedVocabulary.verifyWord(word) && word.length() >= 3 && randomLetter == word.charAt(0)){
					// Display valid word message.
					System.out.println("Well done! " + word + " is a valid word!");
					System.out.println("");
					System.out.println("//////");
					System.out.println(" O O");
					System.out.println("  <  ");
					System.out.println("  U ");
					System.out.println("");
					// Boolean to confirm word validated.
					valid = true;
					
					// Add points for correct word.
					// Traverse String entered by player to compare word against string of vowels and if a vowel exists, add 1 to the relevant number of that vowel.
					for (int x = 0; x < word.length(); x++) {
						if ( word.charAt(x) == vowels.charAt(0) ) {
							numberOfA = numberOfA +1;
						}
						if ( word.charAt(x) == vowels.charAt(1) ) {
							numberOfE = numberOfE +1;
						}
						if ( word.charAt(x) == vowels.charAt(2) ) {
							numberOfI = numberOfI +1;
						}
						if ( word.charAt(x) == vowels.charAt(3) ) {
							numberOfO = numberOfO +1;
						}
						if ( word.charAt(x) == vowels.charAt(4) ) {
							numberOfU = numberOfU +1;
						}
					}
					
					// Add points for the number of repeated vowels.
					if ( numberOfA > 1) {
						score = score + numberOfA;
					}
					
					if ( numberOfE > 1) {
						score = score + numberOfE;
					}
					
					if ( numberOfI > 1) {
						score = score + numberOfI;
					}
					
					if ( numberOfO > 1) {
						score = score + numberOfO;
					}
					
					if ( numberOfU > 1) {
						score = score + numberOfU;
					}
					
					// Display points won for word and total points.
					System.out.println("You won " + score + " points!");
					System.out.println();
					
				} else {
					System.out.println(word + " is an invalid word! No points won.");
					System.out.println("");
					System.out.println("//////");
					System.out.println(" - -");
					System.out.println("  <  ");
					System.out.println("  n ");
					System.out.println("");
					System.out.println("Remember that the word must start with the computer's letter and be at least 3 characters long.");
					System.out.println("Please try again!");
					System.out.println("");
					// Scanner wordInput3 = new Scanner(System.in);
					// word = wordInput3.nextLine().toLowerCase();
					// InputValidation inputValidation = new InputValidation(word, previousWord);
					// inputValidation.validateWord(word);
					// if (word.equals(true)){
					// 	previousCorrectWord = word;
					// }
				}
			
				// Else statement for all turns other than the first turn.
			} else {
				// If statement to compare word to previous word - The characters at specified indexes are compared as per the rules.
				if (limitedVocabulary.verifyWord(word) && word.length() >= 3 && previousWord.charAt( previousWord.length()-1) == word.charAt(1) && previousWord.charAt(previousWord.length() - 2) == word.charAt(0) ){
					// Display message.
					System.out.println("Well done! " + word + " is a valid word!");
					System.out.println("");
					System.out.println("//////");
					System.out.println(" O O");
					System.out.println("  <  ");
					System.out.println("  U ");
					System.out.println("");
					// Boolean to determine if valid.
					valid = true;
					
					// Add points for correct word.
					// Traverse String entered by player to compare word against string of vowels and if a vowel exists, add 1 to the relevant number of that vowel.
					for (int x = 0; x < word.length(); x++) {
						if ( word.charAt(x) == vowels.charAt(0) ) {
							numberOfA = numberOfA +1;
						}
						if ( word.charAt(x) == vowels.charAt(1) ) {
							numberOfE = numberOfE +1;
						}
						if ( word.charAt(x) == vowels.charAt(2) ) {
							numberOfI = numberOfI +1;
						}
						if ( word.charAt(x) == vowels.charAt(3) ) {
							numberOfO = numberOfO +1;
						}
						if ( word.charAt(x) == vowels.charAt(4) ) {
							numberOfU = numberOfU +1;
						}
					}
					
					// Add points for the number of repeated vowels.
					if ( numberOfA > 1) {
						score = score + numberOfA;
					}
					
					if ( numberOfE > 1) {
						score = score + numberOfE;
					}
					
					if ( numberOfI > 1) {
						score = score + numberOfI;
					}
					
					if ( numberOfO > 1) {
						score = score + numberOfO;
					}
					
					if ( numberOfU > 1) {
						score = score + numberOfU;
					}
					
					// Display points won for word and total points.
					System.out.println("You won " + score + " points!");
					System.out.println();
					
				} else {
					System.out.println(word + " is an invalid word! No points won.");
					System.out.println("");
					System.out.println("//////");
					System.out.println(" - -");
					System.out.println("  <  ");
					System.out.println("  n ");
					System.out.println("");
					System.out.println("Remember that the word must being with the last 2 letters of the previous word and be at least 3 characters long.");
					System.out.println("Please try again!");
					System.out.println("");
				}
			}
		}
	}
	
	// Create Getter to see if words are valid or not.
	public boolean getValid(){
		return valid;
 	}
}