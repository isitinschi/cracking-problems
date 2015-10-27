import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Random;

public class IP {
	
	private static String IP_NUMBER = "\\d|[1-9]\\d|1\\d{2}|25[0-5]|2[0-4]\\d";
	private static Pattern pattern = Pattern.compile(	"(" + IP_NUMBER + ")\\." + 
											"(" + IP_NUMBER + ")\\." +
											"(" + IP_NUMBER + ")\\." +
											"(" + IP_NUMBER + ")");
	
	public static boolean validate(String ip) {
		if (ip == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(ip);
		return matcher.matches();
	}
	
	public static void find(String text) {
		if (text == null) {
			return;
		}
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println("Found match with " + matcher.group() + ". Start is " + matcher.start() + ". End is " + matcher.end());
		}
	}
	
	public static void main(String [] args) {
		StringBuilder text = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < 100; ++i) {
			StringBuilder builder = new StringBuilder();
			int i1 = random.nextInt(300);
			int i2 = random.nextInt(300);
			int i3 = random.nextInt(300);
			int i4 = random.nextInt(300);
			builder.append(i1 + "." + i2 + "." + i3 + "." + i4);
			boolean valid = (i1 <= 255 && i2 <= 255 && i3 <= 255 && i4 <= 255);
			if (IP.validate(builder.toString()) != valid) {
				throw new RuntimeException("Wrong validation for IP " + builder + " -> Should be " + valid);
			}
			if (valid) {
				text.append(builder.toString());
			} else {
				text.append("bla");
			}
		}
		
		String ip = "";	
		if (IP.validate(ip)) {
			throw new RuntimeException("Wrong validation for IP " + ip);
		}
		ip = null;
		if (IP.validate(ip)) {
			throw new RuntimeException("Wrong validation for IP " + ip);
		}
		ip = "1.1.1";
		if (IP.validate(ip)) {
			throw new RuntimeException("Wrong validation for IP " + ip);
		}
		
		System.out.println("Implementation is valid!");
		
		IP.find(text.toString());
	}
}