import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class personTesterAssertJ {
	private person testDummy = new person("Joe", "Bloggs", 21);

	@Test
	public void testGetAgeTypical() {
		assertThat(testDummy.getAgeInYears()).isEqualTo(21);
	}

	@Test
	public void testCorrectFirstName() {
		assertThat(testDummy.getFirstName()).isEqualTo("Joe");
	}

	@Test
	public void testCorrectLastName() {
		assertThat(testDummy.getLastName()).isEqualTo("Bloggs");
	}

	@Test
	public void testAggregatePropertiesPerson() {
		assertThat(testDummy.getAgeInYears()).as("Check %s's age ", testDummy.getFirstName()).isEqualTo(21);
	}
}
