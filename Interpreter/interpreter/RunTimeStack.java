package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    //This function returns the size using a function in runTimeStack.
    // The idea is to maintain the pop method from poping more than its function 
    // owned eventhough if (args) followed by pop is more than the size of its owned.
    // return size using a function in the runTimeStack; page=140
    
    public int MaxPop() {
        Iterator iterator = framePointer.iterator();
        int pointToNextFrame = 0, pointToCurrentFrame = (Integer) iterator.next();
        int sizeOfFunction = 0;
        if (pointToCurrentFrame == 0) {
            sizeOfFunction = 0;
        } else if (iterator.hasNext()) {
            pointToNextFrame = (Integer) iterator.next();
            sizeOfFunction = pointToCurrentFrame - pointToNextFrame;
        }
        return sizeOfFunction;
    }

    public void dump() {
        Iterator iterator = framePointer.iterator();
        int pointToNextFrame, pointToCurrentFrame = (Integer) iterator.next();

        for (int i = 0; i < framePointer.size(); i++) {
            if (iterator.hasNext()) {
                pointToNextFrame = (Integer) iterator.next();
            } else {
                pointToNextFrame = runTimeStack.size();
            }
            if (i > 0) {
                System.out.print("[");
            }
            for (int j = pointToCurrentFrame; j < pointToNextFrame; j++) {
                System.out.print(runTimeStack.get(j));
                if (j != pointToNextFrame - 1) {
                    System.out.print(",");
                }
            }
            if (i > 0) {
                System.out.print("]");
            }
            pointToCurrentFrame = pointToNextFrame;
        }
        System.out.println("\n");

    }

    public int size() {
        return runTimeStack.size();
    }

    public int peek() {
        return (Integer) runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() {
        int tmp = (Integer) runTimeStack.get(this.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return tmp;
    }

    public int push(int i) {
        runTimeStack.add(i);
        return this.peek();
    }

    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() {
        int tmp = this.peek();
        int tmp2 = framePointer.pop();
        for (int i = runTimeStack.size() - 1; i >= tmp2; i--) {
            runTimeStack.remove(i);
        }
        runTimeStack.add(tmp);

    }

    public int store(int offset) {
        int tmp = (Integer) runTimeStack.get(this.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, tmp);
        return tmp;
    }

    public int load(int offset) {
        int tmp = (Integer) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(tmp);
        return tmp;
    }

    public Integer push(Integer i) {
        runTimeStack.add(i);
        return this.peek();
    }
}
