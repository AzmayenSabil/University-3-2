import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlTableTest {

    @Test
    public void testHtmlTable() {

        System.setProperty("webdriver.chromedriver.driver", "/Users/azmayensabil/Documents/GitHub/University-3-2/SWE-4604-ST-lab/lab-08/chromedriver_mac_arm64/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);

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
