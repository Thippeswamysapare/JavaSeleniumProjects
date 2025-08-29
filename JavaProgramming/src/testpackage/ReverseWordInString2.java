package testpackage;

import java.util.Stack;

public class ReverseWordInString2 {

	public static void main(String[] args) {
		String s1= "i.like.java.very.much"; // 6
		StringBuilder word= new StringBuilder();
		Stack<String> stack=new Stack<>();
		String[] store = null;
		int j=0;
		for(int i=0;i<s1.length();i++)
		{
			 
			if(s1.charAt(i)!='.')
			{
				word=word.append(s1.charAt(i));
			}
			else
				if(word.length()>0) 
				{
					
					store[j]=word.toString();
					//stack.push(word.toString());
					word.setLength(0);
					j++;
				}
			
		}
		
		if(word.length()>0)
			//stack.push(word.toString());
			store[j+1]=word.toString();
		
		System.out.println(stack);
		
		StringBuilder result= new StringBuilder();
//		while(!stack.isEmpty())
//		{
//			result.append(stack.pop().toString());
//			result=result.append(".");
//			
//		}
		for (int k=0;j<store.length-1;k++)
		{
			result.append(store[k].toString());
//			result=result.append(".");
		}
		System.out.println("Final output: "+result);
	}
}
