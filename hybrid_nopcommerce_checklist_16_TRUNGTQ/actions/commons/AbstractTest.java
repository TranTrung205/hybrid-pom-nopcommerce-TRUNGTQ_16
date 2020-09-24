
package commons;

import java.util.Random;

public class AbstractTest {
	protected int randomNumber () {
		Random randomNumber = new Random();
		return randomNumber.nextInt(99999999);
	}
}