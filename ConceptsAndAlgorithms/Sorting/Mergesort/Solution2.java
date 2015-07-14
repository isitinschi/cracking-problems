import java.util.Arrays;

class Solution2 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		mergesort(array, Arrays.copyOf(array, array.length), 0, array.length);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void mergesort(int [] array, int [] buffer, int start, int end) {
		if (end - start > 1) {
			int m = (start + end) / 2;
			mergesort(buffer, array, start, m);
			mergesort(buffer, array, m, end);
			merge(array, buffer, start, m, end);
		}
	}
	
	private static void merge(int [] array, int [] buffer, int start, int mid, int end) {
		int l = start;
		int g = mid;
		for (int i = start; i < end; ++i) {
			if (g == end) {
				array[i] = buffer[l++];
			} else if (l == mid) {
				array[i] = buffer[g++];
			} else if (buffer[l] < buffer[g]) {
				array[i] = buffer[l++];
			} else {
				array[i] = buffer[g++];
			}
		}
	}
		
}