public class Solution {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums;
        }        

        int x = 0;
        for (int i = 0; i < nums.length; ++i) {
            x = x ^ nums[i];
        }        

        int mask = x & ~(x - 1);        

        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & mask) > 0) {
                x1 = x1 ^ nums[i];
            } else {
                x2 = x2 ^ nums[i];
            }
        }       

        return new int [] {x1, x2};
    }

}