class Solution {
    public Integer solution(int[] A) {
        if (A == null || A.length == 0 || A.length % 2 == 0) {
            return null;
        }
        
        int xor = 0;
        for (Integer v : A) {
            xor = xor ^ v;
        }
        
        return xor;
    }
}