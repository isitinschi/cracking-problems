public class Solution {
	
    public int countPrimes(int n) {
        if (n < 1) {
            return 0;
        }
        
        boolean [] primes = new boolean[n];
        for (int i = 2; i < n; ++i) {
            primes[i] = true;
        }        

        // Sieve of Eratosthenes
        for (int i = 2; i*i < n; ++i) {
            if (primes[i]) {
                for (int j = i; j*i < n; ++j) {
                    primes[i*j] = false;
                }
			}
        }        

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (primes[i]) {
                ++count;
            }
        }        

        return count;
    }

}