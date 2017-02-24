import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class personTester {
    private person testDummy = new person("Joe", "Bloggs", 21);
    
    @Test
    public void testGetAge(){
        assertEquals(21, testDummy.getAgeInYears());
    }
}
