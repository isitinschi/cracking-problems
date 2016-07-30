/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    private int left = 1;
    private int right = -1;
    
    public int guessNumber(int n) {
        if (right == -1) {
            right = n;
        }
        
        int result;
        int guess;
        
        do {
            guess = left + (right - left) / 2;
            result = guess(guess);
            if (result < 0) {
                right = guess - 1;
            } else if (result > 0) {
                left = guess + 1;
            }
        } while (result != 0);
        
        return guess;
    }
}