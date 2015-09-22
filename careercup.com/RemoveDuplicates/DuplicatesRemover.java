import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DuplicatesRemover<T> {
	
	public int remove(List<T> list) {
		if (list == null || list.size() < 2) {
			return list.size(); // nothing to do
		}
		
		Map<T, Boolean> map = new HashMap<>();
		for (T t : list) {
			if (map.get(t) == null) {
				map.put(t, true);
			}
		}
		
		list.clear();
		list.addAll(map.keySet());
		
		return list.size();
	}
	
	public static void main(String[] args) {
		DuplicatesRemover<Integer> remover = new DuplicatesRemover<>();
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(1);
		
		remover.remove(list);
		
		for (Integer i : list) {
			System.out.print(" " + i);
		}
	}
	
}