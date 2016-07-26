public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        char [] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            char c = array[i];
            array[i] = array[j];
            array[j] = c;
            ++i;
            --j;
        }
        
        return new String(array);
    }
}