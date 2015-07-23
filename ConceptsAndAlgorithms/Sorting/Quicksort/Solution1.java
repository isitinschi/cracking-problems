public class Solution1 {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		//int [] array = {1,2,3,4,5,6,7,8,9};
		quicksort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void quicksort(int [] array, int start, int end) {
		if (start < end) {
			int p = partition(array, start, end);
			quicksort(array, start, p - 1);
			quicksort(array, p + 1, end);
		}
	}
	
	private static int partition(int [] array, int start, int end) {
		int p = start + (end - start) / 2;		
		swap(array, start, p);
		int pivot = array[start];
		
		int storeIndex = start + 1;
		for (int i = start + 1; i <= end; ++i) {
			if (array[i] < pivot) {
				swap(array, i, storeIndex);
				++storeIndex;
			}
		}
		
		swap(array, start, --storeIndex);
		return storeIndex;
	}
	
	private static void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		
}