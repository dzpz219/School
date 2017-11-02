package ca.collins.InheritanceOne;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {
	public static void main(String[] args) {
		int counter = 0;
		Result result = JUnitCore.runClasses(MyClassTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			counter++;
		}
		String message = counter == 1 ? "error" : "errors";
		System.out.printf("%d %s\n", counter, message);
	}

}
