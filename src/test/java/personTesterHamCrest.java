import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class personTesterHamCrest {

	private person testDummy = new person("John", "Doe", 45);

	@Test
	public void testGetAgeTypical() {
		assertThat(testDummy.getAgeInYears(), is(equalTo(45)));
	}
}