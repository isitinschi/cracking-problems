public class Solution {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }       

        int n = nums.length;
        if (n == 1) {
            return n - nums[0];
        }   

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }       

        return (n + 1)*(0 + n) / 2 - sum;
    }

}