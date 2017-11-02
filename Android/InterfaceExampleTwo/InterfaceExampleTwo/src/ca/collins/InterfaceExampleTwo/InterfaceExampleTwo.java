package ca.collins.InterfaceExampleTwo;
import java.util.*;
/*
 * Wayne Collins
 * InterfaceExampleTwo
 * Android Application Development, comp10073
 * Mohawk College
 * 
 * http://docs.oracle.com/javase/7/docs/api/
 * 
 * When you are reading the Java API documentation on the web take note in the left
 * navigation pane when you select a package, you get a list of interfaces and a list of 
 * classes belonging to that package. As a programmer you can take advantage of those 
 * interfaces as this example tries to show.
 * 
 */

public class InterfaceExampleTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> dataStructure = new ArrayList<Integer>();
		dataStructure.add(5);
		dataStructure.add(10);
		dataStructure.add(15);
		dataStructure.add(20);
		
		// initial size is 3, increment is 2 
		Vector<Integer> v = new Vector<Integer>(3, 2); 
		//System.out.println("Initial size: " + v.size()); 
		//System.out.println("Initial capacity: " + v.capacity()); 
		v.addElement(new Integer(1)); 
		v.addElement(new Integer(2)); 
		v.addElement(new Integer(3)); 
		v.addElement(new Integer(4));
		//System.out.println("Later size: " + v.size()); 
		//System.out.println("Later capacity: " + v.capacity());
		
		System.out.printf("Sum from ArrayList is %d\n", findSum(dataStructure));
		System.out.printf("Sum from Vector is %d\n", findSum(v));

	}
	/*
	 * Because both ArrayList and Vector are implementing the List interface I can write one method that
	 * expects to receive a List and pass in either data structure.
	 */
	private static Integer findSum(List<Integer> data){
		Integer sum = new Integer(0);
		for(Integer x: data){
			sum += x;
		}
		return sum;
	}

}
