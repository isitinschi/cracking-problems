import java.util.Map;
import java.util.HashMap;

public class WolfDelaymaster {
	
	private static final String VALID = "VALID";
	private static final String INVALID = "INVALID";
	
	public String check(String str) {
		if (str == null || str.length() < 4 || str.charAt(0) != 'w' || str.length() % 4 != 0) {
			return INVALID;
		}
		
		Map<Character, Character> prevMap = new HashMap<>();
		prevMap.put('w', 'f');
		prevMap.put('o', 'w');
		prevMap.put('l', 'o');
		prevMap.put('f', 'l');
		
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); ++i) {
			if (i > 0) {
				if (str.charAt(i) != str.charAt(i - 1)) {
					if(str.charAt(i - 1) != prevMap.get(str.charAt(i))) {
						return INVALID;
					}
					if (str.charAt(i) == 'w' && !check(map)) {
						return INVALID;
					}
				}
			}
			
			Integer n = map.get(str.charAt(i));
			if (n == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), n + 1);
			}
		}
		
		if (!check(map)) {
			return INVALID;
		}
		
		return VALID;
	}
	
	private boolean check(Map<Character, Integer> map) {
		int n = map.get('w');
		if (map.get('o') != n || map.get('l') != n || map.get('f') != n) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		WolfDelaymaster wolfDelaymaster = new WolfDelaymaster();
		String s = "wolfwwoollffwwwooolllfffwwwwoooollllffff";
		System.out.println("String " + s + " is " + wolfDelaymaster.check(s));
	}
	
}