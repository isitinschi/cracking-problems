public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }        

        int pos = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                ++pos;
            } else {
                nums[i - pos] = nums[i];
            }
        }        

        return nums.length - pos;
    }

}