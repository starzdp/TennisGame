package Test;

import junit.framework.TestCase;
import main.ScoreCard;
import main.Tennis;
import main.TennisConstant;
import main.TennisGame;
import main.TennisSet;
public class TennisMatchTest extends TestCase {
	TennisGame game;
	TennisSet set;
	ScoreCard scoreCard;
//	Tennis tennis;
	
	public void setUp() {
		scoreCard = new ScoreCard(TennisConstant.Player_A, TennisConstant.Player_B);
//		tennis = new Tennis();
	}
		
	public void testOneLineDisplay(){
		String input = "AAAABBBBAAAABBBBAAAABBBBAAAAAAAAAAAAA";
		getWinnerInfoFromMatchDesc(input);
//		tennis.getWinnerInfoFromMatchDesc(input);
		assertEquals("3-6 0-0 0-15", scoreCard.fullCard());
	}
	
	public void getWinnerInfoFromMatchDesc(String winnerInfo){
		for(int i = 0;i<winnerInfo.length();i++){
			String winner = String.valueOf(winnerInfo.charAt(i));
			if(winner.equals(TennisConstant.Player_A)){
				scoreCard.point(TennisConstant.Player_A);
			}else if(winner.equals(TennisConstant.Player_B)){
				scoreCard.point(TennisConstant.Player_B);
			}else{
				System.out.println("Invalid input file: the input file only can contain A and B players");
			}
		}
	}

}
