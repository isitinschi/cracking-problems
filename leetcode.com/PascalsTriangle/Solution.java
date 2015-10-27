public class Solution {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new LinkedList<List<Integer>>();
        }        

        List<List<Integer>> list = new LinkedList<>();
        List<Integer> firstRow = new LinkedList<>();
        firstRow.add(1);
        list.add(firstRow);        

        int row = 1;
        while (row < numRows) {
            List<Integer> prevRowList = list.get(row - 1);
            List<Integer> curRowList = new LinkedList<>();
            for (int i = 0; i <= prevRowList.size(); ++i) {
                int left = getValue(prevRowList, i - 1);
                int cur = getValue(prevRowList, i);
                curRowList.add(left + cur);
            }
            list.add(curRowList);
            ++row;
        }        

        return list;
    }    

    private int getValue(List<Integer> list, int i) {
        if (i < 0 || i == list.size()) {
            return 0;
        } else {
            return list.get(i);
        }
    }

}