/**
 * performs MaxPQ operations
 * @param <Key> 
 * @author K. Sai Ashish
 */
public class Maxpq<Key extends Comparable<Key>> {
    /**
     * pq array of type key.
     */
    private Key[] pq;
    /**
     * size of the pq array.
     */
    private int size;
    /**
     * array with required capacity
     * @param capacity
     */
    public Maxpq(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }
    /**
     * checks weather the array is empty.
     * @return true or false after checking.
     */
    //time complexity-O(1)
    public boolean isEmpty() {
        return (size == 0);
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
     * inserts key in to array at the end and then calls the swim.
     * @param key element to be added.
     */
    //time complexity-O(1)
    public void insert(Key key) {
        pq[++size] = key;
        swim(size);
    }
     /**
     * helps the largest element to return to its position.
     * @param k key .
     */
    //time complexity-O(logN)
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
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
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
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
     * checks wheather thefirst element is less then the second element.
     * @param i first key
     * @param j second key
     * @return true or false
     */
    //time complexity-O(1)
    private boolean less(int i, int key) {
        return pq[i].compareTo(pq[key]) < 0;
    }
    /**
     * exchanges two elements
     * @param i
     * @param j
     */
    //time complexity-O(1)
    private void swap(int i, int key) {
        Key temp = pq[i];
        pq[i] = pq[key];
        pq[key] = temp;
    }
}