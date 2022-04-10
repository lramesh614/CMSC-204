import java.util.ArrayList;
/**
 * 
 * @author Lokesh Sankar Ramesh
 *
 */

@SuppressWarnings("unused")
public class Notation {
	private static NotationQueue<String> q;
	private static NotationStack<String> s;
	
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
	}


	/**
	 * Evaluates postfix expression from string to double
	 * 
	 * @param postfixExpr
	 * 
	 * @return postfix expression evaluated as double
	 * 
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		q = new NotationQueue<String>(postfixExpr.length());
		s = new NotationStack<String>(postfixExpr.length());
		
		NotationStack<String> ns = new NotationStack<String>(2);
		String[] iTemp = postfixExpr.split("");

		try {
			for (String c : iTemp) {
				if (c.equals(" ")) { continue; }
				if (isInteger(c)) { s.push(c); }
				if (isOperator(c)) {
					ns.push(s.pop());
					ns.push(s.pop());
					s.push(String.valueOf(eval(c, ns.pop(), ns.pop())));
				}
			}

			if(s.size()>1) { throw new Exception(); }
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		
		return Integer.parseInt(s.toString());
	}

	/**
	 * Convert the Postfix expression to the Infix expression
	 * 
	 * @param -  postfix expression
	 * 
	 * @throws - InvalidNotationFormatException
	 * 
	 * @return -  infix expression
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		q = new NotationQueue<String>(postfix.length());
		s = new NotationStack<String>(postfix.length());
		
		NotationStack<String> ns = new NotationStack<String>(2);

		String[] i = postfix.split("");

		try {
			for (String c : i) {
				if (c.equals(" ")) { continue; }
				if (isInteger(c)) { s.push(c); }
				if (isOperator(c)) {
					ns.push(s.pop());
					ns.push(s.pop());
					s.push("(" + ns.pop() +c + ns.pop() + ")");
				}
			}
			
			if(s.size()>1) { throw new Exception(); }
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		
		return s.toString();
	}

	/**
	 * Convert an infix expression into a postfix expression
	 * 
	 * @param -  postfix expression
	 * 
	 * @throws - InvalidNotationFormatException
	 * 
	 * @return -  infix expression
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		q = new NotationQueue<String>(infix.length());
		s = new NotationStack<String>(infix.length());

		String[] iTemp = infix.split("");

		try {
			for (String c : iTemp) {
				if (c.equals(" ")) { continue; }
				if (isInteger(c)) { q.enqueue(c); }
				if (c.equals("(")) { s.push(c); }
				
				if (isOperator(c)) {
					if (!s.isEmpty() 
							&& isOperator(s.top()) 
							&& isHigherEqualPrecedence(s.top(),c)) {
						q.enqueue(s.pop());
					}
					
					s.push(c);
				}

				if (c.equals(")")) {
					while (!s.isEmpty() 
							&& isOperator(s.top())) {
						q.enqueue(s.pop());
					}
	
					if(!s.isEmpty() 
							&& s.top().equals("(")) {
						s.pop();
					} else { throw new Exception(); }
					
				}
			}

			while (!s.isEmpty() 
					&& isOperator(s.top())) {
				q.enqueue(s.pop());
			}
			
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		
		return q.toString();
	}
	
	
	/**
	 * Checks operator precedence
	 * 
	 * @param a
	 * @param b
	 * 
	 * @return if operator a >= b in precedence
	 */
	private static boolean isHigherEqualPrecedence(String a, String b) {
		int c;
		int d;
		
		c = a == "*" || a == "/" ? 1 : 0;
		d = b == "*" || b == "/" ? 1 : 0;
		
		return c>=c;
	}
	
	/**
	 * 
	 * @param op
	 * @param strA
	 * @param strB
	 * 
	 * @return a+b - if operator is +
	 * @return a-b - if operator is minus
	 * @return a*b - if operator is *
	 * @return a/b - if operator is /
	 * 
	 */
	private static int eval(String operator, String strA, String strB) {
		int a = Integer.parseInt(strA);
		int b = Integer.parseInt(strB);
		
		switch(operator) {
		case "+": return a+b;
		case "-": return a-b;
		case "*": return a*b;
		case "/": return a/b;
		default:
		}
		
		return 0;
	}

	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isOperator(String s) {
		switch (s) {
		case "+":
		case "-":
		case "*":
		case "/": return true;
		default: return false;
		}
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isInteger(String s) {
		try { Integer.parseInt(s); } 
		catch (Exception e) { return false; }
		
		return true;
	}


}
