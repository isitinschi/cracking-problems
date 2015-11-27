public class Solution {

    public List<Integer> getRow(int k) {
        if (k < 0) {
            return null;
        }        

        Integer [] row = new Integer[k + 1];
        
        row[0] = 1;        

        int size = 1;
        while (size <= k) {
            int prev = row[0];
            for (int i = 1; i < size; ++i) {
                int temp = row[i];
                row[i] += prev;
                prev = temp;
            }
            row[size] = prev;            

            ++size;
        }        

        return Arrays.asList(row);
    }

}