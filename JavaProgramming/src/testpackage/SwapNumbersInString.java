package testpackage;

public class SwapNumbersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str= "abc12java34uji234";
		
		StringBuilder result= new StringBuilder();
		StringBuilder sb= new StringBuilder();
		
		for(char ch : str.toCharArray())
		{
			if(Character.isDigit(ch))
			{
			sb.append(ch);	
			}
			else
			{
				if(sb.length()>0)
				{
					result.append(sb.reverse());
					sb.setLength(0);
				}
				result.append(ch);
			}	
			
		}
		if(sb.length()>0)
		{
			result.append(sb.reverse());
		}
			System.out.println("Resulted String "+result );
	}

}
