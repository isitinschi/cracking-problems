import java.util.List;
import java.util.ArrayList;

class Solution1 {
	
	public static void main(String... args) {
		int [] set = {0,1,2,3,4,5};
		findSubsets(set);
	}
	
	private static void findSubsets(int [] set) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		addSubsets(set, set.length - 1, subsets);
		for (List<Integer> list : subsets) {
			for (Integer value : list) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	private static void addSubsets(int [] set, int index, List<List<Integer>> subsets) {
		if (index >= 0) {
			int value = set[index];
			List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
			for (List<Integer> subset : subsets) {
				List<Integer> newSubset = new ArrayList<Integer>(subset);
				newSubset.add(value);
				newSubsets.add(newSubset);
			}
			List<Integer> oneElementList = new ArrayList<Integer>();
			oneElementList.add(value);
			newSubsets.add(oneElementList);
			
			subsets.addAll(newSubsets);
			addSubsets(set, index - 1, subsets);
		}
	}
	
}