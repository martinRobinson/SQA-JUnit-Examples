import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

// All of the test methods in this class have been rewritten from the
// plain vanilla JUnit tests present in personTester.java

public class personTesterHamCrest {

	private person testDummy = new person("John", "Doe", 45);

	@Test
	public void testGetAgeTypical() {
		assertThat(testDummy.getAgeInYears(), is(equalTo(45)));
	}

	@Test
	public void testGetAgeTypical2() {
		testDummy.setAgeInYears(100);
		assertThat(testDummy.getAgeInYears(), is(equalTo(100)));
	}

	@Test
	public void testGetAgeVeryOld() {
		testDummy.setAgeInYears(129);
		assertThat(testDummy.getAgeInYears(), is(equalTo(129)));
	}

	@Test
	public void testGetAgeTypicalJustBorn() {
		testDummy.setAgeInYears(0);
		assertThat(testDummy.getAgeInYears(), is(equalTo(0)));
	}

	// Various tests implemented using the Hamcrest approach to catching
	// exceptions.

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSetAgeInYearsTooSmallByThrownException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("Age must be reasonable"));
		testDummy.setAgeInYears(-1);
	}

	@Test
	public void testSetAgeInYearsTooBigByThrownException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("Age must be reasonable"));
		testDummy.setAgeInYears(131);
	}

	@Test
	public void testCorrectFirstName() {
		testDummy.setFirstName("Joseph");
		assertThat(testDummy.getFirstName(), is(equalTo("Joseph")));
	}

	@Test
	public void testFirstNameWithNumber() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("First name can only be alphabetic"));
		testDummy.setFirstName("Jose4ph");
	}

	@Test
	public void testHypenatedFirstName() {
		testDummy.setFirstName("Michel-Paul");
		assertThat(testDummy.getFirstName(), is(equalTo("Michel-Paul")));
	}

	@Test
	public void testCorrectLastName() {
		testDummy.setLastName("Bloggs");
		assertThat(testDummy.getLastName(), is(equalTo("Bloggs")));
	}

	@Test
	public void testCorrectHyphenatedLastName() {
		testDummy.setLastName("Von-Trapp");
		assertThat(testDummy.getLastName(), is(equalTo("Von-Trapp")));
	}

	@Test
	public void testDoubleHyphenatedLastName() {
		testDummy.setLastName("Sax-Coburg-Windsor");
		assertThat(testDummy.getLastName(), is(equalTo("Sax-Coburg-Windsor")));
	}

	@Test
	public void testLastNameWithNumberVersion2() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("Last name can only be alphabetic with a hyphen"));
		testDummy.setLastName("Bl0ggs");
	}

	@Test
	public void testLastNameWithPunctuation() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("Last name can only be alphabetic with a hyphen"));
		testDummy.setLastName("Sax-Coburg_Windsor");
	}

}