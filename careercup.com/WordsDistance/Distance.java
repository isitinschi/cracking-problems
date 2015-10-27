import java.util.StringTokenizer;

public class Distance {
	
	public int distance(String text, String word1, String word2) {
		if (text == null || word1 == null || word2 == null ||
			text.isEmpty() || word1.isEmpty() || word2.isEmpty()) {
			return -1;
		}
		if (text.contains(word1) && text.contains(word2) && word1.equals(word2)) {
			return 0;
		}
		
		StringTokenizer tokenizer = new StringTokenizer(text);
		int lastPos1 = -1;
		int lastPos2 = -1;
		int i = 0;
		int min = Integer.MAX_VALUE;
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (token.equals(word1)) {
				lastPos1 = i;
				if (lastPos2 != -1) {
					min = Math.min(min, Math.abs(lastPos1 - lastPos2));
				}
			}
			if (token.equals(word2)) {
				lastPos2 = i;
				if (lastPos1 != -1) {
					min = Math.min(min, Math.abs(lastPos1 - lastPos2));
				}
			}
			
			++i;
		}
		
		if (min != Integer.MAX_VALUE) {
			return min;
		} else {
			return -1; // didn't find both words in given text
		}
	}
	
	public static void main(String args[]) {
		Distance d = new Distance();
		String text = "the quick the brown quick brown the frog";
		String word1 = "the";
		String word2 = "brown";
		System.out.println("Min distance is " + d.distance(text, word1, word2));
	}
}