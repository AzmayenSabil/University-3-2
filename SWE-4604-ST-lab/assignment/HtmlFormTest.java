
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlFormTest {

    @Test
    public void testHtmlForm() {
        
        System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver_win32");

        
        WebDriver driver = new ChromeDriver();

       
        driver.get("https://testpages.herokuapp.com");

        
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");

        
        driver.findElement(By.id("submitBtn")).click();

        String outputText = driver.findElement(By.id("outputText")).getText();
        String expectedOutput = "Hello, John Doe!";
        assert outputText.equals(expectedOutput) : "Output mismatch";

        // Close the WebDriver
        driver.quit();
    }
}
