class Solution1 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		StringBuilder builder = new StringBuilder();
		
		int last = 0;
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == ' ') {
				builder.append(input.substring(last, i)).append("%20");
				last = i + 1;
			}
		}
		if (last < input.length()) {
			builder.append(input.substring(last, input.length()));
		}
		
		System.out.println("Result string: " + builder);
	}
	
}