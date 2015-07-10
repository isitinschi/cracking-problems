import java.util.Arrays;
import java.util.Comparator;

class Solution {
	
	public static void main(String... args) {
		String [] array = new String [] {"abcd", "dcba", "1234", "ab12", "2145", "cbda"};
		
		// print
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				char [] c1 = s1.toCharArray();
				char [] c2 = s2.toCharArray();
				Arrays.sort(c1);
				Arrays.sort(c2);
				return new String(c1).compareTo(new String(c2));
			}
		});
		
		// print
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
		
}