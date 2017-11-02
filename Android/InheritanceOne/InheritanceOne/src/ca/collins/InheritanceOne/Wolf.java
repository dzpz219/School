package ca.collins.InheritanceOne;
/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 */

public class Wolf extends Mammal{
	// Not all Mammals have paws so a physical attribute like paw size
	// should go at this level of our object hierarchy.
	private int pawSize; // in cm
	public Wolf(int paw){
		// Invoke the parent constructor, see Mammal.java.
		super();
		setPawSize(paw);
	}
	public int getPawSize() {
		return pawSize;
	}
	public void setPawSize(int pawSize) {
		this.pawSize = pawSize;
	}

}
