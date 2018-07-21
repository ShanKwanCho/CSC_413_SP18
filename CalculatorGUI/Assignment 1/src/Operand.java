public class Operand {
    
    // declare variables
    int value;
    
    public Operand( String token )
    {
        // initialize this value
        this.value = Integer.parseInt(token);
    }
    
    public Operand( int value ) {
        this.value = value;
    }
    // check method ()
    public static boolean check(String token){
        // try block
        try{
            Integer.parseInt(token);
        }
        // catch block
        catch(Exception exp){
            return false;
        }
        return true;
    }
    
    // getValue Method ()
    public int getValue() {
        return value;
    }
}



class leftParenthesis extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 0;
    }
    
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Return
        return opd1;
    }
}


class rightParenthesis extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        
        return 1;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Return
        return opd1;
    }
}


class operatorAddition extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        
        return 2;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Create new instance
        Operand temp = new Operand(opd1.getValue() + opd2.getValue());
        
        //Return
        return temp;
    }
}


class operatorSubstration extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        
        return 2;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Create new instance
        Operand temp = new Operand(opd1.getValue() - opd2.getValue());
        
        return temp;
    }
}

//Class
class operatorMultiply extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 3;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Create new instance
        Operand temp = new Operand(opd1.getValue() * opd2.getValue());
        
        //Return
        return temp;
    }
}

//Class
class operatorDivide extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 3;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Create new instance
        Operand temp = new Operand(opd1.getValue() / opd2.getValue());
        
        //Return
        return temp;
    }
}

//Class
class operatorPower extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 4;
    }
    @Override
    Operand execute(Operand opd1, Operand opd2)
    {
        Operand temp = new Operand((int)Math.pow(opd1.getValue(),opd2.getValue()));
        return temp;
    }
    
}

//Class
class operatorHash extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 0;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Return
        return opd1;
    }
}

//Class
class operatorExclamation extends Operator
{
    @Override
    //Overridden method
    public int priority()
    {
        //Return
        return 1;
    }
    @Override
    //Overridden method
    Operand execute(Operand opd1, Operand opd2)
    {
        //Return
        return opd1;
    }
}




