import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AdvanceCalculator {
	
	public static double E = 0.000000000001;
	
	public static void main(String [] args) {
		AdvanceCalculator calculator = new AdvanceCalculator();
		String exp1 = "2 + (3*5 - 3) / 3";
		String exp2 = "1 - 2*((3 - 5) / (-2)) + 2";
		String exp3 = "1.5 - 2*((10 - 5) / (-2)) + 2.3";
		
		double expected = 6;
		double actual = calculator.calc(exp1);
		if (Math.abs(expected - actual)  > AdvanceCalculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp1 + " = " + actual);
		}
		expected = 1;
		actual = calculator.calc(exp2);
		if (Math.abs(expected - actual)  > AdvanceCalculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp2 + " = " + actual);
		}
		expected = 8.8;
		actual = calculator.calc(exp3);
		if (Math.abs(expected - actual)  > AdvanceCalculator.E) {
			throw new RuntimeException("Expected result is " + expected + ", but was " + actual);
		} else {
			System.out.println("Correct! " + exp3 + " = " + actual);
		}
	}
	
	public double calc(String expression) {		
		String exp = prepareExpression(expression);
		Queue<String> queue = convertToRPN(exp);
		return calc(queue);		
	}
	
	// remove unnecessary symbols and deal with unary minuses
	private String prepareExpression(String expression) {
		String exp = expression.trim().replaceAll(" ","");
		
		// deal with unary '-'
		exp = exp.replaceAll("\\(-", "(0-");
		if (exp.charAt(0) == '-') {
			exp = "0-" + exp;
		}
		
		return exp;
	}
	
	// convert expression to postfix notation using Shunting-yard algorithm
	private Queue<String> convertToRPN(String exp) {
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(exp, "+-*/()", true);
		while (st.hasMoreTokens()) {
			String e = st.nextToken();
			if (isOperator(e)) {				
				switch(e) {
					case "+": 
					case "-":
					case "*": 
					case "/": 	while (!stack.isEmpty() && 
									!stack.peek().equals("(") && 
									getOperatorPriority(e) <= getOperatorPriority(stack.peek())) {
										queue.add(stack.pop());
								}
							  stack.push(e);break;
					case ")": 	while(!stack.peek().equals("(")) {
									queue.add(stack.pop());
								}
								stack.pop(); break;
					case "(": 	stack.push(e);break;
				}				
			} else {
				queue.add(e);
			}
		}
		
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
		return queue;
	}
	
	// calculate postfix notation (a.k.a Reverse Polish Notation)
	private double calc(Queue<String> queue) {		
		Stack<Double> calc = new Stack<>();
		while (!queue.isEmpty()) {
			String e = queue.poll();
			if (isOperator(e)) {
				double v2 = calc.pop();
				double v1 = calc.pop();
				switch(e) {
					case "+": calc.push(v1 + v2);break;
					case "-": calc.push(v1 - v2);break;
					case "*": calc.push(v1 * v2);break;
					case "/": calc.push(v1 / v2);break;
				}
			} else {
				double value = Double.valueOf(e);
				calc.push(value);
			}
		}
		
		return calc.pop();
	}
	
	private boolean isOperator(String s) {
		switch(s) {
			case "+": return true;
			case "-": return true;
			case "*": return true;
			case "/": return true;
			case "(": return true;
			case ")": return true;
			default: return false;
		}
	}
	
	private int getOperatorPriority(String s) {
		switch(s) {
			case "+": return 1;
			case "-": return 1;
			case "*": return 2;
			case "/": return 2;
			default: return 0;
		}
	}
	
}