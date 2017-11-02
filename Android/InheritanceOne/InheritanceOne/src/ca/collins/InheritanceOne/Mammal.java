package ca.collins.InheritanceOne;
/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 */

public class Mammal extends Animal{
	
	// Constructor.
	public Mammal(){
		
		// Invoke the parent constructor to get the age and initial coordinates set.
		// See Animal.java.
		super();
	}
	
	// An action (behaviour) unique to Mammals goes in a method in this class.
	public void drinkMilk(){
		System.out.println("Drinking milk.");
	}

}
