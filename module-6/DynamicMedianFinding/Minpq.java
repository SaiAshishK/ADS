import java.util.Comparator;
/**
 * performs MaxPQ operations
 * @param <Key> 
 * @author K. Sai Ashish
 */
public class Minpq<Key extends Comparable<Key>> {
    private Key[] pq;
    private int size;
    private Comparator<Key> comparator;
     /**
     * array with required capacity
     * @param capacity
     */
    public Minpq(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }
    /**
     * checks weather the array is empty.
     * @return true or false after checking.
     */
    //time complexity-O(1)
    public boolean isEmpty() {
        if (size == 0) return true;
        else  return false;
    }
    /**
     * size of ther array
     * @return size
     */
    //time complexity-O(1)
    public int size() {
        return size;
    }
    /**
    * helps the largest element to return to its position.
    * @param k key .
    */
    //time complexity-O(logN)
    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
    /**
    * helps the lowest element to return to its position.
    * @param k key
    */
    //time complexity-O(N)
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
    /**
     * inserts key in to array at the end and then calls the swim.
     * @param key element to be added.
     */
    //time complexity-O(1)
    public void insert(final Key key) {
        pq[++size] = key;
        swim(size);
    }
    /**
     * deletes the greatest element.
     * @return the deleted key
     */
    //timecomplexity-O(1)
    public Key delMax() {
        Key max = pq[1];
        swap(1, size--);
        sink(1);
        pq[size + 1] = null;
        return max;
    }
    /**
    * returns the largest element
    * @return maximun element
    */
    //time complexity-O(1)
    public Key max() {
        return pq[1];
    }
    /**
     * checks whether the first element is greater than the second element.
     * @param i first element.
     * @param j second element.
     * @return true or false
     */
    //time complexity-O(1)
    private boolean greater(int i, int key) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[key]) > 0;
        } else {
            return comparator.compare(pq[i], pq[key]) > 0;
        }
    }
    /**
     * exchanges the elements.
     * @param i first element
     * @param j second element.
     */
    //time complexity-O(1)
    private void swap(int i, int key) {
        Key temp = pq[i];
        pq[i] = pq[key];
        pq[key] = temp;
    }
}