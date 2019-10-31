import java.util.Arrays;
public class sortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,4,6,8,9};
        
        int[] c = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int key = 0;
        //System.out.println();
        
        while ( i <  arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]){
                c[key] = arr1[i];
                key++;
                i++;
            } 
            else {
                c[key] = arr2[j];
                j++;
                key++;
                
            }
                   } 
        while (i < arr1.length){
            c[key] = arr1[i];
            i++;
            key++;
        }
        while(j < arr2.length) {
            c[key] = arr2[j];
            key++;
            j++;
        }
        System.out.println(Arrays.toString(c));
        //return Arrays.toString(c);
    }

    }
