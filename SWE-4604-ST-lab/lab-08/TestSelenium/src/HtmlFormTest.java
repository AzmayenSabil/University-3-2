import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlFormTest {

    @Test
    public void testHtmlForm() {

        System.setProperty("webdriver.chromedriver.driver", "/Users/azmayensabil/Documents/GitHub/University-3-2/SWE-4604-ST-lab/lab-08/chromedriver_mac_arm64/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        driver.findElement(By.id("firstName")).sendKeys("Azmayen");
        driver.findElement(By.id("lastName")).sendKeys("Sabil");

        driver.findElement(By.id("submitBtn")).click();

        String outputText = driver.findElement(By.id("outputText")).getText();
        String expectedOutput = "Hello, Azmayen Sabil!";

        assert outputText.equals(expectedOutput) : "Output mismatch";

        // Close the WebDriver
        driver.quit();
    }
}