// Create an App class.

// Import the Scanner class from library.
import java.util.Scanner;

// Create class.
public class JavaWordsGameApp{

	// Create the main method.
	public static void main(String[] args){

		// Declare/initialise variables.
		int numberOfGames = 0;
		int numberOfRounds = 0;
		// Declare (could not use a constant/final as it is in a loop) the number of lives (value later assigned with logic based on player choices).
		int numberOfLives;
		int gameNumber = 0;
		int roundNumber = 0;
		char randomLetter;
		String fpPreviousWord = " ";
		String spPreviousWord = " ";
		int p1NumberOfLives = 0;
		int p2NumberOfLives = 0;
		String firstPlayer;
		String secondPlayer;
		int score = 0;
		int p1Score = 0;
		int p2Score = 0;
		int p1ScoreTotal = 0;
		int p2ScoreTotal = 0;
		int player1Selection;
		int player2Selection;
		int player1GameSelection = 0;
		int player2GameSelection = 0;
		
		// Counter controlled loop based on the number of games (GameNumber is counter).
		gameNumber = 0;
		// Condition for the while loop.
		while (gameNumber <= 1 || gameNumber < numberOfGames) {
			// App displays a welcome message (with fun smiley face), game rules and points scoring system.
			System.out.println();
			System.out.println("Welcome to the Java Words Game!");
			System.out.println("The game that's really easy to play, but incredibly difficult to code...");
			System.out.println("");
			System.out.println("//////");
			System.out.println(" O O");
			System.out.println("  <  ");
			System.out.println("  U ");
			System.out.println("");
			System.out.println("Be nice to the computer - keep it's inter'face' happy by being good with words.");
			System.out.println("");
	
			// App asks player1 to enter name.
			System.out.println("Player 1: Please enter your name.");
			// Create object of type Scanner.
			Scanner player1NameInput = new Scanner(System.in);
			// Assign value of String input to variable.
			String player1Name = player1NameInput.nextLine();
	
			// App asks player2 to enter name.
			System.out.println("Player 2: Please enter your name.");
			// Create object of type Scanner.
			Scanner player2NameInput = new Scanner(System.in);
			// Assign value of String input to variable.
			String player2Name = player2NameInput.nextLine();
			
			// If statement to ensure that if the value for the number of games is zero, the players need to be asked to input info.
			if (numberOfGames == 0) {
				// App displays message asking Player 1 how many games are to be played.
				System.out.println(player1Name + ": Please enter the number of games that you would like to play.");
				
				// Players 1’s input is stored in a variable.
				Scanner player1GameSelectionInput = new Scanner(System.in);
				
				// While loop for error handling of string inputs where an int is required.
				while ( !player1GameSelectionInput.hasNextInt() ){
					System.out.println("");
					System.out.println("Please enter a number.");
					player1GameSelectionInput = new Scanner(System.in);
				}
				
				// Assign value of int input to variable.
				player1GameSelection = player1GameSelectionInput.nextInt();
				
				// App displays message asking Player 2 how many games are to be played.
				System.out.println(player2Name + ": Please enter the number of games that you would like to play.");
				
				// Players 2’s input is stored in a variable.
				Scanner player2GameSelectionInput = new Scanner(System.in);
				
				// While loop for error handling of string inputs where an int is required.
				while ( !player2GameSelectionInput.hasNextInt() ){
					System.out.println("");
					System.out.println("Please enter a number.");
					player2GameSelectionInput = new Scanner(System.in);
				}
				
				// Assign value of int input to variable.
				player2GameSelection = player2GameSelectionInput.nextInt();
			}
			
			// App displays message asking Player 1 how many rounds are to be played.
			System.out.println(player1Name + ": Please enter the number of rounds that you would like to play.");
	
			// Players 1’s input is stored in a variable.
			Scanner player1SelectionInput = new Scanner(System.in);
			
			// While loop for error handling of string inputs where an int is required.
			while ( !player1SelectionInput.hasNextInt() ){
				System.out.println("");
				System.out.println("Please enter a number.");
				player1SelectionInput = new Scanner(System.in);
			}
			
			// Assign value of int input to variable.
			player1Selection = player1SelectionInput.nextInt();
	
			// App displays message asking Player 2 how many rounds are to be played.
			System.out.println(player2Name + ": Please enter the number of rounds that you would like to play.");
	
			// Players 2’s input is stored in a variable.
			Scanner player2SelectionInput = new Scanner(System.in);
			
			// While loop for error handling of string inputs where an int is required.
			while ( !player2SelectionInput.hasNextInt() ){
				System.out.println("");
				System.out.println("Please enter a number.");
				player2SelectionInput = new Scanner(System.in);
			}
			
			// Assign value of int input to variable.
			player2Selection = player2SelectionInput.nextInt();
			
			// Constructor for game setup class - create an object of this class passing in 2 parameters.
			GameSetup gameSetup = new GameSetup(player1Selection, player2Selection);
	
			// Call setter methods.
			// If statement as Number of Games setters only required for the first game.
			if (numberOfGames == 0) {
				gameSetup.setPlayer1Gameselection(player1GameSelection);
				gameSetup.setPlayer2Gameselection(player2GameSelection);
			}
			gameSetup.setPlayer1selection(player1Selection);
			gameSetup.setPlayer2selection(player2Selection);
			
			// If statement as display of this information only required for the first game.
			if (numberOfGames == 0) {
				// Display number of games input by players.
				System.out.println(player1Name + " chose to play " + player1GameSelection + " games.");
				System.out.println(player2Name + " chose to play " + player2GameSelection + " games.");
				
				// App calls function in Game Setup class computes the average number of games requested.
				// This is stored in a variable and determines the number of games.
				numberOfGames = gameSetup.getNumberOfGames();
				System.out.println("The average number of games requested by all players is " + numberOfGames + ".");
				System.out.println("So to be fair, the number of games will be " + numberOfGames + ".");
				System.out.println("");
			}
			
			// Display number of rounds input by players.
			System.out.println(player1Name + " chose to play " + player1Selection + " rounds.");
			System.out.println(player2Name + " chose to play " + player2Selection + " rounds.");
			
			// App calls function in Game Setup class computes the average number of rounds requested.
			// This is stored in a variable and determines the number of rounds.
			numberOfRounds = gameSetup.getNumberOfRounds();
			System.out.println("The average number of rounds requested by all players is " + numberOfRounds + ". (minimum of 6 rounds)");
			System.out.println("So to be fair, the number of rounds will be " + numberOfRounds + ". (minimum of 6 rounds)");
			System.out.println("");
			
			// App calls function in Game Setup class computes the number of lives.
			// This is stored in a variable.
			numberOfLives = gameSetup.getNumberOfLives();
			
			// Display info for number of lives.
			System.out.println("The number of lives is half of the number of rounds, or a minimum of 3 lives.");
			System.out.println("For this series of games, the number of lives is " + numberOfLives + ".");
			System.out.println("");
			
			// Assign value for number of lives to each individual player.
			p1NumberOfLives = numberOfLives;
			p2NumberOfLives = numberOfLives;
			
			// Display rules of the game.
			System.out.println("Within each round, the computer generates a random letter.");
			System.out.println("Player 1 starts the first round and inputs a word (min 3 letters) which starts with the letter the computer generated.");
			System.out.println("The other player then inputs another word starting with the last 2 letters of the first player's word, and so on.");
			System.out.println("A round ends when one player cannot input a valid word and they have to input '-'.");
			System.out.println("When a player inputs '-', they lose a life.");
			System.out.println("After the first round, the winner of the previous round starts the round.");
			System.out.println("Rounds are played until one player loses all their lives.");
			System.out.println("If one player loses all of their lives, the other player is the winner.");
			System.out.println("");
	
			// Display system for awarding points.
			System.out.println("The player receives the same amount of points as the number of duplicated vowels in the word.");
			System.out.println("For example:");
			System.out.println("'moon' = 2 points");
			System.out.println("'cheerleader' = 4 points");
			System.out.println("'answer' = 0 points");
			System.out.println("");
			
			// Assign a status to each player so that we know the last winner/loser of the round (determines who starts next round).
			String winner = player1Name;
			String loser = player2Name;
			
			// Counter controlled loop based on the number of rounds (round number is counter).
			roundNumber = 0;
			// While condition for rounds.
			while (roundNumber < numberOfRounds) {
				// If statement to end game if either players lives reach zero.
				if ( ( p1NumberOfLives == 0 ) || ( p2NumberOfLives == 0 ) ) {
					break;
				// If lives not at zero, the remaining logic resumes.
				} else {
					// Increment the counter.
					roundNumber++;
					// Reset variable value for previous word.
					fpPreviousWord = " ";
					
					// If statement for first player to always start the first round.
					if (roundNumber == 0) {
						firstPlayer = player1Name;
						secondPlayer = player2Name;
					// If not the first round, the winner of the last round starts the round.
					} else {
						firstPlayer = winner;
						secondPlayer = loser;
					}
					
					// Display new round info.
					System.out.println("New Round!");
					// The loop counter is used to display the round number.
					System.out.println("Round No. " + roundNumber + "!");
					System.out.println("");
					
					// Constructor to create object of random letter generator class.
					RandomLetterGenerator randomLetterGenerator = new RandomLetterGenerator();
					// Call the function from the object and assign the returned value of this to a variable.
					randomLetter = randomLetterGenerator.getRandomLetter();
					// Display this info.
					System.out.println("The random letter is: " + randomLetter + "!");
					System.out.println("");
					
					// Do while loop for the in-Round loop of turns.
					do {
						// Display info.
						System.out.println(firstPlayer + ", please enter a word:");
						System.out.println("");
						// Create object of Scanner class.
						Scanner wordInput1 = new Scanner(System.in);
						// Assign the input to a variable with the input to be converted to lower case to avoid errors.
						String fpWord = wordInput1.nextLine().toLowerCase();
						
						// Create object of Input Validation class passing in 2 parameters.
						InputValidation fpInputValidation = new InputValidation(fpWord, fpPreviousWord);
						// Call a method from this object and pass in 1 parameter (random letter).
						fpInputValidation.setRandomLetter(randomLetter);
						// Call the validate word method from this object and pass in 1 parameter (first player word).
						fpInputValidation.validateWord(fpWord);
						// Call getter from input validation object as it will assign a score and return it. The score is assigned to a variable in this class so that it can be totalled.
						score = fpInputValidation.getScore();
						
						// Add scores to each player after round.
						if (loser.equals(player1Name)) {
							p1Score = score;
						} else {
							p2Score = score;
						}
						
						// Calculate points achieved for each player.
						p1ScoreTotal = p1ScoreTotal + p1Score;
						p2ScoreTotal = p2ScoreTotal + p2Score;
						
						// Error handling - While word input is invalid - Prompt player to try again until valid word entered.
						while (!fpInputValidation.getValid() && !fpWord.equals("-") ) {
							System.out.println(firstPlayer + ", please enter a word:");
							System.out.println("");
							// Assign the input to a variable with the input to be converted to lower case to avoid errors.
							fpWord = wordInput1.nextLine().toLowerCase();
							// Call a method from this object and pass in 1 parameter (random letter).
							fpInputValidation.setRandomLetter(randomLetter);
							// Call the validate word method from this object and pass in 1 parameter (first player word).
							fpInputValidation.validateWord(fpWord);
							// Call getter from input validation object as it will assign a score and return it. The score is assigned to a variable in this class so that it can be totalled.
							score = fpInputValidation.getScore();
							
							// Add scores to each player after round.
							if (loser.equals(player1Name)) {
								p1Score = score;
							} else {
								p2Score = score;
							}
							
							// Calculate points achieved for each player.
							p1ScoreTotal = p1ScoreTotal + p1Score;
							p2ScoreTotal = p2ScoreTotal + p2Score;
						}
						
						// Determine winner/loser of round.
						if (fpWord.equals("-")) {
							winner = secondPlayer;
							loser = firstPlayer;
							
							// Remove life from relevant player after round.
							if (loser.equals(player1Name)) {
								p1NumberOfLives = p1NumberOfLives - 1;
							} else {
								p2NumberOfLives = p2NumberOfLives - 1;
							}
							
							// Display end of round info.
							System.out.println("Round over!");
							System.out.println("");
							System.out.println(winner + " is the winner!");
							System.out.println("");
							System.out.println(player1Name + " lives: " + p1NumberOfLives);
							System.out.println(player2Name + " lives: " + p2NumberOfLives);
							System.out.println("");
							break;
						}
						
						// Display info.
						System.out.println(secondPlayer + ", please enter a word:");
						System.out.println("");
						// Create Scanner object.
						Scanner wordInput2 = new Scanner(System.in);
						// Assign input to variable.
						String spWord = wordInput2.nextLine().toLowerCase();
						
						// Input validation.
						spPreviousWord = fpWord;
						fpPreviousWord = spWord;
						InputValidation spInputValidation = new InputValidation(spWord, spPreviousWord);
						spInputValidation.validateWord(spWord);
						score = spInputValidation.getScore();
						
						// Add scores to each player after round.
						if (loser.equals(player1Name)) {
							p1Score = score;
						} else {
							p2Score = score;
						}
						
						// Calculate points achieved for each player.
						p1ScoreTotal = p1ScoreTotal + p1Score;
						p2ScoreTotal = p2ScoreTotal + p2Score;
						
						// Error handling - While word input is invalid - Prompt player to try again until valid word entered.
						while (!spInputValidation.getValid() && !spWord.equals("-") ) {
							System.out.println(secondPlayer + ", please enter a word:");
							System.out.println("");
							spWord = wordInput2.nextLine().toLowerCase();
							
							spPreviousWord = fpWord;
							fpPreviousWord = spWord;
							spInputValidation.validateWord(spWord);
							score = spInputValidation.getScore();
							
							if (loser.equals(player1Name)) {
								p1Score = score;
							} else {
								p2Score = score;
							}
							
							p1ScoreTotal = p1ScoreTotal + p1Score;
							p2ScoreTotal = p2ScoreTotal + p2Score;
						}
						
						// Determine winner/loser of round.
						if (spWord.equals("-")) {
							winner = firstPlayer;
							loser = secondPlayer;
							
							// Remove life from loser.
							if (loser.equals(player1Name)) {
								p1NumberOfLives = p1NumberOfLives - 1;
							} else {
								p2NumberOfLives = p2NumberOfLives - 1;
							}
							
							// Display round end info.
							System.out.println("Round over!");
							System.out.println("");
							System.out.println(winner + " is the winner!");
							System.out.println("");
							System.out.println(player1Name + " lives: " + p1NumberOfLives);
							System.out.println(player2Name + " lives: " + p2NumberOfLives);
							System.out.println("");
							break;
						}
					// Condition for do while loop for the in-Round loop of turns.
					} while (true);
				}
			}
			
			// Display game over info.
			System.out.println();
			System.out.println("-----Game Over!-----");
			System.out.println("");
			System.out.println("//////");
			System.out.println(" O O");
			System.out.println("  <  ");
			System.out.println("  n ");
			System.out.println("");
			
			// Display winner based on who reaches zero lives first.
			if (p1NumberOfLives == 0 ) {
				System.out.println(player2Name + " is the winner!");
			} else if (p2NumberOfLives == 0 ) {
				System.out.println(player1Name + " is the winner!");
			}
			
			// Display number of points achieved for each player.
			System.out.println();
			System.out.println(player1Name + " won " + p1ScoreTotal + " points during the game!");
			System.out.println(player2Name + " won " + p2ScoreTotal + " points during the game!");
		
		// Increment game number counter.
		gameNumber++;
		}
	}
}