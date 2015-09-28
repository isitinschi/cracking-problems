public class Solution {
	
	public int calc(int [] array, int a, int b) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
		int sum = 0;
		int [] sums = new int[array.length - 1];
		for (int i = 0; i < array.length; ++i) {
			int cur = array[i];
			if (cur <= b && cur >= a) {
				++sum;
			}
			
			if (i + 1 != array.length) {
				sums[i] = cur + array[i + 1];

				if (i + 2 != array.length) {
					int tripple = array[i + 2] + sums[i];
					if(tripple >= a && tripple <= b) {
						++sum;
					}
				}					
			}			
					
		}
		
		if (sum != 0) {
			sum += calc(sums, a, b);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] array = new int [] {1,2,3};
		System.out.println(solution.calc(array, 0, 3));
	}
	
}