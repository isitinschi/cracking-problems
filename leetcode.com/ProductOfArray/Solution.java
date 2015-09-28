public class Solution {
	
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }    

        int [] cMults = new int [nums.length];
        cMults[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            cMults[i] = cMults[i - 1] * nums[i];
        }        

        int [] output = new int[nums.length];
        int mult = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            output[i] = cMults[i - 1] * mult;
            mult *= nums[i];
        }
        output[0] = mult;       

        return output;
    }

}