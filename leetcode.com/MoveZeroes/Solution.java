public class Solution {

    public void moveZeroes(int[] nums) {
        int zerosSoFar = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++zerosSoFar;
            } else {
                nums[i - zerosSoFar] = nums[i];
            }
        }        

        for (int i = nums.length - zerosSoFar; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
	
	public static void main(String[] args) {
		int array[] = new int [] {1,0,2,3,4,0,5,0,0};
		Solution solution = new Solution();
		solution.moveZeroes(array);
		for (int i = 0 ; i < array.length; ++i) {
			System.out.print(" " + array[i]);
		}
	}
	
}