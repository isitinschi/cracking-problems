public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 0;
        for (int i = 0; i < 32; ++i) {
            int mask = (1 << i);
            x = (x << 1) | ((n & mask) >>> i);
        }        

        return x;
    }

}