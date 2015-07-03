import java.lang.StringBuilder;

public class BinaryCode {

	public String [] decode (String s) {
		String [] output = new String[2];

		output[0] = decode(0, s);
		output[1] = decode(1, s);
		
		return output;
	}
	
	private String decode(int first, String s) {
		int [] binary = new int[s.length()];
		
		if (s.length() == 1) {
			int sum = Integer.parseInt("" + s.charAt(0));
			if (sum != 0 && sum != 1) {
				return "NONE";
			} else {
				binary[0] = sum;
			}
		} else {
			binary[0] = first;		
		
			for (int i = 0; i < s.length(); ++i) {
				int sum = Integer.parseInt("" + s.charAt(i));
				int prev = getValue(binary, i - 1);
				int cur = getValue(binary, i);
				if (i < s.length() - 1) {
					int value = sum - prev - cur;
					if (value == 0 || value == 1) {
						binary[i + 1] = value;
					} else {
						return "NONE";
					}
				}
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < binary.length; ++i) {
			builder.append(binary[i]);
		}
		return builder.toString();
	}
	
	private int getValue(int [] binary, int index) {
		if (index < 0 || index >= binary.length) {
			return 0;
		}
		return binary[index];
	}
	
	public static void main(String [] args) {
		String [] output = new BinaryCode().decode(args[0]);
		System.out.println(output[0] + ", " + output[1]);
	}
	
}