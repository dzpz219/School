package ca.collins.InterfaceExample;
/*
 * Wayne Collins
 * InterfaceExample
 * Android Application Development, comp10073
 * Mohawk College.
 * 
 * Using an interface in a small java program does not make sense. The value of the interface
 * becomes apparent in larger applications.
 * 
 * In Java a class can implement multiple interfaces (it can only inherit from one superclass).
 * 
 * Here is a good description of interfaces:
 * http://mindprod.com/jgloss/interface.html
 * 
 */

public class InterfaceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jersey farmAnimal = new Jersey();
		System.out.printf("breed %s, butterfat %.2f %%, milk production %.2f L\n", 
				farmAnimal.breedName(), farmAnimal.butterfat(), farmAnimal.milkProduction());

	}

}
