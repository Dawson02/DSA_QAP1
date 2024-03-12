package Queues;

import java.util.NoSuchElementException;

public class QueueArray {
    private int[] arr;
    private int topOfQueue;
    private int beginOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginOfQueue = -1;
        System.out.println("The Queue is successfully created with size of: " + size);
    }

    // Check if queue is full
    public boolean isFull() {
        return topOfQueue == arr.length - 1;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return topOfQueue == -1;
    }

    // Implement Peek method
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[topOfQueue];
    }

    // Implement adding an element to the queue
    public boolean enqueue(int element) {
        if (isFull()) {
            return false;
        }
        topOfQueue++;
        arr[topOfQueue] = element;
        return true;
    }

    // Implement removing an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int removedElement = arr[beginOfQueue + 1];
        beginOfQueue++;
        return removedElement;
    }

    // Implement delete queue
    public void deleteQueue() {
        topOfQueue = -1;
        beginOfQueue = -1;
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        // Test queue operations
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Peek: " + queue.peek()); // Should print 5

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 1
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 2

        if (!queue.enqueue(6)) {
            System.out.println("Unable to enqueue element, queue is full.");
        } else {
            System.out.println("Enqueue: 6"); // Should print Enqueue: 6
        }

        queue.deleteQueue();

        System.out.println("Is queue empty? " + queue.isEmpty()); // Should print true
    }
}
