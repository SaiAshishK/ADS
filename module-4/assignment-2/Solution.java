import java.util.Arrays;
class Solution{

	/**
	 * This method implements the merge sort
	 *
	 * @param      arr   The unsorted array
	 *
	 * @return     { The sorted array }
	 */
	public static String[] mergeSort(String[] arr){
		int left = 0;
		int right = arr.length - 1;
		sort(arr);
		return arr;
	}
	
	/**
	 * This method divides the original array into
	 * left and right by the mid value and calls the 
	 * merge method to sort them.
	 *
	 * @param      arrayData  The array data
	 */
	private static void sort(String[] arrayData) {
		int size = arrayData.length;
		if (size < 2) {
			return;
		}
		int mid = size / 2;
		String[] left = new String[mid];
		String[] right = new String[size - mid];

		// Copying the data into left and right array
		for (int i = 0; i < mid; i++) {
			left[i] = arrayData[i];
		}

		for (int i = mid; i < arrayData.length; i++) {
			right[i - mid] = arrayData[i];
		}
		sort(left);
		sort(right);
		merge(left, right, arrayData);
	}

	/**
	 * This method merges the left array and right array
	 * by sorting it
	 *
	 * @param      left       The left
	 * @param      right      The right
	 * @param      arrayData  The array data
	 */
	private static void merge(String[] left, String[] right, String[] arrayData) {
		int i = 0;
		int j = 0;
		int k = 0;
		int leftSize = left.length;
		int rightSize = right.length;

		while (i < leftSize && j < rightSize) {
			if (left[i].compareTo(right[j]) <= 0) {
				arrayData[k] = left[i];
				i++;
			} else {
				arrayData[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			arrayData[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			arrayData[k] = right[j];
			j++;
			k++;
		}	
	}	
}