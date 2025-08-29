package testpackage;

import java.util.Stack;

public class ReverseWordInString {

	public static void main(String[] args) {
		String s1= "i.like.java.very.much"; // 6
		StringBuilder word= new StringBuilder();
		Stack<String> stack=new Stack<>();
		for(int i=0;i<s1.length();i++)
		{
			 
			if(s1.charAt(i)!='.')
			{
				word=word.append(s1.charAt(i));
			}
			else
				if(word.length()>0) 
				{
					stack.push(word.toString());
					word.setLength(0);
				}
			
		}
		
		if(word.length()>0)
			stack.push(word.toString());
		
		System.out.println(stack);
		
		StringBuilder result= new StringBuilder();
		while(!stack.isEmpty())
		{
			result.append(stack.pop().toString());
			result=result.append(".");
			
		}
		System.out.println("Final output: "+result);
	}
}
