package testpackage;

public class PolindromString {
	public static void main(String[] arg)
	{
		method1("racecar");
		method2("madamaa");
	}
	public static void method1(String s1)
	{
		 
		StringBuilder sb1= new StringBuilder();
		
		for(int i=s1.length()-1; i>=0 ;i--)
		{
			sb1=sb1.append(s1.charAt(i));
		
		}
		System.out.println("Origina stirng : "+s1); 
		System.out.println("Revernse stirng : "+sb1); 
		
		if(s1.equals(sb1.toString()))
		{
			System.out.println("String is polindrom");
		}
		else
		{
			System.out.println("String is not a polindrom");
		}
	}
	
	public static void method2(String s2)
	{
		int left=0;
		int right=s2.length()-1;
		int count=0;
		
		while (left < right)
		{
			if(s2.charAt(left)!=s2.charAt(right))
			{
				count++;
			}
			left++;
			right--;
		}
		if (count >0)
			System.out.println("Given String '"+s2+ "'is not polindrom");
		else
			System.out.println("Given String '"+s2+ "'is polindrom");
	}
}
