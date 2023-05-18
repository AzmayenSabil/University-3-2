import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlTableTest {

    @Test
    public void testHtmlTable() {
        
        System.setProperty("webdriver.chrome.driver", "C:\Users\user\Downloads\chromedriver_win32");

        
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://testpages.herokuapp.com");

        
        driver.findElement(By.id("inputField")).sendKeys("Test Data");

        
        driver.findElement(By.id("refreshButton")).click();

        
        String outputText = driver.findElement(By.id("tableData")).getText();
        String expectedOutput = "Test Data";
        assert outputText.contains(expectedOutput) : "Output mismatch";

        // Close the WebDriver
        driver.quit();
    }
}
