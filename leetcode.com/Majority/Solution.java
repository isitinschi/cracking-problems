public class Solution {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }        

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                count = 0;
            }
            ++count;
            if (count > nums.length / 2) {
                return nums[i];
            } else {
                map.put(nums[i], count);
            }
        }        

        return -1;
    }

}