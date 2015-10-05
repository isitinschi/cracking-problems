public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }        

        char [] c1 = s.toCharArray();
        char [] c2 = t.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);        

        for (int i = 0; i < c1.length; ++i) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }        

        return true;
    }

}