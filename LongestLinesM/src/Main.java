import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


	int numberOfLines = 0;
	String[] textData;
	static String path;
	TreeMap<String ,Integer> wordsAndSize = new TreeMap<String , Integer>();
	
	
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
	
	
	public void getLongestLines() throws IOException{
		
		readTheFile();
		
		
		for (int line = 0 ; line < textData.length ; line++){

				wordsAndSize.put(textData[line], textData.length);
		}
		
		for (Map.Entry<String,Integer> entry : wordsAndSize.entrySet()){
			
			System.out.println(entry.getKey());
			
		}
				
	}

	
	
	public static void main(String args[]){
		
		//path = args[0];
		path = "/Users/Panos/Documents/GitHub Projects/CodeEv_Challenges/NumberOfOnes/Sample_Data";
		Main test1 = new Main();
		
		try {
		
			test1.getLongestLines();
		} 
		catch (IOException e) {
			System.out.println("File Error : " + e.getMessage());
		}
					
	}
	
}
