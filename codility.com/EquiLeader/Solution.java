class Solution {
    private int curLeaderIndex;
    private int count;
    
    public int solution(int[] A) {
        curLeaderIndex = 0;
        count = 0;
        
        int [] leaders = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            calcCurrentLeader(A, i);
            if (count > 0) {
                leaders[i] = curLeaderIndex;
            } else {
                leaders[i] = -1; // no leader at this point
            }
        }
        
        curLeaderIndex = A.length - 1;
        count = 0;
        
        int equiLeaderCount = 0;
        for (int i = A.length - 1; i > 0; --i) {
            calcCurrentLeader(A, i);
            if (count > 0 && leaders[i - 1] != -1) { // we have leaders for both parts
                if (A[curLeaderIndex] == A[leaders[i - 1]]) { // two leaders are the same
                    ++equiLeaderCount;
                }
            }
        }
        
        return equiLeaderCount;
    }
    
    private void calcCurrentLeader(int [] A, int index) {
        if (A[index] == A[curLeaderIndex]) {
            ++count;    
        } else {
            --count;    
        }
        if (count == -1) { // new leader                
            curLeaderIndex = index;
            count = 1;
        }
    }
}