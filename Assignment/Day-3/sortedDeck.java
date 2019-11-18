
import java.util.*;
/**
 * @@author - K. Sai Ashish
 * Using Card class here 
 * 
 */

public class sortedDeck {
    public  Cards[] sortCards(Cards[] array) {
        // Time complexity - O(n*n)
        for(int i = 0; i < array.length; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min])<0)
                 { 
                     min =j;
                    }
            }
            Cards key = array[i];
            array[i] = array[min];
            array[min] = key;
			
		}
		return array;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] suits = {1,2,3,4};
        int size = 0;
        Cards[] array = new Cards[52];
        // Time complexity - O(n*m)
        for( int i = 0; i<suits.length; i++) {
            for(int j = 0; j<nums.length; j++) {
                array[size++] = new Cards(suits[i], nums[j]);
            }
        }
        sortedDeck obj = new sortedDeck();
        List<Cards> cardlist = Arrays.asList(array);
        Collections.shuffle(cardlist);
        cardlist.toArray(array);
        System.out.println(Arrays.toString(obj.sortCards(array)));
    }
}