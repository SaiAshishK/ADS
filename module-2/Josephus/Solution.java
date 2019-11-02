import java.util.*;
class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		Queue<Integer> q = new LinkedList<>();
		String str = "";
		for( int i = 0;i < a; i++) {
			q.add(i);
	}
	int x = 0;
	while(q.size() > 1) {
		for(int i = 0; i < b-1;i++) {
			x=q.remove();
			q.add(x);
		}
		str = str + q.remove() + " ";
	}
	str = str + q.remove();
		return str;
	}
}
