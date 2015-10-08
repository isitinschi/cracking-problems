public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }        

        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            int mask = (1 << i);
            if ((n & mask) != 0) {
                ++sum;
            }
            if (sum > 1) {
                return false;
            }
        }        

        if (sum == 0) {
            return false;
        } else {
            return true;
        }
    }

}