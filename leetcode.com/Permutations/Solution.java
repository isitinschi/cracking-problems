public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<List<Integer>>();
        }

        return permutations(nums, 0);
    }    

    private List<List<Integer>> permutations(int [] nums, int offset) {
        List<List<Integer>> perms = new LinkedList<>();
        if (offset == nums.length) {
            List<Integer> empty = new LinkedList<>();
            perms.add(empty);
            return perms;
        } else {
            int val = nums[offset];
            List<List<Integer>> newPerms = permutations(nums, offset + 1);
            for (List<Integer> p : newPerms) {
                for (int i = 0; i <= p.size(); ++i) {
                    List<Integer> newP = new LinkedList<>(p);
                    newP.add(i, val);
                    perms.add(newP);
                }
            }

            return perms;
        }
    }

}