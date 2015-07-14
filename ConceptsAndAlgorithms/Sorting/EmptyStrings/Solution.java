class Solution {
	
	public static void main(String... args) {
		String [] array = new String [] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String toFind = "ball";
		
		System.out.println("Index: " + findIndex(array, toFind));
	}
	
	public static int findIndex(String [] array, String s) {
		return findIndex(array, 0, array.length - 1, s);
	}
	
	public static int findIndex(String [] array, int start, int end, String s) {
		if (start > end) {
			return -1;
		}
		
		int middle = (start + end) / 2;
		
		while (middle >= start & array[middle].equals("")) {
			--middle;
		}
		
		if (middle < start) {
			return -1;
		}
		
		if (array[middle].equals(s)) {
			return middle;
		}
		
		if (array[middle].compareTo(s) == 1) {
			return findIndex(array, start, middle - 1, s);
		} else {
			return findIndex(array, (start + end) / 2 + 1, end, s);
		}
	}
		
}