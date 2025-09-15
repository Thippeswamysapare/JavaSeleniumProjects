package testpackage;

import org.testng.annotations.Test;

public class StringOperations {
	
	
	public static void main(String[] a)
	{
		String str1="Java selenium";
		
		System.out.println("String : "+str1);
		System.out.println("Char at 3 : "+str1.charAt(3));
		char[] ch= str1.toCharArray();
		StringBuffer sb= new StringBuffer();
		int chlen=ch.length;
		for(int i=0;i<chlen;i++)
			{
		System.out.print(ch[i]);
		sb.append(ch[i]);
			}
		System.out.println();
		System.out.println("String from String buffer: "+sb);
		
	}
}
