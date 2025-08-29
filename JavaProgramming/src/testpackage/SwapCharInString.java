package testpackage;

public class SwapCharInString {
	
	public static void main(String[] arg)
	{
		String str= "abc12java34uji234Rgjk39";
		StringBuilder sb=new StringBuilder();
		StringBuilder result=new StringBuilder();
		
		for(char ch : str.toCharArray())
		{
			if(Character.isDigit(ch))
			{
				if(sb.length()>0)
				{
					result.append(sb.reverse());
					sb.setLength(0);//break;
				}
				result.append(ch);
			}
			else
			{
				sb.append(ch);
			}
						
		}
		if(sb.length()>0)
			result.append(sb.reverse());
		
		System.out.println("Resulted String "+result);
	}

}
