import java.util.List;
import java.util.ArrayList;

public class PaternityTest {

	public int[] possibleFathers(String child, String mother, String[] men) {
		List<Integer> matches = new ArrayList<Integer>();
		int n = child.length();
		for (int i = 0; i < men.length; ++i) {
			boolean match = true;
			int counter = 0;
			for (int j = 0; j < n; ++j) {
				if (child.charAt(j) == men[i].charAt(j)) {
					++counter;
				} else if (child.charAt(j) != mother.charAt(j)) {
					match = false;
					break;
				}
			}
			if (match && counter >= n / 2) {
				matches.add(i);
			}
		}
		
		return matches.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String [] args) {
		PaternityTest paternityTest = new PaternityTest();
		String child = "ABCD";
		String mother = "ABCX";
		String [] men = new String [] {"ABCY", "ASTD", "QBCD"};
		System.out.println("Possible fathers:");
		int [] fathers = paternityTest.possibleFathers(child, mother, men);
		for (int i = 0; i < fathers.length; ++i) {
			System.out.print(fathers[i] + " ");
		}
	}
	
}