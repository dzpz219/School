package ca.collins.InheritanceOne;
/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 */

public class Eagle extends Bird{
	// I couldn't think of an attribute that was unique to eagles so there are
	// no private variables in this class.
	
	// Constructor.
	public Eagle(String feathers, float howOld){
		// Send these two characteristics of the Eagle back to the 
		// parent constructor found in Bird.java
		super(feathers, howOld);
	}
	
	// Hunting and killing is a behaviour of eagles. We can't move this behaviour
	// (method) back to Bird.java because not all birds are predators.
	public void huntHuntKillKill(){
		System.out.println("Something always dies when the eagle feeds.");
	}

}
