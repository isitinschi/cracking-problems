public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }        

        Map<Character, Character> openBrackets = new HashMap<>();
        openBrackets.put('(', ')');
        openBrackets.put('[', ']');
        openBrackets.put('{', '}');        

        Map<Character, Character> closeBrackets = new HashMap<>();
        closeBrackets.put(')', '(');
        closeBrackets.put(']', '[');
        closeBrackets.put('}', '{');        

        Stack<Character> stack = new Stack<>();
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char bracket = chars[i];
            if (openBrackets.containsKey(bracket)) {
                stack.push(bracket);
            } else if (closeBrackets.containsKey(bracket)) {
                char openBracket = closeBrackets.get(bracket);
                if (stack.isEmpty() || stack.peek() != openBracket) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }        

        return stack.isEmpty();
    }

}