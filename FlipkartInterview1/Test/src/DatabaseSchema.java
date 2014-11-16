import java.util.Scanner;



// Build Up the state Diagram
// Build up the query as a tree.
// Nested Query becomes a new child.
// First evalute the child and go up the tree.

class DataRow {
	int employee_id;
	String employee_name;
	String employee_salary;
	String department_id;
}


class QueryState {
	static final int START = 1;
	static final int NEXTFIELD = 2;
	static final int CRITERIA = 5;
	static final int EXPRESSION = 6;
	static final int WHERE = 7;
	static final int WHERE2 = 8;
	static final int LITERAL = 9;
	static final int NESTED_CRITERIA = 10;
	static final int BRACKET_CLOSE = 11;
	static final int EXPRESSION2 = 12;
	
	static final int START2 = 6;

	static final int DONE = 100;
	static final int INVALID = 10000;
}

class Symbols {
	final static String emp_id = "employee_id"; 
	final static String emp_name = "employee_name";
	final static String emp_salary = "employee_salary";
	final static String dept_id = "department_id";
	final static String and = "and";
	final static String or = "or";
}

class Token {
	static final int emp_id = 1;
	static final int emp_name = 2;
	static final int emp_salary = 3;
	static final int emp_dept = 4;
	static final int AND2 = 5;
	static final int OR2 = 6;
	static final int NEWQ = 7;
	static final int invalid = 1000;
}

class DatabaseSchema {

	static private int getToken(String t) {
		if (t.compareTo(Symbols.emp_id) == 0)
			return Token.emp_id;
		else if (t.compareTo(Symbols.emp_name) == 0)
			return Token.emp_name;
		else if (t.compareTo(Symbols.emp_salary) == 0)
			return Token.emp_salary;
		else if (t.compareTo(Symbols.dept_id) == 0)
			return Token.emp_dept;
		else if (t.compareTo(Symbols.and) == 0)
			return Token.AND2;
		else if (t.compareTo(Symbols.or) == 0)
			return Token.OR2;
		return Token.invalid;
	}
	
	static private boolean employeeFields(String t) {
		if (t.compareTo(Symbols.emp_id) == 0)
			return true;
		else if (t.compareTo(Symbols.emp_name) == 0)
			return true;
		else if (t.compareTo(Symbols.emp_salary) == 0)
			return true;
		else if (t.compareTo(Symbols.dept_id) == 0)
			return true;
		return false;
	}

	private static boolean parse(String ...  varags) {


		// First:
		// finish up the Query validation by state diagram.

		if (varags == null || varags.length == 0)
			return false;
		int[] query = new int[varags.length];

		// Count brackets
		int openB = 0;
		for (int i = 0, len = varags.length; i < len; i++) {
			if (varags[i].compareTo("(") == 0)
				openB ++;
			else if (varags[i].compareTo(")") == 0) {
				if (openB == 0)
					return false;
				openB --;
			}
		}
		// state 0: valid state 1: invalid
		for (int i = 0, len = varags.length, state = QueryState.START, j = 0;
				i < len && state != QueryState.INVALID && state != QueryState.DONE; i++) {
			final String tStr = varags[i];
			final int tLen = tStr.length();
			String t1;
			int continousSymbols = 0;
			Integer v;
			switch (state) {
			case QueryState.START:
				if (tStr.charAt(tLen - 1) == ',') {
					continousSymbols++;
					state = QueryState.NEXTFIELD;
					t1 = tStr.substring(0, tLen - 1);
				} else {
					t1 = tStr;
					state = QueryState.WHERE;
				}
				query[j++] = getToken(t1);
				if (query[j - 1] == Token.invalid) { 
					state = QueryState.INVALID;
				}
				break;
			case QueryState.NEXTFIELD:
				if (continousSymbols == 4) {
					state = Token.invalid;
					break;
				}
				if (tStr.charAt(tLen - 1) == ',') {
					state = QueryState.NEXTFIELD;
					t1 = tStr.substring(0, tLen - 1);
					continousSymbols++;
				} else {
					t1 = tStr;
					continousSymbols = 0;
				}
				query[j++] = getToken(t1);
				if (query[j - 1] == Token.invalid) { 
					state = QueryState.INVALID;
				} else {
					state = QueryState.EXPRESSION;
				}
				break;
			case QueryState.CRITERIA:
				t1 = tStr;
				if (t1.compareTo("and") == 0) {
					state = QueryState.CRITERIA;
				} else if (t1.compareTo("or") == 0) {
					state = QueryState.CRITERIA;
				} else if (t1.compareTo("(") == 0) {
					state = QueryState.NESTED_CRITERIA;
				}
				break;
			case QueryState.EXPRESSION:
				if (tStr.compareTo("<") == 0) {
					state = QueryState.LITERAL;
				} else if (tStr.compareTo(">") == 0) {
					state = QueryState.LITERAL;
				} else if (tStr.compareTo("=") == 0) {
					state = QueryState.LITERAL;
				}
				break;
			case QueryState.LITERAL:	
				try {
					v = Integer.parseInt(tStr); 
				} catch (NumberFormatException e) {
					v = -1;
					state = QueryState.INVALID;
				}
				break;
			case QueryState.WHERE:
				// I have to decide how to go about it.
				if (tStr.compareTo("where") == 0) {
					state = QueryState.CRITERIA;
				} else {
					state = QueryState.DONE;
				}
				break;
			case QueryState.NESTED_CRITERIA:
				if (employeeFields(tStr)) {
					state = QueryState.EXPRESSION2;
				}
				break;
			case QueryState.EXPRESSION2:
				
				break;
			case QueryState.INVALID:
				return false;
			}
		}

		return false;
	}


	public static void main(String[] args) {

		//		final int EMPLOYEE_ID = 0;
		//		final int EMPLOYEE_NAME = 1;
		//		final int EMPLOYEE_SALARY = 2;
		//		final int DEPARTMENT_ID = 4;
		//		

		//Scanner sc = new Scanner(System.in);
		//final int noQueries = Integer.parseInt(sc.next()); 
		//System.out.println("No Queries = " + noQueries);

		//		int[][3] input_data = {}; 
		//		sc.close();


		// Parse the Query

		//		String[] query = new String[] {};
		boolean valid = parse("employee_id,", "employee_name,", "employee_salary,", "departmemt_id");
	}
}
