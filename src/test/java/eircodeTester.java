import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import org.junit.Test;

public class eircodeTester {
	public eircode validCode = new eircode("F92 KR61");
	
	@Test 
	public void testValidEircode(){
		assertThat(validCode.getEircode() ,is(equalTo("F92KR61")));
	}
	
}
