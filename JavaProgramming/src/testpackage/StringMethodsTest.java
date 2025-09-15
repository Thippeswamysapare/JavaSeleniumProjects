package testpackage;

public class StringMethodsTest {

	//https://www.digitalocean.com/community/tutorials/java-programming-interview-questions
	public static void main(String[] args) {
		
		String str1= "This is Java Program testing";
		String str2="maybe";
		
		//Find the length of the String
		System.out.println("Length of String is : "+str1.length());
		//Reverse String
		reverseOfString(str1);
		swapNumbersWithoutThirdVariable();
		checkVowelisPresentinString(str2);
		
	}
	
	public static void reverseOfString(String input)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=input.length()-1;i>=0;i--)
		{
			sb.append(input.charAt(i));
		}
		System.out.println("Reverse of String is : "+sb);
	}

	public static void swapNumbersWithoutThirdVariable()
	{
		int a=65;
		int b=34;
		System.out.println("Numbers before swap: a="+a+" b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Numbers after swap: a="+a+" b="+b);
	}
	
	public static void checkVowelisPresentinString(String str)
	{
		boolean status=false;
		status= str.toLowerCase().matches(".*[aeiou].*");
		if(status==true)
		{
			System.out.println("String contains vowles");
		}
		else
			System.out.println("String does not contain vowels");
	}
	
	
}