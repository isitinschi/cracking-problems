class Solution2 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		
		boolean [] characters = new boolean[256];		
		for (int i = 0; i < input.length(); ++i) {
			int character = input.charAt(i);
			if (characters[character]) {
				System.out.println("NOT all characters are unique");
				return;
			}
			characters[character] = true;
		}
		
		System.out.println("All characters are unique");
	}
	
}