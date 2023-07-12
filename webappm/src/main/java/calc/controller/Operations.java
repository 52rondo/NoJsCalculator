package calc.controller;

public class Operations {
	
	static public int calculate(int a, int operator, int b) {
		int c;
		switch (operator) {
		case -1:
			c = a + b;
			return c;
		case -2:
			c = a - b;
			return c;
		case -7:
			c = a * b;
			return c;
		case -8:
			c = a / b;
			return c;
		default:
			System.out.println("sth wrong in operations");
			break;
		}
		return 0;
	}

}
