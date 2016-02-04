class Solution {
    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return -1;    
        }
        
        int size = S.length();
        
        if (size == 1) {
            return 0;    
        }
        
        if (size % 2 == 0) {
            return -1;    
        }
        
        char [] array = S.toCharArray();
        int i = 0;
        int j = size -1;
        
        while (i < size / 2) {
            if (array[i] != array[j]) {
                return -1;    
            }
            ++i;
            --j;
        }
        
        return size / 2;
    }
}