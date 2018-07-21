//include the essential packages
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

// abstract class
abstract class Operator {
    // declare varaible
    int priority;
    public abstract int priority();
    
    //create new instance of Hashmap in operator class
    static HashMap <String, Operator> operators = new HashMap <String, Operator>();
    
    //check method()
    static boolean check(String token)
    {
        return operators.containsKey(token);
    }
    // abstract method excute() using contain key
    abstract Operand execute(Operand opd1,Operand opd2);
    
    int getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



// The Operator class should contain an instance of a HashMap
// This map will use keys as the tokens we're interested in,
// and values will be instances of the Operators.

// Example:
// Where does this declaration go? What should its access level be?
// Class or instance variable? Is this the right declaration?
// HashMap operators = new HashMap();
// operators.put( "+", new AdditionOperator() );
// operators.put( "-", new SubtractionOperator() );



