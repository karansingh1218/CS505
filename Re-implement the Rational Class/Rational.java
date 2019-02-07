//**********************************************************************
//	Rational.java		
// 	Name: Karan Singh		Student ID: ks572
// 	Student Section : CS 505-852
//	PROJECT 4: Re-implement Rational Class
//**********************************************************************


public class Rational extends Number implements Comparable<Rational>
{
	private static final long serialVersionUID = 1L;
	private double numerator;
	private double denominator;
	int Rational;
	
	public int compareTo (Rational n1 ) 
	{
		if(Rational > n1.Rational) 
		{
			return 1;
		}
		else if (Rational < n1.Rational)
		{
			return -1;
		}
		if (Rational == n1.Rational) 
		{
			return 0;
		}
		return Rational;
	}
	
	// Constructor
	public Rational(double numerator, double denominator) 
	{
		this.numerator = numerator;			
		this.denominator = denominator;
		
		if (denominator == 0) 
		{
			denominator = 1;
		}
		 
		if (denominator < 0) 
		{
			numerator = -numerator;
			denominator = -denominator;	
		}
		
	}	
	
	// Getter
	private double getNum () 
	{
		return numerator;	
	}
	
	// Getter
	private double getDenom ()
	{
		return denominator;
	}

	// Mutator
	public Rational add ( Rational n1 ) 
	{
		double num_value_1 = numerator * n1.getDenom();
		double num_value_2 = n1.getNum() * denominator;
		
		double comDenom = denominator * n1.getDenom();
		
		double total = num_value_1 + num_value_2; 
		
		return gcd (new Rational (total, comDenom));
	}
	//mutator
	public Rational sub (Rational n1)
	{
		double num_value_1 = numerator * n1.getDenom( );	
		double num_value_2 = n1.getNum() * denominator; 	
		
		double comDenom = denominator * n1.getDenom(); 
		
		double diff = num_value_1 - num_value_2;
		
		return gcd ( new Rational (diff, comDenom));
	}
	//mutator
	public Rational mul ( Rational n1 ) 
	{
		double mult_numerator = numerator * n1.getNum();
		double mult_denominator = denominator * n1.getDenom();
		
		return gcd ( new Rational (mult_numerator, mult_denominator));
	}
	// Getter
	private Rational recip () 
	{
		return new Rational (denominator, numerator);
	}
	//Getter
	public Rational div (Rational n1) 
	{
		return gcd ( mul (n1.recip())); 
	}
	
	private Rational gcd (Rational n1)
	{
		int gcd = 0;
		double numerator = Math.abs(n1.numerator);
		double denominator = Math.abs(n1.denominator);
		
		for (int k = 1; k <= denominator && k <= denominator; k = k + 1)
		{
			if (numerator % k == 0 && denominator % k == 0)
			{
				gcd = k;
			}
			
		}
		return new Rational(numerator/gcd, denominator/gcd);
	}
	
	public String toString () 
	{
		String show_value;

	    show_value = "(" + numerator + ")" + " / " + "(" + denominator + ")";
		
		return show_value;
		
	}
	
	@Override
	public double doubleValue() 
	{	
		return numerator  / denominator;
	}
	@Override
	public float floatValue() {
		return (float)doubleValue();

	}
	@Override
	public int intValue() {
		return (int)doubleValue();

	}
	@Override
	public long longValue() {
		return (long)doubleValue();

	}
	
}
