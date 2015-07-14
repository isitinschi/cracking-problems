class Solution1 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		mergesort(array, 0, array.length);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void mergesort(int [] array, int start, int end) {
		if (end - start > 1) {
			int m = (start + end) / 2;
			mergesort(array, start, m);
			mergesort(array, m, end);
			merge(array, start, m, end);
		}
	}
	
	private static void merge(int [] array, int start, int mid, int end) {
		int [] buffer = new int[end - start];
		int l = start;
		int g = mid;
		for (int i = 0; i < end - start; ++i) {
			if (g == end) {
				buffer[i] = array[l++];
			} else if (l == mid) {
				buffer[i] = array[g++];
			} else if (array[l] < array[g]) {
				buffer[i] = array[l++];
			} else {
				buffer[i] = array[g++];
			}
		}
		
		for (int i = start; i < end; ++i) {
			array[i] = buffer[i - start];
		}
	}
		
}