import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


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
	
	
	public void convertToBinary() throws IOException{
		
		readTheFile();
		int number;
		String convertedNum = null;
		
		for (int line = 0 ; line < textData.length ; line++){

				number = Integer.parseInt(textData[line].trim());
				convertedNum = Integer.toBinaryString(number);
				
				System.out.println(countOnesToWord(convertedNum));
		}
				
	}

	
	public int countOnesToWord(String number){
		
		int count = 0;
		Pattern pattern = Pattern.compile("([1])");
		Matcher matcher = pattern.matcher(number);

		while (matcher.find()) {
			count++;
		}
		return count;

	}	
	
	
	
	public static void main(String args[]){
		
		//path = args[0];
		path = "/Users/Panos/Documents/GitHub Projects/CodeEv_Challenges/NumberOfOnes/Sample_Data";
		Main test1 = new Main();
		
		try {
		
			test1.convertToBinary();
		} 
		catch (IOException e) {
			System.out.println("File Error : " + e.getMessage());
		}
					
	}
	
}


