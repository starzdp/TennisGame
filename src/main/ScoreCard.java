package main;
/**
 * class is defined to analyze descriptions of tennis matches and displays the current score in each match.
 * @author starzdp
 *
 */
public class ScoreCard implements GameListener{
	
	private final TennisGame game;
	private final TennisSet set;
	
	public ScoreCard(String playerOne, String playerTwo) {
	    game = new TennisGame(playerOne, playerTwo);
	    set = new TennisSet(playerOne, playerTwo);
	    game.setGameListener(set);
	}
	
	public void point(String player) {
	    game.point(player);
	}
	
	public String fullCard() {
		return (scoreSet() + " " + scoreGame()).trim();
	}
	
	public String initailScoreCard() {
		return "0-0";
	}
	
	
	private static String display(int score) {
		switch(score){
		case 0: return "0";
		case 1: return "15";
		case 2: return "30";
		case 3: return "40"; 
		case 4: return "A";
		default: return null;
		} 
	}
	
	public void gameWin(String player) {
		set.point(player);
	}
	
	/**
	 * method to display game points
	 * @return
	 */
	public String scoreGame() {
		int aScore = game.getScore(game.PLAYER_A);
		int bScore = game.getScore(game.PLAYER_B);
		
		//The score in points in the current game is omitted if it is 0-0.
		if(aScore==0 && bScore == 0){
			return "";
		}
		
		//check which player serves 
		if(game.gameNumber % 2!=0){
			return printGameScore(aScore,bScore);
		}else{
			return printGameScore(bScore,aScore);
		}
		
	}
	
	public String printGameScore(int firstPrintScore, int secondPrintScore){
		
		//special tennis score display: An advantage score is shown 40-A or A-40.
		if(firstPrintScore>= TennisConstant.GAME_MIN_SCORE || secondPrintScore>= TennisConstant.GAME_MIN_SCORE){
			if(firstPrintScore > secondPrintScore){
				return display(TennisConstant.DISPLAY_AD) + "-" + display(TennisConstant.DISPLAY_40);
			}else if(firstPrintScore == secondPrintScore){
				return display(TennisConstant.DISPLAY_40) + "-" + display(TennisConstant.DISPLAY_40);
			}else{
				return display(TennisConstant.DISPLAY_40) + "-" + display(TennisConstant.DISPLAY_AD);
			}
		}else{
			return display(firstPrintScore) + "-" + display(secondPrintScore);
		}
		
	}
	
	/**
	 * method to display set scores
	 * @return
	 */
	private String scoreSet() {
		//check which player serves 
		if(game.gameNumber % 2!=0){
			return printSetScore(set.PLAYER_A,set.PLAYER_B);
		}else{
			return printSetScore(set.PLAYER_B,set.PLAYER_A);
		}
		
	}
	
	private String printSetScore(String firstPrintPlayer, String secondPrinPlayer){
		String setScore = "";
		for(int i = 0; i<set.tennisSetList.size(); i++){
			setScore = setScore + set.tennisSetList.get(i).getScore(firstPrintPlayer) + "-" + set.tennisSetList.get(i).getScore(secondPrinPlayer) + " ";
		}	
		setScore = setScore + set.getScore(firstPrintPlayer) + "-" + set.getScore(secondPrinPlayer);
		return setScore;
	}
}
