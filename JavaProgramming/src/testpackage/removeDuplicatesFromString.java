package testpackage;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicatesFromString {

	public static void main(String[] args) {

		String str= "java programming language";
		 Set<Character> seen = new HashSet<>();
		 StringBuilder result= new StringBuilder();
		 
		 for(char c : str.toCharArray())
		 {
			 if(seen.add(c))
				 result.append(c);
		 }
		 System.out.println("result: " + result);
	}

}
