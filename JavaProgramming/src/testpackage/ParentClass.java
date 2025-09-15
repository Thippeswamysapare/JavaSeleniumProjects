package testpackage;

public class ParentClass {

	public static int num=2000;
	public static void DisplayNumber(int a)
	{
		System.out.println("Number is : "+a);
	}
	
	public static void DisplayNumber(int a,char ch)
	{
		System.out.println("Number is : "+a);
		System.out.println("Character is : "+ch);
	}
	
	public  void DisplayNumber()
	{
		System.out.println("This is Parent Class");
	}

}
