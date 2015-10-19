public class Solution {

    public boolean isPalindrome(int x) {
        if (x >= 0 && x <= 9) {
            return true;
        }

        if (x < 0) {
            return false;
        }        

        int number1 = x;
        int number2 = 0;
        while (number1 > 0) {
            number2 = number2 * 10 + number1 % 10;
            number1 /= 10;
        }        

        return number2 == x;
    }

}