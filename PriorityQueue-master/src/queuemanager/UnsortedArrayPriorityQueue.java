/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * @author James
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
    * Where the data is actually stored.
    */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    @Override
    public T head() throws QueueUnderflowException {
        T priority = null;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < tailIndex; i++) {
                
                if ((((PriorityItem<T>) storage[i]).getPriority()) == 1)
                {
                    priority = ((PriorityItem<T>) storage[i]).getItem();
                }
            }
            return priority;
        }
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < tailIndex; i++) {
                int priority = ((PriorityItem<T>) storage[i]).getPriority();
                if (priority == 1)
                {
                    for (int j = i; j < tailIndex; j++) {
                    storage[j] = storage[j + 1];
                }
                    tailIndex = tailIndex - 1;
                }
                
            }
            
            for (int i = 0; i <=tailIndex; i++)
            {
               int priority = ((PriorityItem<T>) storage[i]).getPriority() - 1;
               
               storage[i] = new PriorityItem<>(((PriorityItem<T>) storage[i]).getItem(), priority);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }

}

