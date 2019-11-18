public class Cards implements Comparable<Cards> {
    int suit;
    int value;

    public Cards(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public int compareTo(Cards thatCard) {
       if (this.suit < thatCard.suit) 
       {
           return -1;
       }
       else if (this.suit > thatCard.suit) 
       {
           return 1;
        }
       else {
           if (this.value < thatCard.value)
           { return -1;
             }    
           else if (this.value < thatCard.value)
           { return 1;
            }
           return 0;
       }
    }
    public String toString () {
        String str = "";
        if (this.suit == 1) str = str + "S";
        else if (this.suit == 2) str = str + "H";
        else if (this.suit == 3) str = str + "C";
        else if (this.suit == 4) str = str + "D";
        
        if (this.value == 1) str += "A";
        else if (this.value == 10) str+="T";
        else if (this.value == 11) str+="J";
        else if (this.value == 12) str+= "Q";
        else if(this.value == 13) str+= "K";
        else str += this.value;

        

        return str;
    }

}
