public class Solution2 {
	
	public int calc(int [] array, int a, int b) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
		int count = 0;
		
		for (int start = 0; start < array.length; ++start) {
			for (int end = start; end < array.length; ++end) {
				int sum = sum(array, start, end);
				if (sum >= a && sum <= b) {
					++count;
				}
			}
		}
		
		return count;
	}
	
	private int sum(int [] array, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; ++i) {
			sum += array[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int [] array = new int [] {1,2,3};
		System.out.println(solution.calc(array, 0, 3));
	}
	
}