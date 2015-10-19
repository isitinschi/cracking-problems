public class Solution2 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		//int [] array = {1,2,3,4,5,6,7,8,9};
		heapsort(array);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void heapsort(int [] array) {
		heapify(array);
		
		int N = array.length - 1;
		while (N > 0) {
			swap(array, 0, N--);
			moveDown(array, 0, N);
		}
	}
	
	private static void heapify(int [] array) {
		for (int i = array.length / 2; i >= 0; --i) {
			moveDown(array, i, array.length - 1);
		}
	}
	
	private static void moveDown(int [] array, int i, int N) {
		if (i <= N) {
			int max = i;
			if (i*2 + 1 <= N && array[max] < array[i*2 + 1]) {
				max = i*2 + 1;
			}
			if (i*2 + 2 <= N && array[max] < array[i*2 + 2]) {
				max = i*2 + 2;
			}
			if (max != i) {
				swap(array, max, i);
				moveDown(array, max, N);
			}
		}
	}
	
	private static void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		
}