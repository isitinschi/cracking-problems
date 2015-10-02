public class Solution {    

    private static final int START = 'A';
    private static final int END = 'Z';
    private static final int NUM = END - START + 1;    

    public String convertToTitle(int n) {
        if (n < 1) {
            return null;
        }        

        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int i = (n - 1) % NUM;
            char c = (char) (START + i);
            n = (n - i) / NUM;
            builder.append(c);
        }        

        return builder.reverse().toString();
    }

}