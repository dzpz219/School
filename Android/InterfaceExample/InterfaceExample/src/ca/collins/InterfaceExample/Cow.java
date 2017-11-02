package ca.collins.InterfaceExample;

public interface Cow {

    // Declare instance methods. They are public and abstract by default, you don't have to type that.
	// Instance variables are static final by default.

    /**
     * Name of the breed
     *
     * @return Short string describing the breed.
     */
    String breedName();

    /**
     * percentage butterfat of the milk
     *
     * @return percentage
     */
    double butterfat();

    /**
     * Typical milk production of this breed.
     *
     * @return daily milk production in litres
     */
    double milkProduction();
    // above three methods are implicitly public and abstract because they are defined in an interface.
    

}

/*
 * [Cow.java]
 *
 * Summary: Demonstrate a simple Interface.
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
 * Demonstrate a simple Interface.
 *
 * @author Roedy Green, Canadian Mind Products
 * @version 1.0 2009-04-11 initial version
 * @since 2009-04-11
 */
