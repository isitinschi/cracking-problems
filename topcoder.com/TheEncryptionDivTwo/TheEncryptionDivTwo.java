import java.util.Map;
import java.util.HashMap;

public class TheEncryptionDivTwo {
	
	private static char START_CODE = 'a';
	private static char MAX_CODE = 'z';
	
	public String encrypt(String message) {
		if (message == null) {
			return null;
		}
		if (message.isEmpty()) {
			return "";
		}
		 
		StringBuilder encryptedMessage = new StringBuilder();
		
		Map<Character, Character> map = new HashMap<>();
		char next = START_CODE;
		for (int i = 0; i < message.length(); ++i) {
			Character code = map.get(message.charAt(i));
			if (code == null) {
				if (next > MAX_CODE) {
					throw new RuntimeException("Bad input!");
				}
				code = next;
				++next;
				map.put(message.charAt(i), code);				
			}
			encryptedMessage.append(code);
		}
		
		return encryptedMessage.toString();
	}
	
	public static void main(String[] args) {
		TheEncryptionDivTwo theEncryptionDivTwo = new TheEncryptionDivTwo();
		String msg = "hello";
		String result = theEncryptionDivTwo.encrypt(msg);
		System.out.println("Message: " + msg + ", encrypted message: " + result);
	}
	
}