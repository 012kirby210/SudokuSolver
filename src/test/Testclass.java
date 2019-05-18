package test;

import org.junit.Test;
import org.junit.Assert;

public class Testclass {

	String message = "Hello world";
	String another_message = "Hello world";
	
	@Test
	public void testPrintMessage() {
		Assert.assertEquals(message,another_message);
	}
}
