package Amazon.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

    @Test
    public void verifyAmazonSearch() {
        // Step 1: Open Amazon India homepage
        driver.get("https://www.amazon.in/");
        Assert.assertTrue(driver.getTitle().contains("Online Shopping"), "Amazon homepage title mismatch");

        // Step 2: Search for a product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");

        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();

        // Step 3: Wait for search results to load and click first item
        try {
            Thread.sleep(3000); // simple wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstProduct = driver.findElements(By.cssSelector(".s-title-instructions-style .a-size-medium")).get(0);
        String productName = firstProduct.getText();
        firstProduct.click();

        // Step 4: Switch to new tab and verify product title
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        WebElement title = driver.findElement(By.id("productTitle"));
        Assert.assertTrue(title.getText().contains("Laptop"), "Product page doesn't contain correct title");

        System.out.println("✅ Test completed successfully for: " + productName);
    }
}
