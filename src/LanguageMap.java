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

	public LanguageMap(String lang, Scanner wordSource) {
		this.myLanguage=lang;
		wordMap = new HashMap<String, TreeSet<String>>();
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
		if (!wordMap.containsKey(sortedWord)) return null;
		return (String[]) wordMap.get(sortedWord).toArray();
	}
}
