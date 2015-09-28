public class Solution {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        

        int l = 0;
        int g = nums.length - 1;
        while (l <= g) {
            int m = l + (g - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                g = m - 1;
            }
        }       

        return l;
    }

}