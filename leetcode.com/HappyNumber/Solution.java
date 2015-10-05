public class Solution {

    public boolean isHappy(int n) {
        while (n > 3) {
            int sum = 0;
            while (n > 0) {
                int i = n % 10;
                sum += i * i;
                n = (n - i) / 10;
            }
            n = sum;
            while (n % 10 == 0) {
                n /= 10;
            }
        }        

        return n == 1;
    }

}