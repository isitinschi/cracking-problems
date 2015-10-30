public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (isPeak(nums, i)) {
                return i;
            }
        }        

        return -1;
    }    

    private boolean isPeak(int [] nums, int i) {
        boolean gLeft = false;
        boolean gRight = false;  

        gLeft = (i == 0) ? true : nums[i] > nums[i - 1];
        gRight = (i == nums.length - 1) ? true : nums[i] > nums[i + 1];       

        return gLeft&&gRight;
    }

}