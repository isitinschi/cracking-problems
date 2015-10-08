public class Solution5 {
	
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
		
		for (int blockSize = 1; blockSize < array.length; ++blockSize) {
			for (int start = 0; start + blockSize < array.length; start += blockSize * 2) {
				int end = Math.min(start + blockSize * 2, array.length);
				merge(array, start, start + blockSize, end);
			}
		}
	}
	
	private static void merge(int [] array, int start, int middle, int end) {
		int [] buffer = new int[end - start];
		for (int i = start; i < end; ++i) {
			buffer[i - start] = array[i];
		}
		
		int i1 = 0;
		int i2 = middle - start;
		for (int i = start; i < end; ++i) {
			if (i1 == middle - start) {
				array[i] = buffer[i2++];
			} else if (i2 == end - start) {
				array[i] = buffer[i1++];
			} else if (buffer[i1] < buffer[i2]) {
				array[i] = buffer[i1++];
			} else {
				array[i] = buffer[i2++];
			}
		}
	}
		
}