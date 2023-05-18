import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        //--This was my selenium template --//
//        System.out.println("Hello world!");
//        System.setProperty("webdriver.chromedriver.driver", "/Users/azmayensabil/Documents/GitHub/University-3-2/SWE-4604-ST-lab/lab-08/chromedriver_mac_arm64/chromedriver.exe");
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins=*");
//        WebDriver driver=new ChromeDriver(option);
//
//        driver.navigate().to("https://demo.opencart.com/admin/");
//
//        driver.findElement(By.name("username")).sendKeys("demo");
//        driver.findElement(By.name("password")).sendKeys("demo");
//        driver.findElement(By.cssSelector("#form-login > div.text-end > button")).submit();
//        driver.close();
        //------------------------//

        HtmlFormTest test1 = new HtmlFormTest();
        test1.testHtmlForm();

        HtmlTableTest test2 = new HtmlTableTest();
        //test2.testHtmlTable();

    }
}






