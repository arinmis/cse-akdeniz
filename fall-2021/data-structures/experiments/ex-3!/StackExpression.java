import java.util.Stack;

public class StackExpression {

    final static String END = "$";

    public static void main(String[] args) {
        // should be 162
        String expression = "1 + 2 * 3 ^ 4" ;
        // result without predence: 9  
        // result with predence:    7  
        int result = evaluate(expression);
        // print the result
        System.out.println("expression: " + expression);
        System.out.println("result: " + result);
    }

    public static int evaluate(String exp) {
        exp = exp.replaceAll(" ", "");
        Stack<Integer> valueStack = new Stack<>(); 
        Stack<String> opStack = new Stack<>(); 
        for (int i = 0; i < exp.length(); i++) {
            String token = exp.substring(i, i + 1);
            if (Character.isDigit(exp.charAt(i)))
                valueStack.push(Integer.valueOf(token));
            else {
                repeatOps(token, valueStack, opStack);
                opStack.push(token);
            }
        }
        repeatOps(END, valueStack, opStack);
        return valueStack.peek();
    }

    // perform given operation with given numbers
    // only *, - and + operations are supported
    public static int doOp(int num1, int num2, String op) {
        if (op.equals("+")) 
            return num1 + num2;
        if (op.equals("-")) {
            return num1 - num2;
        }
        if (op.equals("*"))
            return num1 * num2;
        return (int)Math.pow(num1, num2);
    }

    public static void repeatOps(String refOp,
            Stack<Integer> valueStack, Stack<String> opStack) {
        while (valueStack.size() > 1 && prec(refOp) <= prec(opStack.peek())) {
            int x  =  valueStack.pop();
            int y  =  valueStack.pop();
            String op = opStack.pop();
            int result =  doOp(x, y, op);
            valueStack.push(result);
        } 
    }

    // get precedence of operation
    // bigger one's has more precedence 
    public static int prec(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        }
        // precedence of multiplication 
        if (op.equals("*"))
            return 2;
        if (op.equals("^"))
            return 3;
        return -1; // precedence of multiplication $(END)
    }

}
