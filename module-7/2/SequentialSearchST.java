import java.util.Arrays;

public class SequentialSearchST<Key extends Comparable<Key>,
Value extends Comparable<Value>> {
	/**.
	 * Stores the keys
	 */
	private Key[] keys;

	/**.
	 * Stores the values
	 */
	private Value[] values;

	/**.
	 * Keeps track of the items in the array
	 */
	private int count;

	/**.
	 * Constructs a new instance.
	 */
	SequentialSearchST() {
		this.keys = (Key[]) new Comparable[2];
		this.values = (Value[]) new Comparable[2];
		this.count = 0;
	}

	/**.
	 * Constructs a new instance.
	 *
	 * @param      capacity  The capacity
	 */
	SequentialSearchST(final int capacity) {
		this.keys = (Key[]) new Comparable[capacity];
		this.values = (Value[]) new Comparable[capacity];
		this.count = 0;
	}

	/**.
	 * This method adds the data to the array
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void put(Key key,Value value) {
		if (key == null) {
			return;
		}

		// Resize  of the array
		if (count == keys.length) {
			resize();
		}

		// Check for the presence of the element
		int index = getIndex(key);
		if (index != -1) {
			values[index] = value;
			return;
		}

		// Adding the data to the
		// end of the array
		keys[count] = key;
		values[count] = value;
		count++;
	}

	/**.
	 * Gets the specified key.
	 *
	 * @param      key   The key
	 */
	public Value get(final Key key) {
		Value result = null;
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (keys[i].compareTo(key) == 0) {
				result = values[i];
				index = i;
				break;
			}
		}
		shiftData(index);
		return result;
	}

	/**.
	 * Returns the keys in the reverse order
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = count - 1; i >= 0; i--) {
			queue.enqueue(keys[i]);
		}
		return queue;
	}

	/**.
	 * This method finds the presence of a
	 * key passed as argument in the keys
	 * array and gives the index
	 *
	 * @param      key   The key
	 */
	private int getIndex(final Key key) {
		if (count != 0) {
			for (int i = 0; i < count; i++) {
				if (keys[i].compareTo(key) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	/**.
	 * This method shifts all the elements
	 * to the right and puts the elements
	 * at the index position in the front.
	 *
	 * @param      index  The index
	 */
	private void shiftData(final int index) {
		Key tempKey = keys[index];
		Value tempValue = values[index];

		// Do not shift if the element is at 0
		if (index == 0 || index == -1) {
			return;
		}

		// Shifting the values to the right
		for (int i = index; i > 0; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}

		// putting the element in the front
		keys[0] = tempKey;
		values[0] = tempValue;
	}

	/**.
	 * Doubles the size of the array
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
