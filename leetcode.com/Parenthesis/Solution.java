public class Solution {

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        generateParanthesis(list, new StringBuilder(), 0, 0, n);        

        return list;
    }

    private void generateParanthesis(List<String> list, StringBuilder builder, int opened, int closed, int n) {
        if (opened == closed && opened == n) {
            list.add(builder.toString());
            return;
        }

        if (closed < opened) {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append(")");
            generateParanthesis(list, newBuilder, opened, closed + 1, n);
        }

        if (opened < n) {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append("(");
            generateParanthesis(list, newBuilder, opened + 1, closed, n);
        }
    }    

}