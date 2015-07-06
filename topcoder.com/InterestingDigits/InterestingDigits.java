import java.util.List;
import java.util.ArrayList;

public class InterestingDigits {
	
	public int[] digits(int base) {
		List<Integer> interestingDigits = new ArrayList<Integer>();
		for (int i = 2; i < base; ++i) {
			if (base % i == 1) {
				interestingDigits.add(i);
			}
		}
		return interestingDigits.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String[] args) {
		InterestingDigits interestingDigits = new InterestingDigits();
		int base = 26;
		System.out.println("Interersting digits for base " + base + ": ");
		int [] digits = interestingDigits.digits(base);
		for (int i = 0; i < digits.length; ++i) {
			System.out.print(digits[i] + " ");
		}
	}
	
}