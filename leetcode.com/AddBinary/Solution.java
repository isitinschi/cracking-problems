public class Solution {

    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }        

        StringBuilder builder = new StringBuilder();
        int i = 1;
        int rest = 0;
        while (a.length() - i >= 0 || b.length() - i >= 0) {
            int first = 0;            
            if (a.length() - i >= 0) {
                first = a.charAt(a.length() - i) - '0';
            }

            int second = 0;
            if (b.length() - i >= 0) {
                second = b.charAt(b.length() - i) - '0';
            }            

            int sum = first + second + rest;
            if (sum > 1) {
                int add = (sum) % 2;
                builder.append(add);
                rest = sum / 2;
            } else {
                builder.append(sum);
                rest = 0;
            }
            ++i;
        }        

        while (rest > 0) {
            if (rest > 1) {
                int add = (rest) % 2;
                builder.append(add);
                rest /= 2;
            } else {
                builder.append(rest);
                rest = 0;
            }
        }        

        return builder.reverse().toString();
    }

}