import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;



public class LanguageMap {

	String myLanguage;
	
	HashMap<String, TreeSet<String>> wordMap;
	// this needs a Map that maps keys ex:  "aehr" to the 
	// Set of String { "hare", "hear", "rhea"} that have those chars

	public LanguageMap(String lang, String path) throws FileNotFoundException, URISyntaxException {
		
		this.myLanguage=lang;
		wordMap = new HashMap<String, TreeSet<String>>();
		URL url = this.getClass().getResource(path);
		Scanner wordSource = new Scanner(new File(url.toURI()));
				
		
		while(wordSource.hasNextLine()) {
			String word = wordSource.nextLine().trim().toLowerCase();
			char[] c = word.toCharArray();
			Arrays.sort(c);
			String sortedWord = new String(c);
			if(wordMap.containsKey(sortedWord)) {
				wordMap.get(sortedWord).add(word);
			}
			else {
				TreeSet<String> ts = new TreeSet<String>();
				ts.add(word);
				wordMap.put(sortedWord, ts);
			}
		}
	}
	
	public String getLanguage() {
		return myLanguage;
	}

	public String[] getWords(String s) {
		String word = s.trim().toLowerCase();
		char[] c = word.toCharArray();
		Arrays.sort(c);
		String sortedWord = new String(c);
		
		TreeSet<?> set = wordMap.get(sortedWord);
		if (!wordMap.containsKey(sortedWord)) return null;
		String[] strings = Arrays.stream(set.toArray()).toArray(String[]::new);
		return strings;
	}
}
