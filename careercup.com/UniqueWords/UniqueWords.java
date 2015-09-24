import java.util.Map;
import java.util.HashMap;

public class UniqueWords {
	
	public int count(String s) {
		Map<String, Integer> words = new HashMap<>();
		int lastSpace = -1;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == ' ') {
				count(s, lastSpace + 1, i, words);
				lastSpace = i;
			}
		}
		count(s, lastSpace + 1, s.length(), words);
		
		int count = 0;
		for (String word : words.keySet()) {
			if (words.get(word) == 1) {
				++count;
			}
		}
		
		return count;
	}
	
	private void count(String s, int start, int end, Map<String, Integer> words) {
		String word = s.substring(start, end);
		Integer count = words.get(word);
		if (count == null) {
			count = 0;
		}
		words.put(word, count + 1);
	}
	
	public static void main(String[] args) {
		UniqueWords uniqueWords = new UniqueWords();
		String s = "Swan swam over the sea swim Swan swim Swan";
		System.out.println("Unique words = " + uniqueWords.count(s));
	}
	
}