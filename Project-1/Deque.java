public class Deque<Item> implements Iterable<Item> {
    class Node{
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
        Node newNode = new Node(item);
        newNode.prev = first;
        newNode.next = null;
        if(first!=null){
            first.prev = newNode;
        }
        first = newNode;


    }

    // add the item to the back
    public void addLast(Item item){
        
            Node newNode = new Node(item);
            last.next = newNode;
            newNode.next = null;
        
        }

    

    // remove and return the item from the front
    public Item removeFirst(){
        if(size!=0) {
            Node temp = first;
            first=first.next;
            first.prev = null;
            return temp.item;
        }
        else{
            return null;
        }
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(size!=0) {
            Node temp = last;
            last = last.prev;
            last.next = null;
            return temp.item;
        }
        else{
            return null;
        }

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){

    }

    // unit testing (required)
    public static void main(String[] args){

    }

}