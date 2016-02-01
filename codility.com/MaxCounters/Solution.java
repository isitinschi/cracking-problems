class Solution {
    public int[] solution(int N, int[] A) {
        int [] counters = new int[N];
        
        if (A == null) {
            return counters;    
        }
        
        int max = 0;
        int min = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == N + 1) {
                min = max;
            } else {
                counters[A[i] - 1] = Math.max(counters[A[i] - 1], min) + 1;
                max = Math.max(max, counters[A[i] - 1]);
            }
        }
        
        for (int j = 0; j < N; ++j) {
            if (counters[j] < min) {
                counters[j] = min;    
            }
        }
        
        return counters;
    }
}