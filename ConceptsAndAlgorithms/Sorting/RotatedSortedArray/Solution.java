class Solution {
	
	public static void main(String... args) {
		int [] array = new int [] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int toFind = 5;
		
		System.out.println("Index: " + findIndex(array, toFind));
	}
	
	public static int findIndex(int [] array, int v) {
		return findIndex(array, 0, array.length - 1, v);
	}
	
	public static int findIndex(int [] array, int start, int end, int v) {
		if (start > end) {
			return -1;
		}
		
		int middle = (end + start) / 2;
		if (array[middle] == v) {
			return middle;
		} else if (array[end] > array[start]) {
			if (v < array[middle] && v >= array[start]) {
				return findIndex(array, start, middle - 1, v);
			} else if (v > array[middle] && v < array[end]) {
				return findIndex(array, middle + 1, end, v);
			}
		} else {
			int find = findIndex(array, start, middle - 1, v);
			if (find == -1) {
				return findIndex(array, middle + 1, end, v);
			}
		}
		
		return -1;
	}
		
}