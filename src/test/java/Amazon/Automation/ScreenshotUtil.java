package Amazon.Automation;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String methodName, String status) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File("screenshots/" + status + "/" + methodName + "_" + timestamp + ".png");

            dest.getParentFile().mkdirs(); // Create dirs if they don't exist
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
    }
}
