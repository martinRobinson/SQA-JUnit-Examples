import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class addressProviderTester {

	private eircode testEircode = new eircode("f92 kr61");
	private address testAddress = new address(testEircode, "The Olde House", "Alclutha Avenue", "Glebe Park",
			"Letterkenny", "Donegal", "Ireland");
	private eircode dailEircode = new eircode("D02 XR20");
	private address dailAddress = new address(dailEircode, "Houses of the Oireachtas", "Kildare Street", "Dublin 2",
			"Dublin", "Dublin", "Ireland");

	
	@Test
	public void testMockedAddressProvider() {
		// Mock an addressProvider object which is not implemented... but which
		// provides a canonical postal address for a given eircode, see
		// unimplemented
		// code.
		addressProvider test = Mockito.mock(addressProvider.class);

		// Specify what happens when the getAddress method is invoked e.g.
		// the correct address object corresponding to the eircode. We have
		// mocked the behaviour of the addressProvider object.
		when(test.getAddress()).thenReturn(testAddress);

		// Do the test.
		assertEquals(test.getAddress().getCountry(), "Ireland");
	}
}
