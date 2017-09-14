package main;
/**
 * class is defined to deal with tennis game points
 * @author starzdp
 *
 */
public class TennisGame extends TennisContest {

	public TennisGame(String playerOne, String playerTwo) {
		super(playerOne, playerTwo);
	}
	
	private GameListener listener;
	protected int gameNumber = 1;
	
	public void setGameListener(GameListener listener) {
	    this.listener = listener;
	}
	 
	protected void notifyWinner(String player) {
	    if (listener != null) {
	    	listener.gameWin(player);
	    }
	}
	
	/**
	 * method which used to deal with player get point
	 * @param player
	 */
	protected void point(String player) {
		addScore(player);
		//check whether a player win  tennis game
		contest(TennisConstant.GAP,TennisConstant.GAME_MIN_SCORE);
		
		if(winner.equals(TennisConstant.Player_A) || winner.equals(TennisConstant.Player_B)){
			reset();
			gameNumber++;
			//if someone win the game, then change the set score value
			notifyWinner(winner);
		}
	}
	
	public void playerAWinsThePoint() {
		point(PLAYER_A);
	}
	public void playerBWinsThePoint() {
		point(PLAYER_B);
	}
}
