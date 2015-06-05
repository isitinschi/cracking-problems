class Solution1 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		
		for (int i = 0; i < input.length(); ++i) {
			for (int j = i + 1; j < input.length(); ++j) {
				if (input.charAt(i) == input.charAt(j)) {
					input = input.replaceAll(input.substring(i, i + 1), "");
					--i;
					break;
				}
			}
		}
		
		System.out.println("Result string: " + input);
	}
	
}