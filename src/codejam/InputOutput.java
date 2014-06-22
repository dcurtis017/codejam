package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InputOutput {
	
	private BufferedReader br;
	private BufferedWriter bw;
	
	public InputOutput(){
		br = null;
		bw = null;
	}
	
	public ArrayList<String> loadInputFile(String filePath){
		ArrayList<String> lines = new ArrayList<String>();
		try{
			br = new BufferedReader(new FileReader(filePath));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try{
					br.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}		
		return lines;
	}
	
	public String writeOutputFile(String filePath, ArrayList<String> lines){
		long fileSize = 0;
		try{
			File file = new File(filePath);
			if(!file.exists()){
				file.createNewFile();
			}
			bw = new BufferedWriter( new FileWriter(file.getAbsoluteFile()));
			for(String line: lines){
				bw.write(line);
				bw.newLine();//see if the program fails with an extra line
			}
			bw.flush();
			fileSize = file.length()/1024;
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(bw != null){
				try{
					bw.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}			
		return fileSize+" kb";
	}

}
