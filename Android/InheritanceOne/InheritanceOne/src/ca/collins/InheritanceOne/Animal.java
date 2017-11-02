package ca.collins.InheritanceOne;
/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 */

public class Animal {
	// All Animals have an age, regardless of what type of Animal it is.
	private float age; 
	// If an Animal exists then it has position on our grid (imaginary grid in this program).
	// So x and y are a cartesian coordinate system.
	private int x;
	private int y; 
	// Many other physical attributes could be added to this short list.
	// Such as: mass, velocity or height. The point is any attributes or behaviours (methods) which
	// are common to all Animals should go in the Animal class.
	
	// Constructors.
	public Animal(float startingAge){
		// The eagle goes through here...
		setAge(startingAge);
		setX(0);
		setY(0);
	}
	public Animal(){
		// The wolf goes through here...
		setAge(1.0f);
		setX(10);
		setY(10);
	}
	
	// Getters and Setters.
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

}
