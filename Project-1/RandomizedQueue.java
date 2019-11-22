import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    // construct an empty randomized queue
        private Item[] array;
        private int size;

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
    private void resize(int n){
        Item[] temp = (Item[]) new Object[2*n];
        for(int i = 0; i < n ; i++){
            temp[i] = array[i];
            array = temp;
        }
        
    }

    // add the item
    public void enqueue(Item item){
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(size == array.length){
            resize(array.length);
        }
        array[size++] = item; 

    }

    // remove and return a random item
    public Item dequeue(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        else{
        Random random = new Random();
        int p = random.nextInt(size);
        Item temp = array[p];
        array[p] = array[size-1];
        array[size-1] = temp;
        size--;
        return temp;
        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(size == 0){
            throw new NoSuchElementException();
        }
        else{
        Random random = new Random();
        int p = random.nextInt(size);
        return array[p];
    }
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
        Item i = array[x];
        x++;
        return i;
    }
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> obj = new RandomizedQueue<Integer>();
        obj.enqueue(51);
        obj.enqueue(2);
        System.out.println(obj.dequeue());
    }
}
