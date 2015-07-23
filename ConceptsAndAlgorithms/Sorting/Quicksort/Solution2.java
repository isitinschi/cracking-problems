// 3-way partition
public class Solution2 {
	
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
			int p = start + (end - start) / 2;		
			swap(array, start, p);
			int pivot = array[start];
			
			int lo = start + 1;
			int i = lo;
			int hi = end;
			while (i <= hi) {
				if (array[i] < pivot) {
					swap(array, i++, lo++);
				} else if (array[i] > pivot) {
					swap(array, i, hi--);
				} else {
					++i;
				}
			}
			
			swap(array, start, lo - 1);
			
			quicksort(array, start, lo - 1);
			quicksort(array, hi + 1, end);
		}
	}
	
	private static int partition(int [] array, int start, int end) {
		int p = start + (end - start) / 2;		
		swap(array, start, p);
		int pivot = array[start];
		
		int lo = start + 1;
		int i = lo;
		int hi = end;
		while (i <= end) {
			if (array[i] < pivot) {
				swap(array, i++, lo++);
			} else if (array[i] > pivot) {
				swap(array, i, hi--);
			} else {
				++i;
			}
		}
		
		return lo;
	}
	
	private static void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		
}