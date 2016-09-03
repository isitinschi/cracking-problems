import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        if (s == null || s.isEmpty()) {
            return 1;    
        }
        
        if (s.length() % 2 != 0) {
            return 0;    
        }
        
        Map<Character, Character> mapOpenToClose = prepareMap();
        
        Stack<Character> stack = new Stack<>();        
        char [] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            char bracket = array[i];
            if (mapOpenToClose.keySet().contains(bracket)) {
                stack.push(mapOpenToClose.get(bracket));    
            } else {
                if (stack.isEmpty() || stack.peek() != bracket) {
                    return 0;    
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            return 0;    
        }
        
        return 1;
    }
    private Map<Character, Character> prepareMap() {
        Map<Character, Character> mapOpenToClose = new HashMap<>();
        mapOpenToClose.put('(', ')');
        mapOpenToClose.put('[', ']');
        mapOpenToClose.put('{', '}');
        
        return mapOpenToClose;
    }
}