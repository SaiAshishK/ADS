import java.util.Arrays;
class threeSum {
    public static void main(String[] args) {
        int a[] = {30, -40, -20, -10, 40, 0, 10, 5};
        Arrays.sort(a);
        System.out.println(threeSumPair(a));
    }
    public static int threeSumPair(int a[]) {
        int low = 0;
        int high = a.length-1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j< a.length; j++) {
                int key = -(a[i] + a[j]);
                low = j + 1;
                high = a.length-1;
                while(low<=high) {
                    int mid = (low+high)/2;
                    if (key < a[mid]) {
                        high = mid-1;
                    
                    }
                    else if (key > a[mid]) {
                        low = mid + 1;
                    }
                    else {
                        count++;
                        System.out.println(" " +key+ " " + a[i]+ " " + a[j]);
                        // System.out.println(a[i]);
                        // System.out.println(a[j]);
                        break;
                    }
                }
            }
        }
    
        return count;
    }
}