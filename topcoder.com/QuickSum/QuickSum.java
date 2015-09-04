import java.util.Random;

public class QuickSum {
	
	public int minSums(String numbers, int sum) {
		if (Integer.valueOf(numbers) == sum) {
			return 0;
		}
		return minSums(new StringBuilder(numbers), sum, 0, 0);
	}
	
	private int minSums(StringBuilder numbers, int sum, int i, int changes) {
		if (calc(numbers, sum)) {
			return changes;
		}
		
		if (i >= numbers.length()) {
			return -1;
		}
		
		int res = minSums(new StringBuilder(numbers), sum, i + 1, changes);
		if (i != 0 && numbers.charAt(i - 1) != '+') {
			numbers.insert(i, '+');			
			int res2 = minSums(new StringBuilder(numbers), sum, i + 2, changes + 1);
			if (res2 != -1 && res2 < res || res == -1) {
				return res2;
			}
		}
		return res;
	}
	
	private boolean calc(StringBuilder exp, int sum) {
		String [] values = exp.toString().split("\\+");
		int calc = 0;
		for (int i = 0; i < values.length; ++i) {
			calc += Integer.valueOf(values[i]);
		}
		if (calc == sum) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		QuickSum quickSum = new QuickSum();
		test(quickSum);
		
		String numbers = generate(5);
		int sum = 15;
		int res = quickSum.minSums(numbers, sum);
		System.out.println("Additions for string \"" + numbers + "\" and sum " + sum + ": " + res);
	}
	
	public static String generate(int length) {
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; ++i) {
			int value = random.nextInt(length);
			builder.append(value);
		}
		return builder.toString();
	}
	
	public static void test(QuickSum quickSum) {
		String numbers1 = "12";
		String numbers2 = "99999";
		String numbers3 = "1110";
		String numbers4 = "303";
		
		int result = quickSum.minSums(numbers1, 12);
		if (result != 0) {			
			throw new RuntimeException("Test 1 is failed! Result was " + result + ", but expected 0");
		}
		result = quickSum.minSums(numbers2, 45);
		if (result != 4) {
			throw new RuntimeException("Test 2 is failed! Result was " + result + ", but expected 4");
		}
		result = quickSum.minSums(numbers3, 3);
		if (result != 3) {
			throw new RuntimeException("Test 3 is failed! Result was " + result + ", but expected 3");
		}
		result = quickSum.minSums(numbers4, 6);
		if (result != 1) {
			throw new RuntimeException("Test 4 is failed! Result was " + result + ", but expected 1");
		}
	}
	
}