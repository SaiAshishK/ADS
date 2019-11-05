class Solution{

	/**
	 * This method is the implementation
	 * of quick sort
	 *
	 * @param      arr   The unsorted array
	 *
	 * @return     { The sorted array }
	 */
	public static int[] quickSort(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		sort(arr, low, high);
		return arr;
	}

	/**
	 * This is the sort method which 
	 * actually implements the sort logic
	 * usign recursion
	 *
	 * @param      arrayData  The array data
	 * @param      low        The low
	 * @param      high       The high
	 */
	private static void sort(int[] arrayData, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arrayData, low, high);
			sort(arrayData, low, partitionIndex - 1);
			sort(arrayData, partitionIndex + 1, high);
		}
	}

	/**
	 * This method paritions the array
	 * picks a pivot element at the end
	 * sorts the array such that all the
	 * elements to the left of pivot are less than pivot
	 * elements to the right are greater than pivot.
	 *
	 * @param      arrayData  The array data
	 * @param      low        The low
	 * @param      high       The high
	 *
	 * @return     { returns the sorted pivot index }
	 */
	private static int partition(int[] arrayData, int low, int high) {
		int pivot = arrayData[high];
		// int index = low - 1;
		int index = low;

		for (int j = low; j <= high	- 1; j++) {
			if (arrayData[j] < pivot) {
				// index++;
				int temp = arrayData[index];
				arrayData[index] = arrayData[j];
				arrayData[j] = temp;
				index++;
			}
		}
		// int temp = arrayData[index + 1];
		// arrayData[index + 1] = arrayData[high];
		// arrayData[high] = temp;
		int temp = arrayData[index];
		arrayData[index] = arrayData[high];
		arrayData[high] = temp;
		// return index + 1;
		return index;
	}
	
}
