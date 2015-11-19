public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return prefix.toString();
        }        

        int index = 0;
        while (true) {
            char c = 0;
            for (int i = 0; i < strs.length; ++i) {
                if (index >= strs[i].length()) {
                    return prefix.toString();
                }
                if (i == 0) {
                    c = strs[0].charAt(index);
                } else if (c != strs[i].charAt(index)) {
                    return prefix.toString();
                }
            }

            prefix.append(c);
            ++index;
        }
    }

}