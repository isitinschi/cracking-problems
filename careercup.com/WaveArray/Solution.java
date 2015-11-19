import java.util.Arrays;

public class Solution {
	
	public void rearrange(int [] array) {
		if (array == null || array.length < 3) {
			return;
		}
		
		Arrays.sort(array);
		
		for (int i = 1; i < array.length; i += 2) {
			int temp = array[i - 1];
			array[i - 1] = array[i];
			array[i] = temp;
		}
		
	}
	
		
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int [] array = new int [] {1,2,3,4,5,6,7,8,9};
		
		solution.rearrange(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
}