public class Solution4 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		//int [] array = {1,2,3,4,5,6,7,8,9};
		mergesort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void mergesort(int [] array) {
		if (array == null || array.length < 2) {
			return; // nothing to do
		}
		int [] buffer = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			buffer[i] = array[i];
		}
		
		mergesort(array, buffer, 0, array.length);
	}
	
	private static void mergesort(int [] array, int [] buffer, int start, int end) {
		if (start + 1 < end) {
			int m = start + (end - start) / 2;
			mergesort(buffer, array, start, m);
			mergesort(buffer, array, m, end);
			merge(array, buffer, start, m, end);
		}
	}
	
	private static void merge(int [] array, int [] buffer, int start, int middle, int end) {
		int i1 = start;
		int i2 = middle;
		for (int i = start; i < end; ++i) {
			if (i1 == middle) {
				array[i] = buffer[i2++];
			} else if (i2 == end) {
				array[i] = buffer[i1++];
			} else if (buffer[i1] < buffer[i2]) {
				array[i] = buffer[i1++];
			} else {
				array[i] = buffer[i2++];
			}
		}
	}
		
}