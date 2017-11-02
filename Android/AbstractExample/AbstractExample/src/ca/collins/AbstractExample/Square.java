package ca.collins.AbstractExample;
/*
 * Wayne Collins, May 2012
 * Android Application Development
 * Mohawk College
 */

public class Square extends Polygon{
	
	public Square(int ... coords){
		super(coords);
	}
	
	// Must implement the findArea method because it is abstract in the superclass.
	public double findArea(){
		// Just have to find the length of one side of the square.
		double sideLength = Math.pow( Math.pow(getCoord(2)-getCoord(0), 2) +
				Math.pow(getCoord(3)-getCoord(1), 2), 0.5);
		
		return sideLength * sideLength;
	}

}
