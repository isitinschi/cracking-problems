import java.util.Arrays;
import java.lang.reflect.Array;
import java.lang.Comparable;

public class OrderStatistic<T extends Comparable<T>> {
	
	public T findKthSmallest(T [] array, int k) {		
		validateInputParameters(array, k);
		return findKthSmallest(array, 0, array.length, k);
	}
	
	public T findKthLargest(T [] array, int k) {
		validateInputParameters(array, k);
		return findKthLargest(array, 0, array.length, k);
	}
	
	private void validateInputParameters(T [] array, int k) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("Array is null or empty");
		}
		if (k < 0 || k >= array.length) {
			throw new IllegalArgumentException("Wrong k = " + k);
		}
	}	
	
	private T findKthSmallest(T [] array, int l, int r, int k) {
		T medianOfMedians = findMedianOfMedians(array, l, r);		
		int pos = partition(array, l, r, medianOfMedians);
		
		if (pos == k) {
			return array[k];
		} else if (pos > k) {
			return findKthSmallest(array, l, pos, k);
		} else {
			return findKthSmallest(array, pos + 1, r, k);
		}
	}
	
	private T findKthLargest(T [] array, int l, int r, int k) {		
		T medianOfMedians = findMedianOfMedians(array, l, r);		
		int pos = partition(array, l, r, medianOfMedians);
		
		if (array.length - k - 1 == pos) {
			return array[array.length - k - 1];
		} else if (array.length - k - 1 > pos) {
			return findKthLargest(array, pos + 1, r, k);
		} else {
			return findKthLargest(array, l, pos, k) ;
		}
	}
	
	private T findMedianOfMedians(T [] array, int l, int r) {
		int n = r - l;
		int mediansSize = n / 5;
		if (n % 5 != 0) {
			++mediansSize;
		}
		
		T [] medians = (T []) Array.newInstance(array[0].getClass(), mediansSize);
		
		int i = l;
		int index = 0;
		while (i + 5 <= r) {
			medians[index++] = findMedian(array, i, i + 5);
			i += 5;
		}
		if (i != r) {
			medians[index] = findMedian(array, i, r);
		}
		
		if (medians.length == 1) {
			return medians[0];
		} else {
			return findKthLargest(medians, 0, medians.length, medians.length / 2);
		}
	}
	
	private T findMedian(T [] array, int l, int r) {
		Arrays.sort(array, l, r);
		return array[l + (r - l) / 2];
	}
	
	private int partition(T [] array, int l, int r, T pivot) {
		int index = l;
		for (int i = l; i < r; ++i) {
			if (array[i].compareTo(pivot) < 0) {
				T t = array[i];
				array[i] = array[index];
				array[index] = t;
				++index;
			}
		}
		return index;
	}
		
	public static void main(String[] args) {
		OrderStatistic orderStatistic = new OrderStatistic();		
		for (int k = 0; k < 10; ++k) {
			Integer [] array = new Integer[] {1,0,8,7,5,3,4,9,2,6};
			System.out.println(k + "th smallest: " + orderStatistic.findKthSmallest(array, k));
			System.out.println(k + "th lasrgest: " + orderStatistic.findKthLargest(array, k));
		}
	}
	
}