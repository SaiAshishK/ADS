import java.util.Arrays;
class learningByDoing {
    public static void main(String[] args) {
        int[] a = {-2,2,3,4,4,4,5,6,6};
        System.out.println(learningByDoing.amount(a));
        
    }
    public static int amount(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length -1; i++) {
            if(a[i] == a[i + 1]) {
                count++;

            }
        }
        return count;
        
    }
}