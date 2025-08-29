package testpackage;

public class CountOfvowels {

	public static void main(String[] arg)
	{
		String str= "java programming language";
		int count=0;
		for (char c : str.toLowerCase().toCharArray())
		{
			if("aeiou".indexOf(c)!= -1)
				count ++;
		}
		System.out.println("Vowels count is : "+ count);
	}
}
