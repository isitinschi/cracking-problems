public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }        

        boolean over = true;
        for (int i = 0; i < digits.length; ++i) {
            if (digits[i] != 9) {
                over = false;
                break;
            }
        }        

        int n = digits.length;
        int [] result = null;
        if (over) {
            result = new int[n + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; ++i) {
                result[i] = 0;
            }
        } else {
            result = new int[n];
            boolean added = false;
            int toAdd = 1;
            for (int i = digits.length - 1; i >= 0; --i) {
                if (added) {
                    result[i] = digits[i];
                } else if (digits[i] + toAdd <= 9) {
                    result[i] = digits[i] + toAdd;
                    added = true;
                } else {
                    result[i] = (digits[i] + toAdd) % 10;
                    toAdd = (digits[i] + toAdd) / 10;
                }
            }
        }        

        return result;
    }

}