//**********************************************************************
//	DeterminingPi.java		
// 	Name: Karan Singh		
// 	Student ID: ks572
// 	Student Section : CS 505-852
//	PROJECT 1: Determining Pi
//**********************************************************************

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class DeterminingPi 
{
	private static Scanner scan;

	public static void main (String[] args) 
	{
		
		final int AREA_SQUARE = 1; // Determined by multiplying length by length of one
		final double AREA_CIRCLE = 0.785; // Area of circle is PI*(R(^2)) and R = 0.5
		final double Ratio = AREA_CIRCLE/AREA_SQUARE; // The ratio of circle to square
		
		DecimalFormat df = new DecimalFormat("#%"); 
		
		System.out.println("The ratio of the areas of the inscribed circle to that of the unit square is: " + Ratio);
		System.out.println("\nThe probability is " + df.format(Ratio)); // Percent probability of being within circle relative to square
		
		Random gen = new Random(); // generates random numbers
		scan = new Scanner (System.in);
		
		System.out.println("\nEnter the number of iteration you would like to be performed: ");
		
		int attempts = 0;
		attempts = scan.nextInt();
		
		int In_Circle = 0;
			
		for (int k = 1; k <= attempts; k = k + 1) 
		{
			// Generates two random numbers between -1 and 1. This is completed by multiplying by it by "2" and
			// then shifting back the access by "1", by subtracting it
			double x = gen.nextDouble()*2 - 1; 
			
			double y = gen.nextDouble()*2 - 1;
		
			if (x*x + y*y <= 1) 					// The equation of a circle			
				
				In_Circle = In_Circle + 1;		// If the values are less than or equal to one, we can make a conjecture
												// that the random point is within the unit circle
		}
		// The Ratio of accepted values within the circle divided by the attempts that exceeded the unitary value and multiplied by "4", will
		// give us the experimentally calculated value of PI. Solving PI non-numerically is determined by 4*(Ratio). 
		System.out.println ("\nThe experimental value of PI is: " + 4*((double)In_Circle/attempts) ); 
	
	}
}
