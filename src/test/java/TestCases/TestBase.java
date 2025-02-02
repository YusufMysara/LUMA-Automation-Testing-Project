package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    String firstName = "Mohammed";
    String lastName = "Ahmed";
    String email = "Hello12345@hello.com";
    String password = "Hello123";
    String confirmPass = "Hello123";
    @BeforeTest
    public void openDriver(){
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void openURL(){
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(5));
    }
    @AfterTest
    public void closeDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
