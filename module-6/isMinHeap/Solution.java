class Solution{
	public static boolean isMinHeap(double[] arr){
		double[] arr2 = new double[arr.length+1];
		arr2[0] = 0;
		if(arr.length==0)
		{
			return false;
		}
		for(int i = 0 ; i < arr.length-1 ; i++)
		{
			arr2[i+1] = arr[i];
		}
		int flag = 0;
		for(int j = arr.length-1 ; j > 2; j--){
			if(arr2[j]>=arr2[j/2])
			{
				
			}
			else
			{
				flag=1;
			}
			
		}
		
		return (flag!=1);
	}
}