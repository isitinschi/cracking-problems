class Solution3 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		
		int bits = 0;
		
		for (int i = 0; i < input.length(); ++i) {
			int character = input.charAt(i);
			if ((bits & 1 << character) != 0) {
				System.out.println("NOT all characters are unique");
				return;
			}
			bits = bits | 1 << character;
		}
		
		System.out.println("All characters are unique");
	}
	
}