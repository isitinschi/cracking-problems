import java.util.Scanner;

class Solution1 {
	
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("n = ");
		int n = s.nextInt();
		
		System.out.println(f(n));
	}
	
	private static int f(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			return f(n - 1) + f (n - 2);
		} else {
			return -1; //error
		}
	}
	
}