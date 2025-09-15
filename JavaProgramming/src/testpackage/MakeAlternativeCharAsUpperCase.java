package testpackage;

public class MakeAlternativeCharAsUpperCase {
	
public static void main(String[] arr)
{
	String input = "ltimindtree";
    StringBuilder result = new StringBuilder();

   //char ch[]=input.toCharArray();
  
   int len= input.length();
  for(int i=0; i<len ;i++)
  {
	  char ch= input.charAt(i);
	  //System.out.println(ch);
	  if(i%2==0)
	  {
		  result.append(Character.toUpperCase(ch));
	  }
	  else
		  result.append(ch);
	  
  }
  
  System.out.println(result);
}

}
