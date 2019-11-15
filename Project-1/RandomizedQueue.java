public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queue
        Item[] array;
        int size;
        public RandomizedQueue() {
            array = (Item[]) new Object[10];
            size = 0;
        }
        
    

    // is the randomized queue empty?
    public boolean isEmpty(){
        return (size == 0);
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){

    }

    // remove and return a random item
    public Item dequeue(){

    }

    // return a random item (but do not remove it)
    public Item sample(){

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){

    }

    // unit testing (required)
    public static void main(String[] args){

    }

    

   

}