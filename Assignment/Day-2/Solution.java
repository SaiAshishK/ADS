import java.util.*;
public class Solution
{  
/**
 * @author - K. Sai Ashish
 * 
  */ 
    Node last;
    int size;

    public Solution() {
        last = null;
        size = 0;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;

        }
    }
    /**
     *  Time Complexity - O(1)
     * @param value
     * inserts a node in last
     */
    public void Enqueue(int value) {
        Node temp = new Node(value);
        if (isEmpty()) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        size++;

    }
    /**
     *  Time Complexity - O(1)
     * deletes the first inserted node
     */
    public int Dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            Node temp = last.next;
            last.next = last.next.next;
            size--;
            return temp.data;

        }

    }
    // returns int size
    public int size() {
        return size;
    }
    // return boolean to know if
    // the linked list is empty or not
    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        Solution cir = new Solution();
        cir.Enqueue(5);
        // cir.Enqueue(54);
        // cir.Enqueue(40);
        // cir.Enqueue(25);
        System.out.println(cir.Dequeue());
        System.out.println(cir.size());

        
        }
    }
    /**
     * In Queues implementation using Linked List , the 
     * time complexity of enqueue and dequeue is same as
     * circular linked liste i.e., O(1) as in linked list 
     * we use two pointers front and rear
     */
    /**
     * Queues implementation using arrays, the time complexity
     * for enqueue is O(1) and dequeue is O(N)
     */ 
