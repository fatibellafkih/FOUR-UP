/* The player is marqued by its name which it means in the Game the symbol he is playing with 
 * and its state: winner :
 * winner=false // during the game : the player is still playing
 * winner=false// at the end of the game: He failed in the game
 * winner=true// at the end of the game  : He won the Game
 */
public class Player {
	private char name;
	private boolean winner;
	
	public Player ()
	{
		name='X';
		winner=false;
	}
	public Player(char name)
	{
		this.name=name;	
		winner=false;
	}
	// Getter to get the player's symbol
	public char getPL()
	{
		return name;
	}
	

}
