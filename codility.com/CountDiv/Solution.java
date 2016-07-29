class Solution {
    public int solution(int A, int B, int K) {
        int tillA = calcTill(A - 1, K);
        int tillB = calcTill(B, K);
        
        return tillB - tillA;
    }
    
    private int calcTill(int till, int k) {
        if (till < 0) {
            return 0;
        } else if (till == 0) {
            return 1;
        } else {
            return till / k + 1;
        }
    }
}