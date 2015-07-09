import java.util.List;
import java.util.ArrayList;

class Solution {
	
	public static void main(String... args) {
		String s = "abc";
		List<String> list = permutations(s);
		for (String permutation : list) {
			System.out.println(permutation);
		}
	}
	
	private static List<String> permutations(String s) {
		List<String> permutations = new ArrayList<String>();
		if (s == null) {
			return null;
		} else if (s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		List<String> remainder = permutations(s.substring(1));
		for (String permutation : remainder) {
			for (int i = 0; i <= permutation.length(); ++i) {
				permutations.add(insertCharAt(permutation, s.charAt(0), i));
			}
		}
		return permutations;
	}
	
	private static String insertCharAt(String s, char c, int i) {
		return new StringBuilder(s).insert(i, c).toString();
	}
		
}