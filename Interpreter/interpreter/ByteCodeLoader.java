package interpreter;

import interpreter.ByteCode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        this.program = new Program();

    }

    /**
     * This function should read one line of source code at a time. For each
     * line it should: Tokenize string to break it into parts. Grab correct
     * class name for the given bytecode from CodeTable create an instance of
     * the bytecode class name returned from code table. Parse any additional
     * arguments for the given bytecode and send them to the newly created
     * bytecode instance via the init function.
     */
    public Program loadCodes() {
        String code_Key;
        String code_Class;
        String nextLine;
        ByteCode bytecode;
        ArrayList<String> tokenList = new ArrayList<String>();

        try {
            nextLine = byteSource.readLine();

            while (nextLine != null) {

                StringTokenizer tokenzier = new StringTokenizer(nextLine);

                code_Key = tokenzier.nextToken();
                code_Class = CodeTable.getClassName(code_Key);

                bytecode = (ByteCode) (Class.forName("interpreter.ByteCode." + code_Class).newInstance());

                while (tokenzier.hasMoreTokens()) {
                    tokenList.add(tokenzier.nextToken());
                }

                //initialize bytecode instance along with arguments
                bytecode.init(tokenList);

                //add bytecode to arraylist
                program.addByteCode(bytecode);

                //clear tokens list 
                tokenList.clear();

                //read nextline
                nextLine = byteSource.readLine();

            }
        } catch (Exception e) {
            System.out.println("file readline doesn't work.");
        }

        //resolving branch 
        try {
            program.resolveAddrs(program);
        } catch (Exception e) {
            System.out.println("resolveAddress Error in ByteCodeLoader.java.");
        }

        return program;
    }
}
