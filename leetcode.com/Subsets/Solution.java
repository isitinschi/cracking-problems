public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, nums, new ArrayList<Integer>(), list);
        return list;
    }    

    private void subsets(int cur, int [] nums, List<Integer> subset, List<List<Integer>> list) {
        list.add(subset);
        for (int i = cur; i < nums.length; ++i) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[i]);
            subsets(i + 1, nums, newSubset, list);
        }
    }

}