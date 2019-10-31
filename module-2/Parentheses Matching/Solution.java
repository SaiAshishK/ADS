import java.util.*;
class Solution{
	public static String isMatching(String str){
		// fill you code Here
		char[] data = str.toCharArray();
		int length = data.length;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < length; i++)
		{
			if(data[i] == '(' || data[i] == '[' || data[i] == '{')
			{
				stack.push(data[i]);
			}
			else if(data[i] == ']')
			{
				if(stack.empty() == false)
				{
					if(stack.pop() != '[')
					{
						return "NO";
					}
				}
				else{
					return "NO";
				}
			}
			else if(data[i] == '}')
			{
				if(stack.empty() == false)
				{
					if(stack.pop() != '{')
					{
						return "NO";
					}
				}
				else
				{
					return "NO";
				}
			}
			else if(data[i] == ')')
			{
				if(stack.empty() == false)
				{
					if(stack.pop()!='(')
					{
						return "NO";

					}
				}
				else{
					return "NO";
				}
			}
		}
		if(stack.empty() == true)
		{
			return "YES";
		}
		else{
			return "NO";
		}
	
	}
}