import java.util.List;
import java.util.ArrayList;

class Solution2 {
	
	public static void main(String... args) {
		int [] set = {0,1,2,3,4,5};
		findSubsets(set);
	}
	
	private static void findSubsets(int [] set) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		addSubsets(set, subsets);
		for (List<Integer> list : subsets) {
			for (Integer value : list) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	private static void addSubsets(int [] set, List<List<Integer>> subsets) {
		int max = 1 << set.length;
		for (int i = 1; i < max; ++i) {
			int k = 0;
			List<Integer> subset = new ArrayList<Integer>();
			while (k < set.length) {
				if ((i & (1 << k)) != 0) {
					subset.add(set[k]);
				}
				++k;
			}
			subsets.add(subset);
		}
	}
	
}