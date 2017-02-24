import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class personTester {
	private person testDummy = new person("Joe", "Bloggs", 21);

	@Test
	public void testGetAge() {
		assertEquals(21, testDummy.getAgeInYears());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeInYearsTooSmallByThrownException() {
		testDummy.setAgeInYears(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAgeInYearsTooBigByThrownException() {
		testDummy.setAgeInYears(131);
	}
}
