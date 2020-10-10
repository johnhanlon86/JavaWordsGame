// Create an instantiable class to manage the game set up based on each player input.

public class GameSetup{

	// Create instance variables.
	private int player1GameSelection;
	private int player2GameSelection;
	private int player1Selection;
	private int player2Selection;
	private int averageGamesRequested;
	private int averageRoundsRequested;
	private int numberOfGames;
	private int numberOfRounds;
	private int numberOfLives;

	// Create Setters.
	public void setPlayer1Gameselection(int player1GameSelection){
		this.player1GameSelection = player1GameSelection;
	}
	
	public void setPlayer2Gameselection(int player2GameSelection){
		this.player2GameSelection = player2GameSelection;
	}
	
	public void setPlayer1selection(int player1Selection){
		this.player1Selection = player1Selection;
	}

	public void setPlayer2selection(int player2Selection){
		this.player2Selection = player2Selection;
	}
	
	// Declare a constructor with parameters that take in the players selections.
	public GameSetup(int player1Selection, int player2Selection){}

	// Processing to determine the number of lives each player has.
	public void calculateNumberOfGames(){
		averageGamesRequested = (player1GameSelection + player2GameSelection) / 2 ;
		numberOfGames = averageGamesRequested;
	}
	
	// Processing to determine the number of rounds.
	public void calculateNumberOfRounds(){
		averageRoundsRequested = (player1Selection + player2Selection) / 2 ;
		numberOfRounds = averageRoundsRequested;
		// Error Handling - minimum number of rounds needs to be 6 if the minimum number of lives is 3 per player.
		if (numberOfRounds < 6) {
			numberOfRounds = 6;
		}
	}
	
	// Processing for number of lives.
	public void calculateNumberOfLives(){
		if (numberOfRounds <=6) {
			numberOfLives = 3;
		} else {
			numberOfLives = numberOfRounds / 2;
		}
	}
	
	// Create Getter.
	public int getNumberOfGames(){
		calculateNumberOfGames();
		return numberOfGames;
	}
	
	// Create Getter.
	public int getNumberOfRounds(){
		calculateNumberOfRounds();
	    return numberOfRounds;
 	}

 	// Create Getter.
		public int getNumberOfLives(){
			calculateNumberOfLives();
		    return numberOfLives;
 	}
}