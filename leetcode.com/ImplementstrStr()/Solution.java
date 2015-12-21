public class Solution {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }        

        char [] s = haystack.toCharArray();
        char [] p = needle.toCharArray();        

        int [] prefixTable = buildPrefixTable(p);        

        int i = 0;
        int j = 0;
        while (i < s.length) {
            if (s[i] == p[j]) {
                ++j;
                ++i;
                if (j == p.length) {
                    return i - p.length;
                }
            } else {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    ++i;
                }
            }
        }        

        return -1;
    }    

    private int [] buildPrefixTable(char [] p) {
        int [] prefixTable = new int[p.length];
        
        int length = 0;
        int i = 1;
        while (i < p.length) {
            if (p[i] == p[length]) {
                prefixTable[i] = ++length;
                ++i;
            } else {
                if (length != 0) {
                    length = prefixTable[length - 1];
                } else {
                    ++i;
                }
            }
        }        

        return prefixTable;
    }

}