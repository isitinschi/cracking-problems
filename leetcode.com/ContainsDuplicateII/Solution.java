public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }        

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }        

        return false;
    }

}