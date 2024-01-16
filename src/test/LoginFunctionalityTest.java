import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginFunctionalityTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.1000bulbs.com/login");
    }

    @Test
    public void loginTest() {
        try {
            WebElement emailField = driver.findElement(By.name("login"));
            emailField.sendKeys("ryanwahid@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("6Dka8SGFJ!c1Ruk$");

            WebElement signInButton = driver.findElement(By.id("login-button"));
            signInButton.click();

            // Add assertions as necessary
        } catch (Exception e) {
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
