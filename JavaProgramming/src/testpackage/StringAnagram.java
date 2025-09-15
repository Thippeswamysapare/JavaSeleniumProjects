package testpackage;

import java.util.Arrays;

public class StringAnagram {

	
	public static void main(String[] arg)
	{
		// Online Java Compiler
		// Use this editor to write, compile and run your Java code online

		
		  String str1= "racecar";
		  String str2="carrace";
		  StringBuffer sb=new StringBuffer();
		  boolean status=false;
		  
		// Remove whitespace and convert to lowercase for case-insensitive comparison
		  str1=str1.replaceAll("\\s", "").toLowerCase();
		  str2=str2.replaceAll("\\s", "").toLowerCase();
		  
		// If lengths are different, they cannot be anagrams
		  if(str1.length()==str2.length())
		  {
			 //coverting string into CharArray
			  char[] charArray1=str1.toCharArray();
			  char[] charArray2=str2.toCharArray();
			  
			  //Sort the char array
			  Arrays.sort(charArray1);
			  Arrays.sort(charArray2);
			  
			  status= Arrays.equals(charArray1, charArray2);
		  }
		  else
			  status=false;
		  
		  if(status==true)
			  System.out.println("String are anagram");
		  else
			  System.out.println("String are not anagram");
		
	}
	
}
