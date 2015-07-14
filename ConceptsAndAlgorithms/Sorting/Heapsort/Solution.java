class Solution {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		heapsort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void heapsort(int [] array) {
		heapify(array);
		int n = array.length - 1;
		while (n > 0) {
			int t = array[n];
			array[n] = array[0];
			array[0] = t;
			sink(array, 0, n);
			--n;
		}
	}
	
	private static void heapify(int [] array) {
		for (int i = array.length / 2; i >= 0; --i) {
			sink(array, i, array.length);
		}
	}
	
	private static void sink(int [] array, int index, int n) {
		if (index < n) {
			int i1 = index * 2 + 1;
			int i2 = index * 2 + 2;
			int max = index;
			if (i1 < n && array[i1] > array[max]) {
				max = i1;
			}
			if (i2 < n && array[i2] > array[max]) {
				max = i2;
			}
			if (max != index) {
				int t = array[index];
				array[index] = array[max];
				array[max] = t;
				sink(array, max, n);
			}
		}
	}
		
}