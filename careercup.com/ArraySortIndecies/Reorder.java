public class Reorder {
	
	public void reorder(int [] array, int [] indecies) {
		if (array == null || array.length == 0 ||
			indecies == null || indecies.length == 0) {
				return;
		}
		if (array.length != indecies.length) {
			throw new IllegalArgumentException("Bad input");
		}
		
		for (int i = 0; i < array.length; ++i) {
			if (i != indecies[i]) {
				swap(array, i, indecies[i]);
				swap(indecies, i, indecies[i]);
			}
		}
	}
	
	private void swap(int [] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	public static void main(String [] args) {
		Reorder reorder = new Reorder();
		int [] array = new int [] {5,4,3,2,1,0};
		int [] indecies = new int [] {5,4,3,2,1,0};
		reorder.reorder(array, indecies);
		
		for (int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
	}
}