public class Solution {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        if (nums.length == 1) {
            return nums[0];
        }        

        int number = 0;
        for (int i = 0; i < 32; ++i) {
            int mask = 1 << i;
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                if ((nums[j] & mask) != 0) {
                    ++sum;
                }
            }

            if (sum % 3 != 0) {
                number = number | mask;
            }
        }        

        return number;
    }

}