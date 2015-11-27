public class Solution {

    public int romanToInt(String s) {
        int number = 0;        

        if (s == null || s.length() == 0) {
            return number;
        }        

        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            int value = getValue(chars[i]);
            if (i + 1 < chars.length && value < getValue(chars[i + 1])) {
                number -= value;
            } else {
                number += value;
            }
        }        

        return number;
    }    

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalStateException("Illegal roman character!");
        }
    }

}