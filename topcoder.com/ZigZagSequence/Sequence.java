import java.util.Random;

public class Sequence {
	
	public int zigZag(int [] array) {
		int n = array.length;
		int [] up = new int[n];
		int [] down = new int[n];
		
		for (int i = 0; i < n; ++i) {
			up[i] = 1;
			down[i] = 1;
		}
		
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (array[j] < array[i] && down[j] + 1 > up[i]) {
					up[i] = down[j] + 1;
				} else if (array[j] > array[i] && up[j] + 1 > down[i]) {
					down[i] = up[j] + 1;
				}
			}
		}
		
		int max = 1;
		for (int i = 0; i < n; ++i) {
			if (up[i] > max) {
				max = up[i];
			}
			if (down[i] > max) {
				max = down[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		test(sequence);
		
		int [] input = generate(10);
		int res = sequence.zigZag(input);
		System.out.println("Longest zig-zag subsequence: " + res);
	}
	
	public static void test(Sequence sequence) {
		int [] array1 = {1};
		int [] array2 = {1,2};
		int [] array3 = {1,7,4,9,2,5};
		int [] array4 = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
		
		int result = sequence.zigZag(array1);
		if (result != 1) {			
			throw new RuntimeException("Test 1 is failed! Result was " + result + ", but expected 1");
		}
		result = sequence.zigZag(array2);
		if (result != 2) {
			throw new RuntimeException("Test 2 is failed! Result was " + result + ", but expected 2");
		}
		result = sequence.zigZag(array3);
		if (result != 6) {
			throw new RuntimeException("Test 3 is failed! Result was " + result + ", but expected 6");
		}
		result = sequence.zigZag(array4);
		if (result != 8) {
			throw new RuntimeException("Test 4 is failed! Result was " + result + ", but expected 8");
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