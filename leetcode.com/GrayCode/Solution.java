public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        if (n < 1) {
            return grayCode;
        }        

        grayCode(grayCode, 0, n);
        return grayCode;
    }

    

    private void grayCode(List<Integer> grayCode, int cur, int n) {
        if (cur < n) {
            int mask = (1 << cur);
            List<Integer> list = new ArrayList<>();
            for (int i = grayCode.size() - 1; i >= 0; --i) {
                list.add(grayCode.get(i) | mask);
            }
            grayCode.addAll(list);
            grayCode(grayCode, cur + 1, n);
        }
    }    

}