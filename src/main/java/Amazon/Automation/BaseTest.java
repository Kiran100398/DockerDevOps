package Amazon.Automation;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;





/**
 * Hello world!
 */
public class BaseTest {
	 protected WebDriver driver;

	    @Parameters("browser")
	    @BeforeMethod
	    public void setUp(String browser) throws Exception {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        if (browser.equalsIgnoreCase("chrome")) {
	            capabilities.setBrowserName("chrome");
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            capabilities.setBrowserName("firefox");
	        } else if (browser.equalsIgnoreCase("edge")) {
	            capabilities.setBrowserName("MicrosoftEdge");
	        }

	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
    }

