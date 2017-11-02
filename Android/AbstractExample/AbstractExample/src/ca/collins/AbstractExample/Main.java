package ca.collins.AbstractExample;
/*
 * Wayne Collins, May 2012
 * Android Application Development
 * Mohawk College
 * 
 * To use make use of an abstract class, you must define a non-abstract class that extends the 
 * abstract one. It can use any of the inherited non-abstract methods. 
 * It must implement all of the abstract methods.
 * 
 * Interfaces and all their methods are implicitly abstract.
 */

public class Main {

	public static void main(String[] args) {
		// Constructor takes a maximum of 9 x,y pairs in the top right quadrant (all positive).
		// Square fourSided = new Square(0,0,5,0,5,5,0,5);
		// Square fourSided = new Square(1,1,5,1,5,5,1,5);
		Square fourSided = new Square(4,0,8,4,4,8,0,4);
		System.out.printf("Area of square is %.2f\n", fourSided.findArea());
		System.out.printf("Perimeter of square is %.2f\n", fourSided.findPerimeter());

	}

}
