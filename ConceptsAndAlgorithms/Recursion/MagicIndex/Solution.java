public class Solution {
	
	public static void main(String ... args) {
		int [] array = {-1,0,1,3,6,7,8,9};
		int magicIndex = findMagicIndex(array);
		if (magicIndex < 0) {
			System.out.println("No magic index :(");
		} else {
			System.out.println("Magic index: a[" + magicIndex + "] = " + array[magicIndex]);
		}
	}
	
	private static int findMagicIndex(int [] array) {
		return findMagicIndex(array, 0, array.length);
	}
	
	private static int findMagicIndex(int [] array, int start, int end) {
		if (start < end) {		
			int m = start + (end - start) / 2;
			if (array[m] == m) {
				return m;
			} else if (array[m] > m) {
				return findMagicIndex(array, start, m);
			} else {
				return findMagicIndex(array, m + 1, end);
			}
		}
		
		return -1;
	}
}