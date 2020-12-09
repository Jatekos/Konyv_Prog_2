package coderCrackr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codeCrackr.CodeCracker;

public class TestCodeCracker {

	@Test
	public void coderShlouldGivBackTheInputWhenKeyIsNull() {

		// Given
		CodeCracker codeCracker = new CodeCracker();
		String key = null;
		String message = "alma";
		// When

		String actual = codeCracker.coder(key, message);

		// Then
		assertEquals(message, actual);
	}

	@Test
	public void coderShlouldGivBackTheInpuCodidWhenKeyIsAString() {

		// Given
		CodeCracker codeCracker = new CodeCracker();
		String key = "z";
		String message = "alma";
		String exepted = "zlmz";
		// When

		String actual = codeCracker.coder(key, message);

		// Then
		assertEquals(exepted, actual);
	}

	@Test
	public void testGivenTestCase() {

		// Given
		CodeCracker codeCracker = new CodeCracker();
		String key = "! ) . ( £ * % & > < @ a b c d e f g h i j k l m n o";
		String message = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		String exepted = "! ) . ( £ * % & > < @ a b c d e f g h i j k l m n o";
		// When

		String actual = codeCracker.coder(key, message);

		// Then
		assertEquals(exepted, actual);

	}

	@Test
	public void testDecodeGivenTestCase() {
		
		
		// Given
				CodeCracker codeCracker = new CodeCracker();
				String key = "! ) . ( £ * % & > < @ a b c d e f g h i j k l m n o";
				String message = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
				String  exepted= "! ) . ( £ * % & > < @ a b c d e f g h i j k l m n o";
				
				// When

				String actual = codeCracker.deCoder(key, message);

				// Then
				assertEquals(exepted, actual);

	}

}
