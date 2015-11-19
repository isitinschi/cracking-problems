public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list; // nothing to do
        }        

        for (int i = 0; i < nums.length; ++i) {
            StringBuilder builder = new StringBuilder();
            builder.append(nums[i]);           

            int j = i;
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                ++j;
            }            

            if (i != j) {
                builder.append("->");
                builder.append(nums[j]);
                i = j;
            }            

            list.add(builder.toString());
        }        

        return list;
    }

}