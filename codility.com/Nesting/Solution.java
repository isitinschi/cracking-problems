class Solution {
    public int solution(String s) {
        if (s == null || s.isEmpty()) {
            return 1;    
        }
        
        if (s.length() % 2 != 0) {
            return 0;    
        }
        
        int open = 0;
        char [] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == '(') {
                ++open;    
            } else {
                if (open == 0) {
                    return 0;    
                }
                --open;
            }
        }
        
        if (open != 0) {
            return 0;    
        }
        
        return 1;
    }
}