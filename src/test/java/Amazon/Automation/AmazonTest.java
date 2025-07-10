package Amazon.Automation;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AmazonTest extends BaseTest {

	@Test
    public void verifyAmazonHomePage() {
        driver.get("https://www.amazon.in/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
    }
}
