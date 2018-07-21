
import java.util.*;

public class Evaluator {
    
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/#!() "; // added the '(' and ')'
    
    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
        
        //put all mapping operator to corresponding methods
        Operator.operators.put("^", new operatorPower());
        Operator.operators.put("*", new operatorMultiply());
        Operator.operators.put("/", new operatorDivide());
        Operator.operators.put("+", new operatorAddition());
        Operator.operators.put("-", new operatorSubstration());
        Operator.operators.put("#", new operatorHash());
        Operator.operators.put("!", new operatorExclamation());
        Operator.operators.put("(", new leftParenthesis());
        Operator.operators.put(")", new rightParenthesis());
    }
    
    public String eval(String expression) {
        String token;
        
        
        //  change priority
        operatorStack.push(Operator.operators.get("#"));
        expression = expression + "!";
        
        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        
        
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);
        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators
        
        // TODO Operator is abstract - this will need to be fixed:
        // operatorStack.push( new Operator( "#" ));
        // When is it a good time to add the "!" operator?
        
        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        System.exit(1);
                    }
                    
                    // called the instance of a HashMap and parse it as a Operator obj.
                    Operator newOperator = (Operator) Operator.operators.get(token); // POINT 1
                    
                    //when operator stack is 1, taht will mean it will go straight to the final answer.
                    while (((Operator) operatorStack.peek()).priority() >= newOperator.priority() && !newOperator.equals(Operator.operators.get(("(")))) {
                        
                        // note that when we eval the expression 1 - 2 we will
                        // push the 1 then the 2 and then do the subtraction operation
                        // This means that the first number to be popped is the
                        // second operand, not the first operand - see the following code
                        // also check the for "(" and ")"
                        
                        if (token.equals(")")) {
                            while (!operatorStack.peek().equals(Operator.operators.get("(")) && !operatorStack.peek().equals(Operator.operators.get("#"))) {
                                Operator oldOpr = ((Operator) operatorStack.pop());
                                Operand op2 = (Operand) operandStack.pop();
                                Operand op1 = (Operand) operandStack.pop();
                                operandStack.push(oldOpr.execute(op1, op2));
                            }
                            if (!operatorStack.peek().equals(Operator.operators.get("#"))) {
                                operatorStack.pop();
                            }
                            newOperator = (Operator) Operator.operators.get(token); // POINT 1
                            
                        } else {
                            Operator oldOpr = ((Operator) operatorStack.pop());
                            Operand op2 = (Operand) operandStack.pop();
                            Operand op1 = (Operand) operandStack.pop();
                            operandStack.push(oldOpr.execute(op1, op2));
                        }
                    }
                    if (!newOperator.equals(Operator.operators.get(")"))) {
                        operatorStack.push(newOperator);
                    }
                }
            }
        }
        operatorStack.clear();        //remove the #! each time to solve an equation
        return Integer.toString(operandStack.pop().getValue());//return final value. or pop and return..
    }
}


