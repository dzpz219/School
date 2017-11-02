package ca.collins.InterfaceExample;

public class Jersey implements Cow {
	// ------------------------------ CONSTANTS ------------------------------

	/**
	 * breed of cow this class handles.
	 */
	private static final String BREED = "Jersey";

	// -------------------------- PUBLIC INSTANCE  METHODS --------------------------

	/**
	 * Name of the breed
	 *
	 * @return Short string describing the breed.
	 */
	public String breedName(){
		return BREED;
	}

	/**
	 * percentage butterfat of the milk
	 * 
	 * Try commenting out this method and see what error you get.
	 * The implementation of this method is up to the programmer of this application.
	 * The interface may be used by many applications with different implementations.
	 *
	 * @return percentage
	 */
	public double butterfat(){
		return 6.0;
	}

	/**
	 * Typical milk production of this breed.
	 *
	 * @return daily milk production in litres
	 */
	public double milkProduction(){
		return 23.5;
	}

	// even though the methods implement an implicitly public method in the interface, 
	// you need the public keyword


}

/*
 * [Jersey.java]
 *
 * Summary: Demonstrate implementing a simple Interface.
 *
 * Copyright: (c) 2009-2012 Roedy Green, Canadian Mind Products, http://mindprod.com
 *
 * Licence: This software may be copied and used freely for any purpose but military.
 *          http://mindprod.com/contact/nonmil.html
 *
 * Requires: JDK 1.7+
 *
 * Created with: JetBrains IntelliJ IDEA IDE http://www.jetbrains.com/idea/
 *
 * Version History:
 *  1.0 2009-04-11 initial version
 */

/**
 * Demonstrate implementing a simple Interface.
 *
 * @author Roedy Green, Canadian Mind Products
 * @version 1.0 2009-04-11 initial version
 * @since 2009-04-11
 */
