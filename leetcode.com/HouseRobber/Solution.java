public class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        

        int size = nums.length;        

        int [] best = new int [size];
        if (size > 0) {
            best[0] = nums[0];
        }
        if (size > 1) {
            best[1] = Math.max(nums[0], nums[1]);
        }        

        for (int i = 2; i < size; ++i) {
            best[i] = Math.max(nums[i] + best[i - 2], best[i - 1]);
        }        

        return best[size - 1];
    }   

}