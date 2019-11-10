import java.util.Arrays;
public class BinarySearchST<Key extends Comparable<Key>,
    Value extends Comparable<Value>> {
    private Key[] keys;
    private Value[] values;
    private int count;

    /**.
     * Constructs a new instance.
     */
    BinarySearchST() {
        this.keys = (Key[]) new Comparable[2];
        this.values = (Value[]) new Comparable[2];
        this.count = 0;
    }

    /**.
     * Constructs a new instance.
     *
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Comparable[capacity];
        this.count = 0;
    }

    /**.
     * This method adds the element to the
     * symbol table
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            return;
        }
        int index = rank(key);

        // If the array is empty
        if (count == 0) {
            keys[count] = key;
            values[count] = value;
            count++;
            return;
        }

        // Check if the element is already present
        if (index < count && keys[index].compareTo(key) == 0) {
            values[index] = value;
            return;
        }

        // Check to see of the array is full
        if (count == keys.length) {
            resize();
        }

        // Shifting the elements to the right
        // by one place to make a hole
        for (int i = count; i > index; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[index] = key;
        values[index] = value;
        count++;
    }

    /**.
     * Deletes the given key.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            return;
        }
        if (count == 0) {
            return;
        }

        // Compute the rank to get the index
        int index = rank(key);

        // Check to see if element is not present
        if (keys[index].compareTo(key) != 0) {
            System.out.println("Key is not present in the data");
            return;
        }

        // Shifting the elements to the left by one
        // to replace the element at that index
        for (int i = index; i < count - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        count--;


    }

    /**.
     * Deletes the minimum element of the array
     */
    public void deleteMin() {
        if (count == 0) {
            return;
        }
        delete(keys[0]);
    }

    /**.
    * This method checks if the
    * key is present in the key array
    * or not
    *
    * @param      key   The key
    */
    public boolean contains(final Key key) {
        if (count == 0) {
            return false;
        }
        int index = rank(key);
        if (index < count && keys[index].compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    /**.
     * Gets the specified key.
     *
     * @param      key   The key
     */
    public Value get(final Key key) {
        if (count == 0) {
            return null;
        }
        int index = rank(key);
        if (index < count && keys[index].compareTo(key) == 0) {
            return values[index];
        }
        return null;
    }

    /**.
     * This method returns the max key
     */
    public Key max() {
        if (count == 0) {
            return null;
        }
        return keys[count - 1];
    }

    /**.
     * Largest key that is present which is
     * less than the key in the argument
     *
     * @param      key   The key
     */
    public Key floor(final Key key) {
        if (count == 0) {
            return null;
        }
        int index = rank(key);
        if (index < count && keys[index].compareTo(key) == 0) {
            return keys[index];
        }
        return keys[index - 1];
    }

    /**.
     * This method returns all the keys
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < count; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    /**.
     * This method returns the number of
     * keys in the symbol table tha
     *
     * @param      key   The key
     */
    public int rank(final Key key) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key.compareTo(keys[mid]) < 0) {
                high = mid - 1;
            } else if (key.compareTo(keys[mid]) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    /**.
     * This method gives us the size
     * of the data
     */
    public int size() {
        return count;
    }

    /**
     * This method prints out the data.
     */
    public void displayData() {
        for (int i = 0; i < count; i++) {
            System.out.println("Key: " + keys[i] + " Value: " + values[i]);
        }
    }

    /**.
     * This method doubles the size
     * of the arrays
     */
    private void resize() {
        Key[] tempKeys = Arrays.copyOf(
                             this.keys, this.keys.length * 2);
        Value[] tempValues = Arrays.copyOf(
                                 this.values, this.values.length * 2);
        this.keys = tempKeys;
        this.values = tempValues;
    }
}
