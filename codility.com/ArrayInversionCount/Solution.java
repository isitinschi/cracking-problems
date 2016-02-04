public class Solution {
    
    private static final int MAX_COUNT = 1000000000;
    
    public int solution(int[] A) {
        if (A == null || A.length < 2) {
            return 0;    
        }
        
        return count(A, 0, A.length - 1);
    }
    
    private int count(int [] array, int start, int end) {
        if (end <= start) {
            return 0;    
        }
        
        int count = 0;
        int middle = start + (end - start) / 2;
        
        int c1 = count(array, start, middle);
        int c2 = count(array, middle + 1, end);
        int c3 = merge(array, start, middle, end);
                
        if (c1 == -1 || c2 == -1 || c3 == -1 || c1 > MAX_COUNT || c2 > MAX_COUNT || c3 > MAX_COUNT) {
            return -1;    
        }
        
        count += c1 + c2 + c3;
        
        if (count > MAX_COUNT) {
            return -1;    
        }
        
        return count;
    }
    
    private int merge(int [] array, int start, int middle, int end) {
        int size = end - start + 1;
        int [] buffer = new int [size];
        for (int i = 0; i < size; ++i) {
            buffer[i] = array[i + start];    
        }
        
        int count = 0;
        
        int i1 = 0;
        int i2 = middle - start + 1;
        for (int i = start; i <= end; ++i) {
            if (i1 == middle - start + 1) {
                array[i] = buffer[i2++];    
            } else if (i2 == end - start + 1) {
                array[i] = buffer[i1++];    
            } else if (buffer[i1] > buffer[i2]) {
                count += middle - start - i1 + 1;
                array[i] = buffer[i2++];
            } else {
                array[i] = buffer[i1++];
            }
        }
        
        return count;
    }
}