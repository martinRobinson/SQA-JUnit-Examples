import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class addressProviderTester {

	// Correct eircodes that map to returned and correct address objects.
	private eircode sampleEircode1 = new eircode("f92 kr61");
	private address sampleAddress1 = new address(sampleEircode1, "The Olde House", "Alclutha Avenue", "Glebe Park",
			"Letterkenny", "Donegal", "Ireland");
	private eircode sampleEircode2 = new eircode("D02 XR20");
	private address sampleAddress2 = new address(sampleEircode2, "Houses of the Oireachtas", "Kildare Street",
			"Dublin 2", "Dublin", "Dublin", "Ireland");

	private addressProvider testProvider;

	@Before
	public void setUp() {
		// Mock an addressProvider object which is not implemented... but which
		// provides a canonical postal address for a given eircode, see
		// unimplemented
		// code.

		testProvider = Mockito.mock(addressProvider.class);

		// Specify what happens when the getAddress method is invoked e.g.
		// the correct address object corresponding to the eircode. We have
		// mocked the behaviour of the addressProvider object.
		when(testProvider.getAddress(sampleEircode1)).thenReturn(sampleAddress1);
		when(testProvider.getAddress(sampleEircode2)).thenReturn(sampleAddress2);
	}

	@Test
	public void testCountryInProvidedAddress() {

		address testAddress = testProvider.getAddress(sampleEircode1);

		// Do the test, hamcrest matching.
		assertThat(testAddress.getCountry(), is(equalTo("Ireland")));
	}

	@Test
	public void testCompleteAddress() {
		address testAddress = testProvider.getAddress(sampleEircode1);

		// Do the test, hamcrest matching.
		assertThat(testAddress, is(equalTo(sampleAddress1)));
	}

	@Test
	public void testCompleteAddress2() {
		address testAddress = testProvider.getAddress(sampleEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingFieldByField(sampleAddress1);
	}

	@Test
	public void testCompleteAddress3() {
		address testAddress = testProvider.getAddress(sampleEircode1);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).isEqualToComparingOnlyGivenFields(sampleAddress1, "country");
	}

	@Test
	public void testCompleteAddress4() {
		address testAddress = testProvider.getAddress(sampleEircode2);

		// Do the test, attribute by attribute using AssertJ matching.
		assertThat(testAddress).hasFieldOrPropertyWithValue("streetName", "Kildare Street");
	}
}
