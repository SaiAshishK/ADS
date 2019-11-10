//@ author K. Sai Ashish
public class SeparateChainingHashST<Key, Value> {
    private static final int CAP = 4;

    private int number;                                // number of key-value pairs
    private int size;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list


    /**
     * Initializes an empty symbol table.
     */
    public SeparateChainingHashST() {
        this(CAP);
    } 

    /**
     * Initializes an empty symbol table with {@code size} chains.
     * @param size the initial number of chains
     */
    public SeparateChainingHashST(int size) {
        this.size = size;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[size];
        for (int i = 0; i < size; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    } 

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < size; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.size  = temp.size;
        this.number  = temp.number;
        this.st = temp.st;
    }

    // hash value between 0 and size-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % size;
    } 

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return number;
    } 

    /**
     * Returns true if this symbol table is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @throws IllegalArgumentException if KEY IS NULL
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    } 

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @throws IllegalArgumentException if KEY IS NULL
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    /**
     * Inserts the specified key-value pair into the symbol table.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if KEY IS NULL
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (number >= 10*size) resize(2*size);

        int i = hash(key);
        if (!st[i].contains(key)) number++;
        st[i].put(key, val);
    } 

    /**
     * Removes the specified key
     * @param  key the key
     * @throws IllegalArgumentException if KEY IS NULL
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) number--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (size > CAP && number <= 2*size) resize(size/2);
    } 

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < size; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    } 

}