
import java.util.Stack;

public class ShuntingyardAlgorithm {
	public static void main(String[] args) {
		String myString = "3+(2+1)*2^3^2-8/(5-1*2/2)";
		System.out.println(algorithm(myString));
		
		
	}
	
	public static String algorithm(String myString){
		Stack<Character> myStack = new Stack<Character>();
		String toReturn = "";
		
		for(int i = 0; i < myString.length(); i++) {
			char current = myString.charAt(i);
			
			if(!isOperator(current) && current != '(' && current != ')') {
				toReturn += current;
			} 
			
			else if(isOperator(current)){
				while(!myStack.isEmpty() && checkOperators(current) <= checkOperators(myStack.peek())) {
					toReturn += myStack.pop();
				}
				myStack.push(current);
			}
			
			else if(current == '(') {
				myStack.push(current);
			}
			
			else if(current == ')') {
				while(!myStack.isEmpty() && myStack.peek() != '(') {
					toReturn += myStack.pop();
				}
				
				if(myStack.peek() == '(') {
					myStack.pop();
				} 
				
				else if(myStack.isEmpty()) {
					return "Error";
				}
			}
		}
		
		while(!myStack.isEmpty()) {
			
			if(myStack.peek() == '(') {
				System.out.println(toReturn);
				return "Error";
				
			}
			toReturn += myStack.pop();
		}
		
		return toReturn;
		
	}
		
		public static boolean isOperator(char myChar) {
			switch(myChar) {
			case '+':
				return true;
			case '-':
				return true;
			case '*':
				return true;
			case '/':
				return true;
			case '^':
				return true;
			default:
				return false;
			
			}
				
		}
		
		public static int checkOperators(char c) {
			if (c == '+' || c == '-')
	            return 1;
	        else if (c == '*' || c == '/')
	            return 2;
	        else if (c == '^')
	            return 3;
	        else
	            return -1;
		}
}
