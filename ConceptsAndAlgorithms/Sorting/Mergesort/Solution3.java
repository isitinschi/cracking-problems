class Solution3 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		mergesort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void mergesort(int [] array) {
		for (int block = 1; block < array.length; block *= 2) {
			for (int start = 0; start < array.length; start += 2*block) {
				int mid = Math.min(start + block, array.length);
				int end = Math.min(start + 2*block, array.length);
				merge(array, start, mid, end);
			}
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