import java.util.Stack;

public class ExpressionEvaluation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> myStack = new Stack<>();
        int op1;
        int op2;
        
        for(int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    myStack.push(myStack.pop() + myStack.pop());
                    break;
                case "-":
                    op1 = myStack.pop();
                    op2 = myStack.pop();
                    myStack.push(op2 - op1);
                    break;
                case "*":
                    myStack.push(myStack.pop() * myStack.pop());
                    break;
                case "/":
                    op1 = myStack.pop();
                    op2 = myStack.pop();
                    myStack.push(op2 / op1);
                    break;
                default:
                    myStack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return myStack.pop();
    }
}
