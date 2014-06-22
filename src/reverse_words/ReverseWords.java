package reverse_words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

	
	public static void main(String[] args){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			String sCurrentLine;			 
			br = new BufferedReader(new FileReader("c:\\eclipse-workspace\\codejam\\src\\reverse_words\\input_files\\B-large-practice.in"));
			File file = new File("c:\\eclipse-workspace\\codejam\\src\\reverse_words\\output_files\\B-large-practice.out");
			if (!file.exists()) {
				file.createNewFile();
			}			
			bw = new BufferedWriter( new FileWriter(file.getAbsoluteFile()));
			int totalCases = 0;
			int caseNumber = 1;
			int lineCt = 0;
			List<String> words;
			String sentence = "";
			while ((sCurrentLine = br.readLine()) != null) {
				if(lineCt > 0){
					sentence = "Case #"+caseNumber+": ";
					words = Arrays.asList(sCurrentLine.split(" "));
					Collections.reverse(words);;
					for(String word: words){
						sentence+=word+" ";
					}			
					bw.write(sentence.trim());
					if(caseNumber < totalCases){
						bw.newLine();
					}
					++caseNumber;
				}else{
					totalCases = Integer.parseInt(sCurrentLine);
				}
				++lineCt;
			}
			bw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			try{
				if(br!=null){br.close();}
				if(bw!=null){bw.close();}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
			
	}
}
