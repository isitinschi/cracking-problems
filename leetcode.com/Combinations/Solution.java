public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(new ArrayList<Integer>(), 1, n, k, list);
        return list;
    }    

    private void combine(List<Integer> combination, int cur, int n, int k, List<List<Integer>> list) {
        if (combination.size() == k) {
            list.add(combination);
        } else {
            for (int i = cur; i <= n; ++i) {
                ArrayList<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add(i);
                combine(newCombination, i + 1, n, k, list);
            }
        }
    }

}