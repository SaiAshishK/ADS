/**
 * creates an array of medians.
 * @author K. Sai Ashish
 */
class Solution{
	/**
	 * forms an array of medians.
	 * @param arr has array of elements
	 * @return array of medaians
	 */
	// time complexity- O(N)
	public static double[] dynamicMedian(double[] arr){
		double median = 0;
		int len = arr.length;
		Maxpq<Double> max = new Maxpq(arr.length);
		Minpq<Double> min = new Minpq(arr.length);
		for (int i = 0; i < len; i++) {
			if (arr[i] >= median) {
				min.insert(arr[i]);
				
			} else {
				max.insert(arr[i]);
			}

			if (min.size() > max.size() + 1) {
				max.insert(min.max());
				min.delMax();
			}

			if (max.size() > min.size()+1) {
				min.insert(max.max());
				max.delMax();
			}
			
			if (min.size() == max.size()) {
				median = (max.max() + min.max())/2.0;
			} 
			else if (min.size() < max.size()) {
				median = (double)max.max();
			}
			else if(min.size() > max.size()) {
				median = (double)min.max();
			}

			arr[i] = median;
		}
		return arr;
	}
}