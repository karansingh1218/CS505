//**********************************************************************
//	Main.java		
// 	Name: Karan Singh		Student ID: ks572
// 	Student Section : CS 505-852
//	PROJECT 2: Rational Class
//**********************************************************************

public class Main {
	
	public static void main (String[] args) 
	{
		//Input Rational Numbers
		
		Rational a = new Rational(0, 0);		
		Rational b = new Rational(0, 0);
		
		//Enter Numerator and Denominator
		a.userInput();
		b.userInput();
		
		System.out.println(" ");
		System.out.println("The Rational numbers below are modified by Addition, Subtraction, Multiplication, and Division");
		System.out.println(" ");
		System.out.println("("+ a + ")" + " + " + "(" + b + ")" + " = " + a.add(b)); //Addition
		System.out.println("("+ a + ")" + " - " + "(" + b + ")" +" = " + a.sub(b)); //Subtraction
		System.out.println("("+ a + ")" + " * " + "(" + b + ")" + " = " + a.mul(b)); //Multiplication
		System.out.println("("+ a + ")" + " / " + "(" + b + ")" + " = " + a.div(b)); //Division		
	}

}
