package ca.collins.InheritanceOne;


/* http://www.vogella.com/articles/JUnit/article.html
 * http://www.mkyong.com/tutorials/junit-tutorials/
 * http://www.junit.org/
  
    MyClassTest can be run as a JUnit test which sends results to a JUnit tab
	beside the Package Explorer tab.
	
	MyTestRunner can be run as a Java Application which sends results to the console.
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTest {

	@Test
	public void testMultiply() {	
		MyClass tester = new MyClass();
		assertEquals("Result", 50, tester.multiply(10, 5));
	}

}
