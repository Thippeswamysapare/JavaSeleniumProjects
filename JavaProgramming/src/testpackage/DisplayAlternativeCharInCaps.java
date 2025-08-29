package testpackage;

public class DisplayAlternativeCharInCaps {
	
	public static void main(String[] arg)
	{
		String s= "signature";
		StringBuilder sb= new StringBuilder();
		// System.out.println("Stirng builder"+sb);
		for(int i=0; i< s.length();i++)
		{
			//System.out.println(s.charAt(i));
			char ch= s.charAt(i);
			if(i%2==0)
			{
				 sb=sb.append(Character.toUpperCase(ch));
			}
			else
				sb=sb.append(ch);
		}
		
		System.out.println("Resulted String --- "+ sb);
	}

}
