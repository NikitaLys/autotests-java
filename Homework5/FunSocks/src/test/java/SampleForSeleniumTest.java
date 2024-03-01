import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleForSeleniumTest {
    WebDriver driver;
    String url = "";

    private By locator = By.className("");
    private By locator2 = By.id("");
    private By locator3 = By.cssSelector("");
    private By locator4 = By.id("");

    @Before
    public void setUp() {
        System.setProperty("webdriver.driver.chromedriver", "driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("")
    public void test() {
        driver.findElement(locator);
        driver.findElement(locator2).sendKeys();
        driver.findElement(locator3).click();
        Assert.assertEquals("", "", driver.findElement(locator4));
    }
}
