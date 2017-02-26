import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class personTester {
	private person testDummy = new person("Joe", "Bloggs", 21);

	@Test
	public void testGetAgeTypical() {
		assertEquals(21, testDummy.getAgeInYears());
	}

	@Test
	public void testGetAgeVeryOld() {
		testDummy.setAgeInYears(129);
		assertEquals(129, testDummy.getAgeInYears());
	}

	@Test
	public void testGetAgeTypicalJustBorn() {
		testDummy.setAgeInYears(0);
		assertEquals(0, testDummy.getAgeInYears());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeInYearsTooSmallByThrownException() {
		testDummy.setAgeInYears(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeInYearsTooBigByThrownException() {
		testDummy.setAgeInYears(131);
	}

	@Test
	public void testCorrectFirstName() {
		testDummy.setFirstName("Joe");
		assertEquals("Joe", testDummy.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFirstNameWithNumber() {
		testDummy.setFirstName("Jose4ph");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFirstNameWithPunctuation() {
		testDummy.setFirstName("Jose-ph");
	}

	@Test
	public void testCorrectLastName() {
		testDummy.setLastName("Bloggs");
		assertEquals("Bloggs", testDummy.getLastName());
	}

	@Test
	public void testCorrectHyphenatedLastName() {
		testDummy.setLastName("Von-Trapp");
		assertEquals("Von-Trapp", testDummy.getLastName());
	}

	@Test
	public void testDoubleHyphenatedLastName() {
		testDummy.setLastName("Sax-Coburg-Windsor");
		assertEquals("Sax-Coburg-Windsor", testDummy.getLastName());
	}

	@Test
	public void testTripleHyphenatedLastName() {
		testDummy.setLastName("Sax-Coburg-Windsor-Gothburg");
		assertEquals("Sax-Coburg-Windsor-Gothburg", testDummy.getLastName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastNameWithNumber() {
		testDummy.setLastName("Bl0ggs");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLastNameWithPunctuation() {
		testDummy.setLastName("Sax-Coburg_Windsor");
	}
}
