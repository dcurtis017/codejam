package store_credit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class StoreCredit{
	public String itemsToPurchase(TestCase tc){
		//Case #1: 2 3
		for(int i = 0; i < tc.items.length; ++i){
		 if(tc.items[i] < tc.creditAmount){
			for(int j = 0; j < tc.items.length; ++j){
				if(j!=i && tc.items[j] < tc.creditAmount && tc.items[i]+tc.items[j] == tc.creditAmount){
					String itemString = (i<j)?(i+1)+" "+(j+1):(j+1)+" "+(i+1);
					return "Case #"+tc.caseNumber+": "+ itemString;
				}
			}
		 }
		}
		return "";
	}
	
	public static void main(String[] args){
		/**
		 * Case #1: 2 3
Case #2: 1 4
Case #3: 4 5
		 */
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			ArrayList<TestCase> cases = new ArrayList<TestCase>();
			String sCurrentLine;			 
			br = new BufferedReader(new FileReader("c:\\eclipse-workspace\\codejam\\src\\store_credit\\input_files\\A-large-practice.in"));
			int totalCases = 0;
			int numItems = 0;
			int lineCt = 0;
			int storeCredit = 0;
			int caseNumber = 1;
			while ((sCurrentLine = br.readLine()) != null) {
				if(lineCt == 0){
					totalCases = Integer.parseInt(sCurrentLine);
					++lineCt;
				}else if(lineCt == 1){
					storeCredit = Integer.parseInt(sCurrentLine);
					++lineCt;
				}else if(lineCt == 2){
					numItems = Integer.parseInt(sCurrentLine);
					++lineCt;
				}else if(lineCt == 3){
					cases.add(new TestCase(caseNumber, storeCredit, sCurrentLine, numItems ));
					++caseNumber;
					lineCt = 1;
				}					
			}
			File file = new File("c:\\eclipse-workspace\\codejam\\src\\store_credit\\output_files\\A-large-practice.out");
			if (!file.exists()) {
				file.createNewFile();
			}			
			bw = new BufferedWriter( new FileWriter(file.getAbsoluteFile()));
			StoreCredit sc = new StoreCredit();
			caseNumber = 0;
			for(TestCase tc: cases){
				bw.write(sc.itemsToPurchase(tc));
				if(caseNumber < totalCases-1){
					bw.newLine();
					++caseNumber;
				}
			}
			bw.flush();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			try{
				if(br!=null){br.close();}
				if(bw!=null){br.close();}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
			
	}
}
