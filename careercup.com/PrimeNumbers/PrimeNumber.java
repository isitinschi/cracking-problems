public class PrimeNumber {
	
	public void print(int a, int n) {
		while (n != 0) {
			if (isPrime(++a)) {
				--n;
			}
		}
		System.out.println(a);
	}
	
	private boolean isPrime(int a) {
		if (a == 2) {
			return true;
		} else if(a < 2 || a % 2 == 0) {
			return false;
		}
		for (int i = 3; i*i <= a; i += 2) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		PrimeNumber primeNumber = new PrimeNumber();
		primeNumber.print(3, 5);
	}
}