public class NumArray {    

    int [] sumF = null;
    int [] sumB = null;

    public NumArray(int[] nums) {
        if (nums != null && nums.length > 0) {
            sumF = new int[nums.length];
            sumB = new int[nums.length];            

            sumF[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                sumF[i] = sumF[i - 1] + nums[i];
            }            

            sumB[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; --i) {
                sumB[i] = sumB[i + 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sumF != null && sumB != null && i >= 0 && j >= 0 && i < sumF.length && j < sumF.length) {
            int result = sumF[sumF.length - 1];
            if (i - 1 >= 0) {
                result -= sumF[i - 1];
            }
            if (j + 1 < sumB.length) {
                result -= sumB[j + 1];
            }
            return result;
        }        

        return 0;
    }

}