package main;

import java.util.ArrayList;
/**
 * class is defined to deal with tennis set score
 * @author starzdp
 *
 */
public class TennisSet extends TennisContest implements GameListener,Cloneable{
	protected ArrayList<TennisSet> tennisSetList = new ArrayList<TennisSet>();
	
	public TennisSet(String playerOne, String playerTwo) {
		super(playerOne, playerTwo);
	}

	public void point(String player) {
	    addPoint(player);
	    
	    //check whether a player win the tennis set
	    contest(TennisConstant.GAP,TennisConstant.SET_MIN_SCORE);
	    
	    if(winner.equals(TennisConstant.Player_A) || winner.equals(TennisConstant.Player_B)){
	    	
	    	TennisSet setResult = new TennisSet(TennisConstant.Player_A,TennisConstant.Player_B);
	    	setResult.score.put(TennisConstant.Player_A, score.get(TennisConstant.Player_A));
	    	setResult.score.put(TennisConstant.Player_B, score.get(TennisConstant.Player_B));
	    	tennisSetList.add(setResult);
			reset();	
		}
	}

	public void gameWin(String player) {
//		System.out.println("TennisSet.gameWin(" + player +")");
		point(player);
	}
}
