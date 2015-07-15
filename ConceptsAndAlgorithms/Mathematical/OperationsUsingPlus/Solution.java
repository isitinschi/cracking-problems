class Solution {
	
	public static void main(String... args) {
		System.out.println("10 + 10 = " + add(10,10));
		System.out.println("10 - 10 = " + subtract(10,10));
		System.out.println("10 * 10 = " + multiply(10,10));
		System.out.println("10 / 10 = " + divide(10,10));
		
		System.out.println("5 + 3 = " + add(5,3));
		System.out.println("5 - 3 = " + subtract(5,3));
		System.out.println("5 * 3 = " + multiply(5,3));
		System.out.println("5 / 3 = " + divide(5,3));
		
		System.out.println("5 + 10 = " + add(5,10));
		System.out.println("5 - 10 = " + subtract(5,10));
		System.out.println("5 * 10 = " + multiply(5,10));
		System.out.println("5 / 10 = " + divide(5,10));
	}
	
	private static int add(int v1, int v2) {
		return v1 + v2;
	}
	
	private static int subtract(int v1, int v2) {
		int result = Integer.MIN_VALUE;
		while (add(v2, result) != v1) {
			++result;
		}
		return result;
	}
	
	private static int multiply(int v1, int v2) {
		int sum = 0;
		for (int i = 0; i < v1; ++i, sum = add(sum, v2));
		return sum;
	}
	
	private static int divide(int v1, int v2) {
		if (v2 == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		
		int n = 0;
		while ((v1 = subtract(v1, v2)) >= 0) {
			++n;
		}
		return n;
	}
		
}