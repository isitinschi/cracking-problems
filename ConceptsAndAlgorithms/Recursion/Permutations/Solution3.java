import java.util.List;
import java.util.ArrayList;

class Solution3 {
	
	public static void main(String... args) {
		String s = "abc";
		List<String> list = permutations(s);
		for (String permutation : list) {
			System.out.println(permutation);
		}
	}
	
	private static List<String> permutations(String s) {
		List<String> permutations = new ArrayList<>();
		if (s != null) {			
			if (s.isEmpty()) {
				permutations.add("");
			} else {
				Character c = s.charAt(0);
				permutations = permutations(s.substring(1, s.length()));
				List<String> newPermutations = new ArrayList<>();
				for (String permutation : permutations) {
					for (int i = 0; i <= permutation.length(); ++i) {
						newPermutations.add(insert(permutation, c, i));
					}
				}
				permutations = newPermutations;
			}
		}
		
		return permutations;
	}
	
	private static String insert(String s, char c, int pos) {
		return s.substring(0, pos) + c + s.substring(pos, s.length());
	}
		
}