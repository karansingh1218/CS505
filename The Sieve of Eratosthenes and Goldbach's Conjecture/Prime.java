
public class Prime 
{
	public static void main (String[] args) 
	{
		// Command Line argruments
		int n;
		n = Integer.parseInt(args[0]);
		System.out.println("Please Enter the desired array value" + args[0]);
		
		// Intialize the array values.
		int[] array = new int [n];
		
		for (int i = 0; i < array.length; i = i +1 ) 
		{
			array [i] = i;
		}
		sieve(array);
		goldbach(array);
	}
	
	public static void sieve (int[] array) 
	{
		for (int i = 2; i < array.length; i = i + 1) {
			if ( array [i] != 0) 
			{
				for (int k = 2 * i; k < array.length; k = k + i ) 
				{
					array[k] = 0 ;
				}
			}
		}
		
		System.out.println("The prime numbers are listed below:");

		for (int i = 0; i < array.length; i = i + 1) 
		{
			if (array[i] != 0)
			{
				System.out.println(i);
			}
		}
	}
	
	public static void goldbach (int[] array) 
	{
		}
				
			}

	

	


		
		
		
		
		


