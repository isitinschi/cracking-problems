class Solution {
    private int[] A;
    private int best = 0;
    private int sumSoFar = 0;
    private int minIndex = -1;
    
    public int solution(int[] A) {
        if (A == null || A.length < 4) {
            return 0;    
        }
        
        this.A = A;
        best = 0;
        sumSoFar = 0;
        minIndex = -1;        
        
        for (int i = 1; i < A.length - 1; ++i) {
            boolean willImproveSum = sumSoFar + A[i] >= sumSoFar;
            if (willImproveSum) {
                processStep(i);
                calcBest(i);
            } else if (sumSoFar > 0) {
                calcBest(i);                
                processStep(i);
            } else {
                sumSoFar = 0;
                minIndex = -1;
            }
        }
        
        return best;
    }
    
    private void calcBest(int i) {
        if (A[minIndex] <= 0) {
            best = Math.max(best, sumSoFar - A[minIndex]);    
        } else {
            if (i + 1 < A.length - 1) {
                best = Math.max(best, sumSoFar);
            } else {
                best = Math.max(best, sumSoFar - A[minIndex]);
            }
        }
    }
    
    private void processStep(int i) {
        sumSoFar += A[i];
        if (minIndex == -1 || A[i] < A[minIndex]) {
            minIndex = i;    
        }
    }
}