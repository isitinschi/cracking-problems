public class Solution {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,8,7,6,5,3,2,6,5,4,3,8,7,6,5,7,6,5,4,8,7,6,5,3,2,1};
		(new Solution()).sort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private void sort(int [] array) {
		if (array == null || array.length < 2) {
			return;
		}
				
		int [] bucket = new int[100]; // 99 is max possible number
		for (int i = 0; i < array.length; ++i) {
			bucket[array[i]]++;
		}
		
		int index = 0;
		for (int i = 0; i < bucket.length; ++i) {
			for (int j = 0; j < bucket[i]; ++j) {
				array[index++] = i;
			}
		}
	}
	
}