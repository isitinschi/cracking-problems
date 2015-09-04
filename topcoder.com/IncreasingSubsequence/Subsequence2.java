import java.util.Random;

public class Subsequence2 {
	
	public int lis(int[] array) {
		if (array.length < 2) {
			return array.length;
		}
		
		int n = array.length;
		int [] lis = new int[n];
		
		for (int i = 0; i < n; ++i) {
			lis[i] = 1;
		}
		
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (array[i] > array[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		int max = lis[0];
		for (int i = 1; i < n; ++i) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Subsequence2 subsequence = new Subsequence2();
		test(subsequence);
		
		int [] input = generate(10);
		int res = subsequence.lis(input);
		System.out.println("Longest increasing subsequence: " + res);
	}
	
	public static void test(Subsequence2 subsequence) {
		int [] array1 = {0,1,2,3,4,5,6,7,8,9};
		int [] array2 = {9,8,7,6,5,4,3,2,1,0};
		int [] array3 = {16,3,5,19,10,12,0,15};
		int [] array4 = {1,3,3,3,2,4,6,7,8,0};
		
		int result = subsequence.lis(array1);
		if (result != 10) {			
			throw new RuntimeException("Test 1 is failed! Result was " + result + ", but expected 10");
		}
		result = subsequence.lis(array2);
		if (result != 1) {
			throw new RuntimeException("Test 2 is failed! Result was " + result + ", but expected 1");
		}
		result = subsequence.lis(array3);
		if (result != 5) {
			throw new RuntimeException("Test 3 is failed! Result was " + result + ", but expected 5");
		}
		result = subsequence.lis(array4);
		if (result != 6) {
			throw new RuntimeException("Test 4 is failed! Result was " + result + ", but expected 6");
		}
	}
	
	public static int [] generate(int length) {
		int [] array = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; ++i) {
			int value = random.nextInt(length);
			array[i] = value;
			System.out.println("A[" + i + "] = " + array[i]);
		}
		return array;
	}
}