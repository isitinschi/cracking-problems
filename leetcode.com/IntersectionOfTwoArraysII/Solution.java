public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int [] {};
        }
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums1) {
            Integer count = map.get(i);
            if (count == null) {
                count = 1;
            } else {
                ++count;
            }
            map.put(i, count);
        }
        
        List<Integer> intersection = new LinkedList<>();
        for (Integer i : nums2) {
            Integer count = map.get(i);
            if (count != null && count > 0) {
                intersection.add(i);
                --count;
                map.put(i, count);
            }
        }
        
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}