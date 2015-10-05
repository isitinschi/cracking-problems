public class Solution {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return; // nothing to do
        }        

        int red = 0;
        int white = 0;
        int blue = nums.length - 1;
        int pivot = 1; // white
        while (white <= blue) {
            if (nums[white] < pivot) {
                swap(nums, white++, red++);
            } else if (nums[white] > pivot) {
                swap(nums, white, blue--);
            } else {
                ++white;
            }
        }
    }    

    private void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }    

}