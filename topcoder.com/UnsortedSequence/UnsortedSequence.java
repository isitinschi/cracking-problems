import java.util.Arrays;

public class UnsortedSequence {
	
	public int[] getUnsorted(int[] s) {
		int size = s.length;
		if (size < 2) {
			return new int[] {};
		}
		
		int [] unsorted = Arrays.copyOf(s, size);
		Arrays.sort(unsorted);
		
		int i = size - 2;
		while (unsorted[i] == unsorted[size - 1]) {
			if (i == 0) {
				return new int[] {};
			}
			--i;
		}
		
		// swap
		int t = unsorted[i + 1];
		unsorted[i + 1] = unsorted[i];
		unsorted[i] = t;
		
		return unsorted;
	}
	
	public static void main(String[] args) {
		UnsortedSequence unsortedSequence = new UnsortedSequence();
		int [] array = new int [] {2,8,5,1,10,5,9,9,3,10,5,6,6,2,8,2,10};
		int [] result = unsortedSequence.getUnsorted(array);
		for (int i = 0; i < result.length; ++i) {
			System.out.print(" " + result[i]);
		}
	}
}