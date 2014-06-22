package magic_trick;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import codejam.InputOutput;

public class MagicTrick {
	
	protected ArrayList<String> firstGuessList;
	protected ArrayList<String> finalGuessList;
	
	public MagicTrick(){
		this.firstGuessList = null;
		this.finalGuessList = null;
	}
	
	public void firstGuess(int rowNumber, String[][] cards){
		firstGuessList = getGuessCards(rowNumber, cards);
	}
	
	public void finalGuess(int rowNumber, String[][] cards){
		finalGuessList = getGuessCards(rowNumber, cards);
	}
	
	public String finishTrick(){
		int numMatches = 0;
		String match = "";
		for(int i = 0; i < firstGuessList.size(); ++i){
			if(finalGuessList.contains(firstGuessList.get(i))){
				numMatches++;
				match = firstGuessList.get(i);
			}
		}
		System.out.println("Num matches: "+numMatches);
		if(numMatches == 1){
			return match;
		}else if(numMatches > 1){
			return "Bad Magician!";
		}else{
			return "Volunteer Cheated!";
		}
	}
	
	private ArrayList<String> getGuessCards(int rowNumber, String[][] cards){
		ArrayList<String> list = new ArrayList<String>();
		rowNumber-=1;
		for(int i = 0; i < cards[rowNumber].length; ++i){
			list.add(cards[rowNumber][i]);
		}
		System.out.println(list);
		return list;
	}
	
	public static void main(String[] args){
		MagicTrick trick = new MagicTrick();
		InputOutput io = new InputOutput();
		ArrayList<String> lines = io.loadInputFile("c:\\eclipse-workspace\\codejam\\src\\magic_trick\\input_files\\A-small-practice.in");
		int numCases = Integer.parseInt(lines.get(0));
		int offset = 0;
		String[][] originalCards = new String[4][4];
		String[][] newCards = new String[4][4];
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 1; i <= numCases; ++i){
			System.out.println("Test Case "+i);
			offset = (i-1)*10;
			originalCards[0] = lines.get(2+offset).split(" ");
			originalCards[1] = lines.get(3+offset).split(" ");
			originalCards[2] = lines.get(4+offset).split(" ");
			originalCards[3] = lines.get(5+offset).split(" ");
			newCards[0] = lines.get(7+offset).split(" ");
			newCards[1] = lines.get(8+offset).split(" ");
			newCards[2] = lines.get(9+offset).split(" ");
			newCards[3] = lines.get(10+offset).split(" ");
			trick.firstGuess(Integer.parseInt(lines.get(1+offset)), originalCards);
			trick.finalGuess(Integer.parseInt(lines.get(6+offset)), newCards);
			output.add("Case #"+i+": "+trick.finishTrick());
		}
		System.out.println(io.writeOutputFile("c:\\eclipse-workspace\\codejam\\src\\magic_trick\\output_files\\A-small-practice.out", output));
	}
}	