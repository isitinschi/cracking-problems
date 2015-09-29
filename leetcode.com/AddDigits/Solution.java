public class Solution {

    public int addDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Bad input");
        } else if (num < 10) {
            return num;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

}