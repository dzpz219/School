package ca.collins.InheritanceOne;
/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 */

public class Bird extends Animal{
	// Feathers are a trait unique to birds, not all Animals have feathers.
	private String featherColour; 
	public Bird(String feathers, float age){
		// Send the age back to the parent constructor found in Animal.java
		super(age);
		setFeatherColour(feathers);
	}
	public String getFeatherColour() {
		return featherColour;
	}
	public void setFeatherColour(String featherColour) {
		this.featherColour = featherColour;
	}

}
