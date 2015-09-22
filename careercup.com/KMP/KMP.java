public class KMP {
	
	public void printOccurrencies(String p, String text) {
		if (p == null || text == null) {
			return;
		}
		if (text.length() < p.length()) {
			return;
		}
		
		int [] prefixTable = calcPrefixTable(p);
		
		int i = 0;
		int j = 0;
		while (i < text.length()) {
			if (text.charAt(i) == p.charAt(j)) {
				++i;
				++j;
				if (j == p.length()) {
					System.out.println("Found at position: " + (i - j));
					j = prefixTable[j - 1];
				}
			} else {
				if (j != 0) {
					j = prefixTable[j - 1];
				} else {
					++i;
				}
			}
		}
	}
	
	private int [] calcPrefixTable(String p) {
		int [] prefixTable = new int[p.length()];		
		prefixTable[0] = 0;
		int length = 0;
		int i = 1;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(length)) {
				prefixTable[i] = ++length;
				++i;
			} else {
				if (length != 0) {
					length = prefixTable[length - 1];
				} else {
					length = 0;
					++i;
				}
			}
		}
		
		return prefixTable;
	}
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		kmp.printOccurrencies("abaaa", "adbcfabaaacdfgabaaacd");
	}
	
}