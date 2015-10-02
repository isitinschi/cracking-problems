public class Solution {    

    private static final int NUM = 'Z' - 'A' + 1;
    private static final int MIN = 'A';    

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }        

        int n = 0;
        int mult = 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            n += mult * (Integer.valueOf(s.charAt(i)) - MIN + 1);
            mult *= NUM;
        }        

        return n;
    }

}