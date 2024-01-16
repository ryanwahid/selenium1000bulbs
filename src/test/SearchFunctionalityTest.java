import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFunctionalityTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.1000bulbs.com/");
    }

    @Test
    public void searchTest() {
        WebElement searchField = driver.findElement(By.id("search_field"));
        searchField.sendKeys("c9 led bulbs");

        WebElement searchButton = driver.findElement(By.id("search_button_med"));
        searchButton.click();

        WebElement outputText = driver.findElement(By.cssSelector(".new-filter-results-show > strong"));
        Assert.assertTrue(outputText.getText().contains("c9 led bulbs"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
