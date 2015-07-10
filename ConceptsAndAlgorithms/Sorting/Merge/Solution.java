class Solution {
	
	private static final int SIZE_B = 8;
	private static final int SIZE_A = 16;
	private static final int SIZE_BUFFER = SIZE_B;
	
	public static void main(String... args) {
		// init
		int [] a = new int[SIZE_A + SIZE_BUFFER];
		int [] b = new int[SIZE_B];
		
		for (int i = 0; i < SIZE_A; ++i) {
			a[i] = i;
			if (i < SIZE_B) {
				b[i] = i;
			}
		}
		
		// print
		for (int i = 0; i < SIZE_A; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < SIZE_B; ++i) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		// merge
		int aLast = SIZE_A - 1;
		int bLast = SIZE_B - 1;
		for (int i = SIZE_A + SIZE_B - 1; i >= 0; --i) {
			if (aLast < 0) {
				a[i] = b[bLast--];
			} else if (bLast < 0) {
				a[i] = a[aLast--];
			} else if (b[bLast] > a[aLast]) {
				a[i] = b[bLast--];
			} else {
				a[i] = a[aLast--];
			}
		}
		
		// result
		for (int i = 0; i < SIZE_A + SIZE_B; ++i) {
			System.out.print(a[i] + " ");
		}
	}
		
}