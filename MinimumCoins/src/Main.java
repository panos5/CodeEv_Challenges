import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	
	
	public void calculateMinimumCoins() throws IOException{
		
		readTheFile();
		int number;
		int modByFive;
		int divisonByFive;
		int divByThree = 0 ;
		int coins = 0;
		
		for (int line = 0 ; line < textData.length ; line++){

			   number = Integer.parseInt(textData[line]);
			   modByFive = number % 5;
			   divisonByFive = number / 5;
		
				   if( modByFive%5 == 0 && number >=5 ){
					   
					   coins = divisonByFive;
				   }
				   
				   else{
					   
					   if( modByFive%3 == 0 && number>=3){
						   
						   divByThree =  divisonByFive + modByFive/3;
						   coins = divByThree;
					   }
					   else{ 
						   
						   if((modByFive%3)%1 == 0){						   
							   coins = divisonByFive + modByFive/3 + modByFive/1;
						   }
					   }
				   } 
				   System.out.println(coins);  
			  }
			  
		}	

	
	public static void main(String args[]) throws IOException{
		
		//path = args[0];
		//path = "/Users/Panos/Documents/GitHub Projects/CodeEv_Challenges/MinimumCoins/Sample_Data";
		path = "E:/GiHub Projects/CodeEv_Challenges/MinimumCoins/Sample_Data"; 
		Main test1 = new Main();
		test1.calculateMinimumCoins();
		System.exit(0);
	}	
}
