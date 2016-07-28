public class Solution {
    private Set<Character> vowels;
    
    public Solution() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }
    
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        char [] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(array[i])) {
                ++i;
            }
            while (i < j && !vowels.contains(array[j])) {
                --j;
            }
            if (i < j) {
                swap(array, i++, j--);
            }
        }
        
        return new String(array);
    }
    
    private void swap(char [] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
    }
}