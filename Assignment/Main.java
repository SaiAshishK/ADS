import java.util.*;
public class Main{


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arraySize = sc.nextInt();
    double[] a = new double[arraySize];
    /** 
     * taking input in a for loop
     *  Time Complexity : n
    */
    for ( int k  = 0; k < arraySize ; k++){
        double arrayVal = sc.nextDouble();
        a[k] = arrayVal;
    }
    double min = a[0];
    double max = a[0];
    /**
     * Finding min and max in the array
     * Time complexity : n 
     * 
     */
    for (int i = 0; i < a.length ; i++){
        if (a[i] <= min){
            min = a[i];
        }
        if(a[i]> max){
            max = a[i];
        }
    }
    System.out.println(min + " , " + max);
    

    }
}