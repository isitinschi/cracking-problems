public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0; // base case
        }
        int length = 0;      

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            --i;
        }        

        for (; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ++length;
            } else {
                break;
            }
        }        

        return length;
    }

}