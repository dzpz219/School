package ca.collins.InheritanceOne;

/*
 * Wayne Collins
 * Android Application Development, comp10073
 * Mohawk College
 * 
 * from docs.oracle.com....
 * 
 * A class that is derived from another class is called a subclass (also a derived class, 
 * extended class, or child class). The class from which the subclass is derived is called 
 * a superclass (also a base class or a parent class).
 * 
 * When you want to create a new class and there is already a class that includes some of 
 * the code that you want, you can derive your new class from the existing class. In doing 
 * this, you can reuse the fields and methods of the existing class without having to write
 *  (and debug!) them yourself.

 * A subclass inherits all the members (fields, methods, and nested classes) from its superclass. 
 * Constructors are not members, so they are not inherited by subclasses, but the constructor of
 * the superclass can be invoked from the subclass.
 */

public class InheritanceOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Wolf oneAnimal = new Wolf(20);
		Eagle anotherAnimal  = new Eagle("black", 2.5f);
		/*
		 * Object oneAnimal has all attributes and behaviours defined by its parent,
		 * grandparent and great grandparent. Wolf -> Mammal -> Animal -> Object
		 * 
		 * Same can be said for the object anotherAnimal.
		 * Eagle -> Bird -> Animal -> Object
		 */
		System.out.printf("Wolf age: %.1f years, x: %d, y: %d, paw size (cm): %d\n",
				oneAnimal.getAge(), oneAnimal.getX(), oneAnimal.getY(), oneAnimal.getPawSize());
		
		oneAnimal.drinkMilk();
		
		System.out.printf("Eagle age: %.1f years, x: %d, y: %d, feather colour: %s\n",
				anotherAnimal.getAge(), anotherAnimal.getX(), 
				anotherAnimal.getY(), anotherAnimal.getFeatherColour());
		anotherAnimal.huntHuntKillKill();
		
		System.out.println("--------------------------");
		inspect(oneAnimal);
		inspect(anotherAnimal);

	}
	
	/*
	 * You can pass an Eagle object or a Wolf object into this method
	 * because they are both derived from the class Animal.
	 */
	public static void inspect(Animal beast){
		System.out.printf("%s is %.1f years old\n", 
				beast.getClass().getSimpleName(), beast.getAge());
	}

}
