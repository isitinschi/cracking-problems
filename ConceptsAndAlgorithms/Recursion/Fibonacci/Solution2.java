import java.util.Scanner;

class Solution2 {
	
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("n = ");
		int n = s.nextInt();
		
		System.out.println(f(n));
	}
	
	private static int f(int n) {
		int first = 0;
		int second = 1;
		
		if (n < 0) {
			return -1; //error
		} else if (n == 0) {
			return first; 
		} else if (n == 1) {
			return second;
		} else {
			int fibonacci = 0;
			for (int i = 2; i <= n; ++i) {
				fibonacci = first + second;
				
				int tmp = second;
				second += first;
				first = tmp;
				
			}
			return fibonacci;
		}
	}
	
}