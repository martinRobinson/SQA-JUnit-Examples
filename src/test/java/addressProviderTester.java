import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class addressProviderTester {

	// Correct eircodes that map to returned and correct address objects.
	private eircode sampleEircode1 = new eircode("f92 kr61");
	private address sampleAddress1 = new address(sampleEircode1, "The Olde House", "Alclutha Avenue", "Glebe Park",
			"Letterkenny", "Donegal", "Ireland");
	private eircode sampleEircode2 = new eircode("D02 XR20");
	private address sampleAddress2 = new address(sampleEircode2, "Houses of the Oireachtas", "Kildare Street", "Dublin 2",
			"Dublin", "Dublin", "Ireland");

	
	@Test
	public void testMockedValidAddressProvider() {
		// Mock an addressProvider object which is not implemented... but which
		// provides a canonical postal address for a given eircode, see
		// unimplemented
		// code.
		addressProvider testProvider = Mockito.mock(addressProvider.class);

		// Specify what happens when the getAddress method is invoked e.g.
		// the correct address object corresponding to the eircode. We have
		// mocked the behaviour of the addressProvider object.
		when(testProvider.getAddress()).thenReturn(sampleAddress1);
		
		address testAddress = testProvider.getAddress();

		// Do the test, hamcrest matching.
		assertThat(testAddress.getCountry(),is(equalTo("Ireland")));
	}
}
