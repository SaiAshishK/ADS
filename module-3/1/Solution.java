import java.util.*;
class Solution{
	public int[] sortInsertion(int[] arr){
		// fill you code Here
		int j,temp;
		for(int i = 1; i < arr.length; i++) 
		{
			j = i - 1;
			temp = arr[i];
			while(j >= 0 && arr[j] > temp)
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		return arr;
	}
	public int[] sortSelection(int[] arr){
		// fill you code Here
		for(int i = 0; i < arr.length-1 ; i++)
		{
			int min = i;
			for(int j = i+1 ;j< arr.length; j++) 
			{
				if(arr[j] < arr[min])
				{
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}
}