public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer index = valToIndex.get(target - nums[i]);
            if (index != null) {
                return new int [] {index, i};
            } else {
                valToIndex.put(nums[i], i);
            }
        }
        
        return null;
    }
}