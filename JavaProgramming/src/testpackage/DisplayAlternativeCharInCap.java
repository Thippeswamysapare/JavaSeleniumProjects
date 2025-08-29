package testpackage;

public class DisplayAlternativeCharInCap {
	
	public static void main (String[] orgs )
	{
		String str="ahfy3wnfpmAusuwq466";
		StringBuilder sb= new StringBuilder();
		
		for(int i=0;i < str.length(); i++)
		{
			char ch=str.charAt(i);
			if(i%2==0)
			{
				char upprCase= Character.toUpperCase(ch);
				sb.append(upprCase);
			}
			else
				sb.append(ch);
			
		}
			
		System.out.println("String: "+ sb);
	}

}
