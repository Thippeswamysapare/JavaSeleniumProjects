package testpackage;

public class FirstNonRepeatingChars {
	
	public static char FirstNonRepeatCharacter(String name)
	{
		String input=name;
		int len=input.length();
		
		for(int i=0;i<len;i++)
		{ 	
			boolean result=false;
			for(int j=0; j<len;j++)
			{
			
				if(i !=j && input.charAt(i)==input.charAt(j))
				{
					result= true;
					break;
				}
			}
			if(!result)
				return input.charAt(i);
					
		}
		return '$';
			
	}
	
	public static void main(String arr[]) {
		
		
		char ch= FirstNonRepeatCharacter("geeksforgeeks");
		System.out.println("Non repeatable char is : "+ ch);
		
	}

}
