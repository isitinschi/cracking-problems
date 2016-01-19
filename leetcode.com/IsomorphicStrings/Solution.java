public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }       

        int length = s.length();        

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);            

            if (!mapS.containsKey(sChar)) {
                mapS.put(sChar, tChar);
            } else {
                char value = mapS.get(sChar);
                if (value != tChar) {
                    return false;
                }
            }            

            if (!mapT.containsKey(tChar)) {
                mapT.put(tChar, sChar);
            } else {
                char value = mapT.get(tChar);
                if (value != sChar) {
                    return false;
                }
            }
        }        

        return true;
    }

}