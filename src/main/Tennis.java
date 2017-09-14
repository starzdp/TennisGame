package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * main class of display tennis score problem
 * @author starzdp
 *
 */
public class Tennis {
	
	static ScoreCard scoreCard;
	public static String inputFileName,outputFileName;
	
	public static void main(String[] args) throws Exception {
		//read parameters from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please input inputFile name");
            inputFileName = br.readLine();
            System.out.println("Please input outputFile name");
            outputFileName = br.readLine();
            //analyze tennis match desc and output corresponding tennis score to output file
            displayTennisScore(inputFileName,outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * reads in descriptions of tennis matches and displays the current score in each match.
	 * @param inputFile
	 * @param outputFile
	 */
	private static void displayTennisScore(String inputFile, String outputFile){
		readAndWirteFile(inputFile,outputFile);
	}	
	
	/**
	 * reading tennis match desc from input file and than write the corresponding score into output file
	 */
	private static void readAndWirteFile(String inputFile, String outputFile){
		 try { 
	            String pathname = "./" + inputFile;   
	            File filename = new File(pathname);
	            if(filename.isFile() && filename.exists()){
		            InputStreamReader reader = new InputStreamReader(  
		                    new FileInputStream(filename)); 
		            BufferedReader br = new BufferedReader(reader); 
		            String line = null;
		            while ((line = br.readLine())!=null) {  
	//	                System.out.println(line);
		        		scoreCard = new ScoreCard(TennisConstant.Player_A, TennisConstant.Player_B);
		                if(!line.equals("")){
			                getWinnerInfoFromMatchDesc(line);
	//		                System.out.println(scoreCard.fullCard());
			                writeScoreToFile(scoreCard.fullCard(),outputFile);
		                }else{
		                	writeScoreToFile(scoreCard.initailScoreCard(),outputFile);
		                }
		            }  
		  
		            br.close();
	            }else{
	            	System.out.println("cannot find the input.txt file");
	            }
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	}
	
	
	/**
	 * write the final tennis score into output file
	 * @param line
	 * @param outputFile
	 */
	private static void writeScoreToFile(String line,String outputFile){
		try {
	        File writename = new File(outputFile);  
	        writename.createNewFile(); 
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writename, true)));  
	        out.write(line+"\n");  
	        out.flush(); 
	        out.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	/**
	 * get the winner of each tennis game
	 * @param winnerInfo
	 */
	private static void getWinnerInfoFromMatchDesc(String winnerInfo){
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
