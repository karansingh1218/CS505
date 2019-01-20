//**********************************************************************
//	Rational.java		
// 	Name: Karan Singh		Student ID: ks572
// 	Student Section : CS 505-852
//	PROJECT 2: Rational Class
//**********************************************************************

import java.util.Scanner;

public class Rational 
{
	
	private double numerator;
	private double denominator;
	private Scanner input;
	/*
	 * Constructor:
	 * Parameter added to insure the denominator is non-zero, because it will be undefined otherwise.
	 * Parameter added for negative values 
	*/
	public Rational(double numerator, double denominator)  //Setter
	{
		this.numerator = numerator;			
		this.denominator = denominator;
		
		// Ensuring a non-zero denominator
		if (denominator == 0) 
		{
			denominator = 1;
		}
		// If the denominator value if less than zero, it will be multiplied by -1 to make it positive
		// and the numerator will turn to negative, 
		// if two negative values are chosen, you can get a positive answer. 
		if (denominator < 0) 
		{
			numerator = -numerator;
			denominator = -denominator;	
		}
		
	}	
		
	public Rational userInput() //Setter
	{
		input = new Scanner(System.in);
		System.out.println("Enter The Desired Numerator Value");
		numerator = input.nextDouble();
		System.out.println("Enter the Desired Denominator Value");
		denominator = input.nextDouble();
		System.out.println("The Input Rational Number is " + numerator + "/" + denominator);
		return new Rational(numerator, denominator);
	}
		
	
	private double getNum () //GETTER - following convention
	{
		return numerator;	
	}
	
	
	private double getDenom () //GETTTER - following convention
	{
		return denominator;
	}
	// Addition:
	// A common denominator will need to achieved to add the two rational numbers.
	public Rational add ( Rational n1 ) //SETTER
	{
		double num_value_1 = numerator * n1.getDenom();
		double num_value_2 = n1.getNum() * denominator;
		
		double comDenom = denominator * n1.getDenom();
		
		double total = num_value_1 + num_value_2; //add both numerators and get a total
		
		return new Rational (total, comDenom);
	}
	//subtraction:
	public Rational sub (Rational n1) //SETTER
	{
		double num_value_1 = numerator * n1.getDenom( );	// Takes numerator value from "a" and multplies to Denominator value from "b"
		double num_value_2 = n1.getNum() * denominator; 	// Takes numerator value from "b" and multiples to Denominator value from "a"
		
		double comDenom = denominator * n1.getDenom(); // Finds the Common Denominator by multiplying denominators from "a" and "b"
		
		double diff = num_value_1 - num_value_2; 		// Takes the difference of the two numerators
		
		return new Rational (diff, comDenom);
		
	}
	// Multiplication
	public Rational mul ( Rational n1 ) //SETTER
	{
		double mult_numerator = numerator * n1.getNum();
		double mult_denominator = denominator * n1.getDenom();
		
		return new Rational (mult_numerator, mult_denominator);
		
	}
	
	// Retrieves the reciprocal of the rational number.
	// It is going to be used when we divide. 
	private Rational recip () //GETTER
	{
		return new Rational (denominator, numerator);
		
	}
	
	//division
	public Rational div (Rational n1) //GETTER
	{
		return mul (n1.recip()); // By simply rotating the fraction (Reciprocal), you can simply multiply it.
		
	}
	
	public String toString () 
	{
		String show_value;
		
		if (denominator == 1)
			show_value = numerator +  " ";
		else
			if (numerator == 0)
				show_value = " 0 ";
			else
				show_value = numerator + " / " + denominator;
		
		return show_value;
		
	}
	
}
