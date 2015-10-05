// 3-way partition
public class Solution3 {
	
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
			int pivotIndex = median(array, start, end, start + (end - start) / 2);
			int pivot = array[pivotIndex];
			swap(array, start, pivotIndex);
			
			int l = start;
			int i = start + 1;
			int g = end;
			while (i <= g) {
				if (array[i] < pivot) {
					swap(array, i++, l++);
				} else if (array[i] > pivot) {
					swap(array, i, g--);
				} else {
					++i;
				}
			}
			
			quicksort(array, start, l - 1);
			quicksort(array, g + 1, end);
		}
	}
	
	private static int median(int [] array, int i1, int i2, int i3) {
		if (array[i1] < array[i2]) {
			if (array[i2] < array[i3]) {
				return i2;
			} else {
				if (array[i1] < array[i3]) {
					return i3;
				} else {
					return i1;
				}
			}
		} else {
			if (array[i2] > array[i3]) {
				return i2;
			} else {
				if (array[i1] < array[i3]) {
					return i1;
				} else {
					return i3;
				}
			}
		}
	}
	
	private static void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		
}