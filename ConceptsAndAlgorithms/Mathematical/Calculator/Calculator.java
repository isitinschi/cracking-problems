public class Calculator {
	
	public static double E = 0.000000000001;
	
	public static void main(String [] args) {
		Calculator calculator = new Calculator();
		String exp1 = "2 + (3*5 - 3) / 3";
		String exp2 = "1 - 2*((3 - 5) / (-2)) + 2";
		String exp3 = "1.5 - 2*((10 - 5) / (-2)) + 2.3";
		
		double expected = 6;
		double actual = calculator.calc(exp1);
		if (Math.abs(expected - actual)  > Calculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp1 + " = " + actual);
		}
		expected = 1;
		actual = calculator.calc(exp2);
		if (Math.abs(expected - actual)  > Calculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp2 + " = " + actual);
		}
		expected = 8.8;
		actual = calculator.calc(exp3);
		if (Math.abs(expected - actual)  > Calculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp3 + " = " + actual);
		}
	}
	
	public double calc(String expression) {
		String exp = expression.replaceAll("\\s+","");
		double result = 0;
		for (int i = exp.length() - 1; i >= 0; --i) {
			char c = exp.charAt(i);
			
			if (isNumber(c)) {
				String number = getNumber(exp.substring(0, i + 1));
				result = Double.valueOf(number);
				i -= number.length() - 1;
			} else if (c == '+') {
				return calc(exp.substring(0, i)) + result;
			} else if (c == '-') {
				return calc(exp.substring(0, i)) - result;
			} else if (c == '*') {
				if (exp.charAt(i - 1) == ')') {
					int j = findOpenedParentheses(exp, i - 1);
					result *= calc(exp.substring(j + 1, i - 1));
					i = j;
				} else {
					String number = getNumber(exp.substring(0, i));
					result *= Double.valueOf(number);
					i -= number.length();
				}
			} else if (c == '/') {
				if (exp.charAt(i - 1) == ')') {
					int j = findOpenedParentheses(exp, i - 1);
					result = calc(exp.substring(j + 1, i - 1)) / result;
					i = j;
				} else {
					String number = getNumber(exp.substring(0, i));
					result = Double.valueOf(number) / result;
					i -= number.length();
				}
			} else if (c == ')') {
				int j = findOpenedParentheses(exp, i);
				result = calc(exp.substring(j + 1, i));
				i = j;
			}
		}
		
		return result;
	}
	
	private boolean isNumber(char c) {
		switch(c) {
			case '0': return true;
			case '1': return true;
			case '2': return true;
			case '3': return true;
			case '4': return true;
			case '5': return true;
			case '6': return true;
			case '7': return true;
			case '8': return true;
			case '9': return true;
			default: return false;
		}
	}
	
	private String getNumber(String exp) {		
		int i = exp.length() - 1;
		char c = exp.charAt(i);
		while (isNumber(c) || c == '.') {
			--i;
			if (i < 0) {
				break;
			} else {
				c = exp.charAt(i);
			}
		}
		return exp.substring(i + 1, exp.length());
	}
	
	private int findOpenedParentheses(String exp, int start) {
		int opened = 0;
		int closed = 1;
		int i = start;
		while (opened != closed) {
			--i;
			if (exp.charAt(i) == '(') {
				++opened;
			} else if(exp.charAt(i) == ')') {
				++closed;
			}
		}
		
		return i;
	}
}