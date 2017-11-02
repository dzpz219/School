package ca.collins.AbstractExample;
/*
 * Wayne Collins, May 2012
 * Android Application Development
 * Mohawk College
 */

import java.util.Arrays;

public abstract class Polygon {
	private int[] vertices;
	
	// Constructor must receive x1,y1 followed by x2,y2 ... as a list of ints
	public Polygon(int ... points){

		// We will use a maximum of 9 vertices for our polygon which means we need room to store
		// 20 integers. Copy the starting point over to the end of the array as well so we can
		// find the perimeter. Fill it up with the value -1 so we know where our polygon stops.

		vertices = new int[20];
		Arrays.fill(vertices, -1);
		for(int i= 0; i < points.length; i++){
			vertices[i] = points[i];
		}
		vertices[points.length] = points[0]; 
		vertices[points.length + 1] = points[1];
	}
	
	public double findPerimeter(){
		double perimeter = 0;
		for(int i = 0; i < vertices.length; i+=2){
			if(vertices[i] == -1 || vertices[i+2] == -1){
				break;
			}
			perimeter += Math.pow( Math.pow(getCoord(i+2)-getCoord(i+0), 2) +
					Math.pow(getCoord(i+3)-getCoord(i+1), 2), 0.5);
		}
		
		return perimeter;
	}
	
	public int getCoord(int index){
		return vertices[index];
	}
	
	// --- Declare abstract methods to be implemented by subclass.
	
	public abstract double findArea();
	

}
