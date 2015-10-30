public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }        

        int length = 2;
        int offset = 0;
        for (int i = 2; i < nums.length; ++i) {
            nums[i - offset] = nums[i];
            if (nums[i - offset] != nums[i - offset - 1]) {
                ++length;
            } else if (nums[i - offset] != nums[i - offset - 2]) {
                ++length;
            } else {
                ++offset;
            }
        }        

        return length;
    }

}