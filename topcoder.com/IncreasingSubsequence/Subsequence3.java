import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Subsequence3 {
	
	public int lis(int[] array) {
		if (array == null) {
			return 0;
		} else if(array.length < 2) {
			return array.length;
		}
		
		List<Integer> tailList = new ArrayList<>();
		for (int i = 0; i < array.length; ++i) {
			int tail = array[i];
			int pos = Collections.binarySearch(tailList, tail);
			if (pos < 0) {
				pos = -1*(pos + 1); // insertion point
			}
			if (pos == tailList.size()) {
				tailList.add(tail);
			} else {
				tailList.set(pos, tail);
			}
		}
		
		return tailList.size();
	}
	
	public static void main(String[] args) {
		Subsequence3 subsequence = new Subsequence3();
		test(subsequence);
		
		int [] input = generate(10);
		int res = subsequence.lis(input);
		System.out.println("Longest increasing subsequence: " + res);
	}
	
	public static void test(Subsequence3 subsequence) {
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