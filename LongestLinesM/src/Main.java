import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
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
		
			
			//System.out.println(textData[line].length());
			wordsAndSize.put(textData[line], textData[line].length());
		}
		
		for (Map.Entry<String,Integer> entry : entriesSortedByValues(wordsAndSize)){
			
			int k = entry.getValue();
			String v = entry.getKey();
			System.out.println(v + "  " + k);
			
		}
				
	}
	
	
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                
            	@Override
            	public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
            	}
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

	
	
	public static void main(String args[]){
		
		//path = args[0];
		path = "/Users/Panos/Documents/GitHub Projects/CodeEv_Challenges/LongestLinesM/Sample_Data";
		Main test1 = new Main();
		
		try {
		
			test1.getLongestLines();
		} 
		catch (IOException e) {
			System.out.println("File Error : " + e.getMessage());
		}
					
	}
	
}
