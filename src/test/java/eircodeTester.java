import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringStartsWith.startsWith;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class eircodeTester {
	private eircode validCode = new eircode("F92 KR61");

	// Very simple and standard JUnit 4 test.
	@Test
	public void testValidEircode() {
		assertThat(validCode.getEircode(), is(equalTo("F92KR61")));
	}

	// @Test annotation using expected element. Very straightforward but no
	// obvious way to verify causes.
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidEircodeTooLong() {
		final eircode invalidCodeTooLong = new eircode("F92 KR611");
	}

	// Using Junit rules wherein a rule is declared that an expected
	// exception will be of a specific type which can then be processed.
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInvalidEircodeTooLongVersion2() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input eircode too long: 8");
		final eircode invalidCodeTooLong = new eircode("F92 KR611");
	}

	@Test
	public void testInvalidEircodeTooShort() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input eircode too short: 6");
		final eircode invalidCodeTooLong = new eircode("F92 KR6");
	}

	// Same thing as above but this time with a Hamcrest matcher matching
	// the start of the expected message when the exception is thown e.g.
	// ignoring how many character short it actually is.

	@Test
	public void testInvalidEircodeTooShortHamcrestVersion() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(startsWith("Input eircode too short:"));
		final eircode invalidCodeTooLong = new eircode("F92 KR6");
	}

}
