class Solution {
    public int solution(int X, int Y, int D) {
        if (X >= Y) {
            return 0;    
        } else if ((Y - X) % D == 0) {
            return (Y - X) / D;    
        } else {
            return (Y - X) / D + 1;    
        }
    }
}