public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        
        String number = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder newNumber = new StringBuilder();
            int j = 0;
            while (j < number.length()) {
                int count = count(number, j);
                newNumber.append(count);
                newNumber.append(number.charAt(j));
                j += count;
            }
            
            number = newNumber.toString();
        }
        
        return number;
    }
    
    private int count(String s, int i) {
        int count = 1;
        int j = i + 1;
        while (j < s.length() && s.charAt(i) == s.charAt(j)) {
            ++count;
            ++j;
        }
        
        return count;
    }
}