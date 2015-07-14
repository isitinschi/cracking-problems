class Solution {
	
	public static void main(String... args) {
		int [] array = {9,8,7,6,5,4,3,2,1};
		quicksort(array, 0, array.length);
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
	
	private static void quicksort(int [] array, int start, int end) {
		if (start < end) {
			int p = partition(array, start, end);
			quicksort(array, start, p);
			quicksort(array, p + 1, end);
		}
	}
	
	private static int partition(int [] array, int start, int end) {
		int p = (start + end) / 2;		
		swap(array, start, p);
		p = start;
		
		int l = start + 1;
		int g = end - 1;
		while (l < g) {
			while (l < g && array[l] <= array[p]) {
				++l;
			}
			while (g > l && array[g] > array[p]) {
				--g;
			}
			if (l < g) {
				swap(array, l++, g--);
			}
		}
		swap(array, p, --l);
		return l;
	}
	
	private static void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
		
}