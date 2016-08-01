public class Solution {
    private static int startSmall = 'a';
    private static int endSmall = 'z';
    private static int startCap = 'A';
    private static int endCap = 'Z';
    private static int startNumber = '0';
    private static int endNumber = '9';
    
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        char [] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && !isLetter(array[i])) {
                ++i;
            }
            while (i < j && !isLetter(array[j])) {
                --j;
            }
            if (i < j && !equal(array[i++], array[j--])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isLetter(char c) {
        return (c >= startSmall && c <= endSmall) || (c >= startCap && c <= endCap) || (c >= startNumber && c <= endNumber);
    }
    
    private boolean equal(char c1, char c2) {
        c1 = toSmall(c1);
        c2 = toSmall(c2);
        return c1 == c2;
    }
    
    private char toSmall(char c) {
        if (c >= startCap && c <= endCap) {
            c = (char) (startSmall + (c - startCap));
        }
        
        return c;
    }
}