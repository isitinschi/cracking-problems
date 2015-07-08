import java.util.List;
import java.util.ArrayList;

public class CheatCode {
	
	public int[] matches(String keyPresses, String[] codes) {
		List<Integer> matches = new ArrayList<Integer>();
		
		for (int i = 0; i < codes.length; ++i) {
			boolean match = false;
			for (int j = 0; !match && j < keyPresses.length(); ++j) {
				int index1 = j;
				int index2 = 0;
				while (keyPresses.charAt(index1) == codes[i].charAt(index2)) {
					++index1;
					++index2;
					if (index2 == codes[i].length()) {
						match = true;
						break;
					}
					if (index1 == keyPresses.length()) {
						break;
					}
					if(keyPresses.charAt(index1) != codes[i].charAt(index2)
							&& keyPresses.charAt(index1) == keyPresses.charAt(index1 - 1)) {
						++index1;
						if (index1 == keyPresses.length()) {
							break;
						}
					}
				}
			}
			if (match) {
				matches.add(i);
			}
		}
		
		return matches.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String [] args) {
		CheatCode cheatCode = new CheatCode();
		String key = "AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYY";
		String [] codes = new String [] {"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI",
				 "FGHIJ", "GHIJK", "HIJKL", "IJKLM", "JKLMN",
				 "KLMNO", "LMNOP", "MNOPQ", "NOPQR", "OPQRS",
				 "PQRST", "QRSTU", "RSTUV", "STUVW", "TUVWX",
				 "UVWXY", "VWXYZ", "WXYZA", "XYZAB", "YZABC",
				 "ZABCD"};
		System.out.println("Matches:");
		int [] matches = cheatCode.matches(key, codes);
		for (int i = 0; i < matches.length; ++i) {
			System.out.print(matches[i] + " ");
		}
	}
	
}