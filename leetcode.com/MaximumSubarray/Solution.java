public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        

        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; ++i) {
            maxSoFar = Math.max(0, maxSoFar + nums[i]);
            if (maxSoFar != 0 && maxSoFar > max) {
                max = maxSoFar;
            }
        }       

        if (max >= 0) {
            return max;
        } else {
            // find max element
            max = nums[0];
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }
    }

}