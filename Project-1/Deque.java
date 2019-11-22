import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        int size;
        Node prev;
        Node next;
        Item item;

		public Node(Item item) {
			prev = null;
            next = null;
            this.item = item;
        }
        
    }
    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return ((last == null && first == null));
        
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item);
        if(first!=null){
            
            first.prev = newNode;
            newNode.next = first;
            //newNode.prev = null;
            first = newNode;
        }
        else {
            first = newNode;
            last = first;
        }
        size++;

    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(item);
        if(last != null){
            last.next = newNode;
            newNode.next = null;
            newNode.prev = last;
            last = newNode;

        }
            else{
                last = newNode;
                first = last;
            }
            size++;
        
        }

    

    // remove and return the item from the front
    public Item removeFirst(){
        if(size==0) {
            throw new NoSuchElementException();
        }
        else if (size == 1){
            Item temp = first.item;
            first = null;
            last = null;
            size--;
            return temp;
            
        }
        else{
            Node temp = first;
            first=first.next;
            first.prev = null;
            size--; 
            return temp.item;
            
        }
        
    }


    // remove and return the item from the back
    public Item removeLast(){
        if(size == 0) {
            throw new NoSuchElementException();
        }
        else if(size == 1){
            Item temp = last.item;
            first = null;
            last = null;
            size--;
            return temp;
            
        }
        else{
            Node temp = last;
            last = last.prev;
            last.next = null;
            size--;
            return temp.item;
            
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator(first);
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current;

    public DequeIterator(Node first){
        current = first;
    }
    public boolean hasNext() {
        return current != null;
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
    public Item next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Item item = current.item;
        current = current.next;
        return item;
    }
}
public static void main(String[] args) {
    Deque<Integer> object = new Deque<Integer>();
    object.addFirst(5);
    object.addLast(3);
    System.out.println(object.removeFirst());
}
}
