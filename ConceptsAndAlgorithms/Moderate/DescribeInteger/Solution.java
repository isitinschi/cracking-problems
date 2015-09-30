public class Solution {
	
	public static void main(String [] args) {
		long i = 12345678901l;
		
		String [] suffix = new String [] {"Thousand", "Million", "Billion"};
		long div = 1000;
		long rest = 0;
		int step = 0;
		String print = "";
		while (i - rest != 0) {
			long number = i % div - rest;
			rest += number;
			number /= div / 1000;
			String output = print(number);						
			div *= 1000;
			if (step != 0) {
				print = " " + output + " " + suffix[step - 1] + ((number > 1) ? "s" : "") + print;
			} else {
				print = " " + output + print;
			}
			++step;
		}
		
		System.out.println(print);
	}
	
	private static String print(long number) {
		String output = "";
		int hundreds = (int) number / 100;
		if (hundreds > 0) {
			String suffix = (hundreds > 1) ? " Hundreds" : " Hundred";
			output += " " + number(hundreds) + suffix;
		}
		int rest = (int) number - hundreds * 100;
		int decs = rest / 10;
		String print = "";
		if (decs == 0) {
			output += " " + number(rest);
		} else if (decs == 1) {
			switch(rest) {
				case 10: print = "ten";break;
				case 11: print = "eleven";break;
				case 12: print = "twelve";break;
				case 13: print = "thirteen";break;
				case 14: print = "fourteen";break;
				case 15: print = "fifteen";break;
				case 16: print = "sixteen";break;
				case 17: print = "seventeen";break;
				case 18: print = "eighteen";break;
				case 19: print = "nineteen";break;								
			}
			output += " " + print;
		} else if (decs > 0) {			
			switch(decs) {
				case 2: print = "twenty";break;
				case 3: print = "thirty";break;
				case 4: print = "forty";break;
				case 5: print = "fifty";break;
				case 6: print = "sixty";break;
				case 7: print = "seventy";break;
				case 8: print = "eighty";break;
				case 9: print = "ninety";break;				
			}
			output += " " + print + " " + number(rest - decs * 10);
		}
		return output;
	}
	
	private static String number(int i) {
		switch(i) {
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			case 7: return "seven";
			case 8: return "eight";
			case 9: return "nine";
			default: return "";
		}
	}
	
}