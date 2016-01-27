public class Solution {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		//int [] array = {1,2,3,4,5,6,7,8,9};
		(new Solution()).sort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private void sort(int [] array) {
		if (array == null || array.length < 2) {
			return;
		}
				
		for (int i = 0; i < array.length - 1; ++i) {
			int min = i;
			for (int j = i + 1; j < array.length; ++j) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
	}	
	
	private void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
}