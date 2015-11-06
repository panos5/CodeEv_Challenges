package minimumcoins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinimumCoins {


	int numberOfLines = 0;
	String[] textData;
	static String path;
	
        
	public int readNumberOfLines() throws IOException{
		
		FileReader fileToCheck = new FileReader(path);
		BufferedReader linesToCount = new BufferedReader(fileToCheck);
	
		while(linesToCount.readLine() != null){		
			numberOfLines++;
		}
	
		linesToCount.close();
		return numberOfLines;
	}
        

	public String[] readTheFile() throws IOException{
		
	
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int lines = readNumberOfLines();
		textData = new String[lines];
		
		for (int i = 0 ; i < lines ; i++){
			
			textData[i] = textReader.readLine();
		}
		
		textReader.close();	
		return textData;
	}
	
	
        
	public void calulateCoins() throws IOException{
		
		
		readTheFile();
		
		for (int line = 0 ; line < textData.length ; line++){

				
                }
        }
	
	public static void main(String args[]){
		
		//path = args[0];
		path = "/Users/Panos/Documents/Eclipse Projects/ChardonnnayOrCabernet/Sample_Data";
		MinimumCoins test1 = new MinimumCoins();
		
		try {
		
			test1.guessTheWineName();
		} 
		catch (IOException e) {
			System.out.println("File Error : " + e.getMessage());
		}
					
	}
	
}


