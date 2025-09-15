package testpackage;

public class GivenNumberisPrimeOrNot {

	public static void main(String[] args) {
		
		//whole number greater than 1 that cannot be exactly divided by any whole number other than itself and 1 (e.g. 2, 3, 5, 7, 11).
		int num=97;
		boolean status= true;
		
		if(num ==0 || num == 1)
		{
			status= false;
		}
		
		if(num == 2)
		{
			status=true;
		}
		
		for(int i=2; i<num; i++)
		{
			if(num % i == 0)
			{
				status=false;
			}
			
		}
		
		if(status == true)
			System.out.println("Given number is prime");
		else
			System.out.println("Given number is not prime");

	}

}
