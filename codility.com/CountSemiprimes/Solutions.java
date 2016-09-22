import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        int [] numbers = new int[N + 1]; // 0 - usual, 1 - prime, 2 - semiprime
        for (int i = 2; i <= N; ++i) {
            numbers[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(N); ++i) {
            if (numbers[i] == 1) {
                for (int j = i; j*i <= N; ++j) {
                    numbers[j*i] = 0;    
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (numbers[i] == 1) {
                primes.add(i);
            }
        }
        
        for (int i = 0; i < primes.size(); ++i) {
            for (int j = i; j < primes.size(); ++j) {
                int mult = primes.get(i) * primes.get(j);
                if (mult >= 4 && mult <= N) { // 4 is the first possible semiprime number, mult can be negative (overflow)
                    numbers[mult] = 2;    
                } else {
                    break;    
                }
            }         
        }
        
        int [] counts = new int[N + 1];
        int count = 0;
        for (int i = 4; i <= N; ++i) {
            counts[i] = count;
            if (numbers[i] == 2) {
                // System.out.println("Found semiprime = " + i);
                ++count;    
            }
        }
        
        int [] results = new int[P.length];
        for (int i = 0; i < P.length; ++i) {
            int start = P[i];
            int end = Q[i];
            if (numbers[end] == 2) {
                results[i] = 1;
            } else {
                results[i] = 0;
            }
            results[i] += counts[end] - counts[start];
        }
        
        return results;
    }
}