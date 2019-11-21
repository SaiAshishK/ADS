import java.util.*;
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
        array[size++] = item; 

    }

    // remove and return a random item
    public Item dequeue(){
        Random random = new Random();
        int p = random.nextInt(size);
        Item temp = array[p];
        array[p] = array[size];
        array[size] = temp;
        size--;
        return temp;

    }

    // return a random item (but do not remove it)
    public Item sample(){
        Random random = new Random();
        int p = random.nextInt(size);
        return array[p];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        int x;

    public boolean hasNext() {
        return x < size;
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
    public Item next() {
        if(!hasNext()) {
            return null;
        }
        Item i = arr[x];
        x++;
        return i;
    }
    }

    // unit testing (required)
    public static void main(String[] args){

    }

    

   

}