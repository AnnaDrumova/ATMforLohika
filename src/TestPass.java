import static org.junit.Assert.*;

import org.junit.Test;


public class TestPass {

	@Test
	public void testPass() {
		
		int pass = 1111;
		int passAd = 1111;
		
		assertTrue(pass == passAd);
		assertFalse(pass != passAd);
		assertNotNull(passAd);
		
	}

}
