import java.util.Map;
import java.util.HashMap;

public class Solution {
	
	public String shortestSubstring(String s, String t1, String t2, String t3) {
		if (s == null || s.isEmpty()) {
			return null;
		}
		
		char [] array = s.toCharArray();
		
		int posT1 = s.indexOf(t1);
		int posT2 = s.indexOf(t2);
		int posT3 = s.indexOf(t3);
		
		Map<String, Integer> mapPatternToIndex = new HashMap<>();
		
		String shortestSubstring = null;
		
		while (posT1 != -1 || posT2 != -1 || posT3 != -1) {
			posT1 = process(s, t1, posT1, mapPatternToIndex);
			shortestSubstring = findShortestSubstring(shortestSubstring, s, mapPatternToIndex);
			
			posT2 = process(s, t2, posT2, mapPatternToIndex);
			shortestSubstring = findShortestSubstring(shortestSubstring, s, mapPatternToIndex);
			
			posT3 = process(s, t3, posT3, mapPatternToIndex);
			shortestSubstring = findShortestSubstring(shortestSubstring, s, mapPatternToIndex);
		}
		
		return shortestSubstring;
	}
	
	private int process(String s, String t, int index, Map<String, Integer> mapPatternToIndex) {
		if (index != -1) {
			mapPatternToIndex.put(t, index);
			return s.indexOf(t, index + 1);
		}
		
		return -1;
	}
	
	private String findShortestSubstring(String shortestSubstring, String s, Map<String, Integer> mapPatternToIndex) {
		if (mapPatternToIndex.values().size() != 3) {
			return shortestSubstring;
		}
		
		int start = s.length();
		for (Integer index : mapPatternToIndex.values()) {
			start = Math.min(start, index);
		}
		
		int end = 0;
		for (String t : mapPatternToIndex.keySet()) {
			end = Math.max(end, mapPatternToIndex.get(t) + t.length());
		}
		
		if (shortestSubstring == null || end - start < shortestSubstring.length()) {
			return s.substring(start, end);
		} else {
			return shortestSubstring;
		}
	}
	
	public static void main(String [] args) {
		Solution solution = new Solution();
		
		String s = "fwejfiwgjiwjegowjgwigu034gkwjegiowjgiojwgjw";
		String t1 = "iwj";
		String t2 = "gwi";
		String t3 = "kwjeg";
		
		System.out.println("Shortest substring: " + solution.shortestSubstring(s, t1, t2, t3));
	}
	
}