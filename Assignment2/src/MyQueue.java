import java.util.ArrayList;

/**
 * This class creates a queue that can be used with any object.
 * 
 * @author Lokesh Sankar Ramesh
 *
 * @param <T> - Generic queue
 */
public class MyQueue<T> implements QueueInterface<T> {
    private T[] queue;
    int size;
    private static final int DEFAULT_SIZE = 20;
    public static final int MAX_SIZE = 50;
    
    /**
     * Queue constructor with size parameter
     * @param queueCapacity - size of array given by user
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int queueCapacity) {
        if (queueCapacity <= MAX_SIZE) {
            queue = (T[]) new Object[queueCapacity];
            size = 0;
        } else {
            throw new IllegalStateException("Array size exceeds max size");
        }
    }

    /**
     * This constructor calls queue constructor with default size parameter
     */
    public MyQueue() {
        this(DEFAULT_SIZE);
    }


    /**
     * Adds value to queue at last index
     * 
     * @throws QueueOverflowException
     * 
     * @param e - User given object to be added to queue
     * 
     * @return true - Return true when object is added. Does not return true if exception is thrown
     */
    public boolean enqueue(T e) throws QueueOverflowException {

        if (isFull()) {
            throw new QueueOverflowException();
        }
        queue[size] = e;
        size++;
        return true;

    }

    /**
     * Removes top object in queue before shifting objects in array one spot left
     * 
     * @throws QueueUnderflowException - throws exception is queue is empty
     * 
     * @return result - returns the first value that is getting removed
     */
    public T dequeue() throws QueueUnderflowException {

        if (isEmpty())
            throw new QueueUnderflowException();
        T result = queue[0];
        for (int i = 0; i < queue.length; i++) {
            if (i != queue.length - 1)
                queue[i] = queue[i + 1];
        }
        size--;
        return result;

    }

    /**
     * String representation of all the elements in the queue
     * 
     * @return str - values of the queue in string form
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += queue[i];
        }
        return str;
    }

    /**
     * Representation of all the elements in the queue separated by a delimiter
     * 
     * @return str - Elements of queue with delimiter between each element represented in string form
     */
    public String toString(String delimiter) {
        String str = "";
        for (int i = 0; i < size; i++) {

            str += queue[i] + delimiter;

        }
        return str.substring(0, str.length() - 1);
    }

    /**
     * Checks if queue is empty or not.
     * 
     * @return true
     * @return false 
     */
    public boolean isEmpty() {
        return queue[0] == null;
    }

    /**
     * Checks if queue is full or not.
     * 
     * @return true
     * @return false
     */
    public boolean isFull() {
        return size == queue.length;
    }

    /**
     * Returns size of queue
     * 
     * @return size - Returns size of queue array
     */
    public int size() {
        return size;
    }

    /**
     * Elements of ArrayList used to fill Queue
     * 
     * @param list
     */
    @SuppressWarnings("unchecked")
    public void fill(ArrayList<T> list) {
        ArrayList<T> copyList = list;
        queue = (T[]) copyList.toArray();
        size = copyList.size();

    }
}