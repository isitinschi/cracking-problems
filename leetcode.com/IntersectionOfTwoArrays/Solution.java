public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int [] {};
        }
        
        
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums1) {
            set.add(i);
        }
        
        Set<Integer> intersection = new HashSet<>();
        for (Integer i : nums2) {
            if (set.contains(i)) {
                intersection.add(i);
            }
        }
        
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}