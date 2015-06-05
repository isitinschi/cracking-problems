class Solution2 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		
		input = input.replaceAll(" ", "%20");
		
		System.out.println("Result string: " + input);
	}
	
}