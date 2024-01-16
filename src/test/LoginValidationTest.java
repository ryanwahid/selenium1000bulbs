import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginValidationTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.1000bulbs.com/login");
    }

    @Test
    public void loginValidationErrorTest() {
        // Trigger error by attempting to log in without entering credentials
        driver.findElement(By.cssSelector("#login_form button[type='submit']")).click();
        WebElement errorText = driver.findElement(By.cssSelector("#login_form .error"));
        Assert.assertEquals(errorText.getText(), "Please fill out all required fields.");

        // Test for incorrect password scenario
        driver.findElement(By.name("login")).sendKeys("ryanwahid@gmail.com");
        driver.findElement(By.name("password")).sendKeys("incorrectpwdtest");
        driver.findElement(By.cssSelector("#login_form button[type='submit']")).click();

        // Assert for the warning message
        WebElement warningText = driver.findElement(By.cssSelector(".warning"));
        Assert.assertTrue(warningText.getText().contains("If you have an active account with 1000bulbs.com"));

        // Assert for the 'Forgot Password' link
        WebElement forgotPasswordLink = driver.findElement(By.cssSelector(".warning > a"));
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot Password");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
