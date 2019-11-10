// @ author K. Sai Ashish
public class LinearProbingHashST<Key, Value> {
    private static final int CAP = 4;

    private int number;           // number of key-value pairs in the symbol table
    private int size;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values


    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(CAP);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        size = capacity;
        number = 0;
        keys = (Key[])   new Object[size];
        vals = (Value[]) new Object[size];
    }

    /**
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return number;
    }

    /**
     * Returns true if the symbol table is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @throws IllegalArgumentException if key is null
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    // hash function for keys - returns value between 0 and M-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int k = 0; k < size; k++) {
            if (keys[k] != null) {
                temp.put(keys[k], vals[k]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        size    = temp.size;
    }

    /**
     * Inserts the specified key-value pair 
     * Deletes the specified key
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if key is null
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        // double table size if half of it is full
        if (number >= size/2) resize(2*size);

        int k;
        for (k = hash(key); keys[k] != null; k = (k + 1) % size) {
            if (keys[k].equals(key)) {
                vals[k] = val;
                return;
            }
        }
        keys[k] = key;
        vals[k] = val;
        number++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @throws IllegalArgumentException if key is null
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int k = hash(key); keys[k] != null; k = (k + 1) % size)
            if (keys[k].equals(key))
                return vals[k];
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if key is null
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position k of key
        int k = hash(key);
        while (!key.equals(keys[k])) {
            k = (k + 1) % size;
        }

        // delete key and associated value
        keys[k] = null;
        vals[k] = null;

        // rehash all keys in same cluster
        k = (k + 1) % size;
        while (keys[k] != null) {
            // delete keys[k] an vals[k] and reinsert
            Key   keyToRehash = keys[k];
            Value valToRehash = vals[k];
            keys[k] = null;
            vals[k] = null;
            number--;
            put(keyToRehash, valToRehash);
            k = (k + 1) % size;
        }

        number--;

        // halves size of array if it's 12.5% full or less
        if (number > 0 && number <= size/8) resize(size/2);

        assert check();
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int k = 0; k < size; k++)
            if (keys[k] != null) queue.enqueue(keys[k]);
        return queue;
    }
    private boolean check() {

        // check that hash table is at most 50% full
        if (size < 2*number) {
            System.err.println("Hash table size size = " + size + "; array size number = " + number);
            return false;
        }

        // check that each key in table can be found by get()
        for (int k = 0; k < size; k++) {
            if (keys[k] == null) continue;
            else if (get(keys[k]) != vals[k]) {
                System.err.println("get[" + keys[k] + "] = " + get(keys[k]) + "; vals[k] = " + vals[k]);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LinearProbingHashST l = new LinearProbingHashST();
        l.put("A", 1);
        l.put("B", 4);
        System.out.println(l.get("A"));
    }
}