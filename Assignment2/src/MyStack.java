import java.util.ArrayList;

/**
 * This class incorporates queue while converting from infix to postfix.
 * @author Lokesh Sankar Ramesh
 */
public class MyStack<T> implements StackInterface<T> {
    private T[] stack;
    int stackSize;
    private static final int DEFAULT_SIZE = 20;
    public static final int MAX_SIZE = 50;

    /**
     * Stack constructor with size parameter
     * @param stackCapacity - size of array given by user
     */
    @SuppressWarnings("unchecked")
    public MyStack(int stackCapacity) {
        if (stackCapacity <= MAX_SIZE) {
            stack = (T[]) new Object[stackCapacity];
            stackSize = 0;
        } else {
            throw new IllegalStateException("Array size exceeds max size");
        }
    }
    
    /**
     * This constructor calls stack constructor with default size parameter
     */
    public MyStack() {
        this(DEFAULT_SIZE);
    }

	/**
	 * Deletes and returns the element at the top of the Stack
	 * 
	 * @return the element at the top of the Stack
	 * 
	 * @throws StackUnderflowException if stack is empty
	 */
    public T pop() throws StackUnderflowException {
        if (isEmpty()) { throw new StackUnderflowException(); }
        
        T result = stack[stackSize-1];
        stack[stackSize--] = null;
        
        return result;
    }

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * 
	 * @return the element at the top of the Stack
	 * 
	 * @throws StackUnderflowException if stack is empty
	 */
    public T top() throws StackUnderflowException {
        if (isEmpty()) { throw new StackUnderflowException(); }
        return stack[stackSize-1];
    }

	/**
	 * Adds an element to the top of the Stack
	 * 
	 * @param e the element to add to the top of the Stack
	 * 
	 * @return true if the add was successful, false if not
	 * 
	 * @throws StackOverflowException if stack is full
	 */
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) { throw new StackOverflowException(); }
        
        stack[stackSize++] = e;
        
        return true;
    }

    /**
     * String representation of all the elements in the stack
     * 
     * @return str - values of the stack in string form
     */
    public String toString() {
        String str = "";
        
        for (int i = 0; i < stackSize; i++) {
            str += stack[i];
        }
        
        return str;
    }
    
    /**
     * Representation of all the elements in the stack separated by a delimiter
     * 
     * @return str - Elements of stack with delimiter between each element represented in string form
     */
    public String toString(String delimiter) {
        String str = "";
        
        for (int i = 0; i < stackSize; i++) {
            str += stack[i] + delimiter;
        }
        
        return str.substring(0, str.length()-1);
    }

    public void fill(ArrayList<T> list) {
        ArrayList<T> copyList = list;
        
        for(int i = 0; i < copyList.size(); i++) 
            stack[i] = copyList.get(i); 
        
        stackSize = copyList.size();
    }
    
    /**
     * Returns size of stack
     * 
     * @return size - Returns size of stack
     */
    public int size() {
        return stackSize;
    }
    
    /**
     * Checks if stack is empty or not
     * 
     * @return true
     * @return false 
     */
    public boolean isEmpty() {
        return stackSize == 0;
    }

    /**
     * Checks if stack is full or not.
     * 
     * @return true
     * @return false
     */
    public boolean isFull() {
        return stackSize == stack.length;
    }

}
