package main;

import java.util.HashMap;
/**
 * class is defined to implement common methods and attributes of tennis game
 * @author starzdp
 *
 */
public class TennisContest {
	
	protected String PLAYER_A;
	protected String PLAYER_B;
	protected String winner = TennisConstant.TO_BE_DECIDE;
		
	protected HashMap<String, Integer> score = new HashMap<String, Integer>();
	
	public TennisContest(String playerOne, String playerTwo) {
		PLAYER_A = playerOne;
		PLAYER_B = playerTwo;
	    reset();
	}
	
	public int playerOneScore() {
		return score.get(PLAYER_A);
	}
	public int playerTwoScore() {
		return score.get(PLAYER_B);
	}
	
	protected void reset() {
		score.put(PLAYER_A, new Integer(0));
	    score.put(PLAYER_B, new Integer(0));
	}
	
	protected void addPoint(String player) {
	    score.put(player, new Integer(score.get(player)+1));
	}
	 
	protected int getScore(String player) {
	    return score.get(player);
	}
	 
	protected void addScore(String player) {
	    score.put(player, new Integer(score.get(player)+1));
	}
	
	/**
	 * check whether a player win game/set
	 * @param gap
	 * @param minScore
	 */
	protected void contest(int gap, int minScore){
		
		int aScore = score.get(PLAYER_A);
		int bScore = score.get(PLAYER_B);
		
		if(aScore>= minScore || bScore>= minScore){
			if(Math.abs(aScore - bScore)>=gap){
				if (aScore > bScore){
					winner = PLAYER_A;
				}else{
					winner = PLAYER_B;
				}
			}else{
				winner = TennisConstant.TO_BE_DECIDE;
			}
				
		}else if(aScore < minScore && bScore < minScore){
			winner = TennisConstant.TO_BE_DECIDE;
		}
	}
}
